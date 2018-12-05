package com.graph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.graph.service.SimilarityService;
import com.graph.service.exceptions.MovieNotFoundException;
import com.graph.service.exceptions.StrategyNotFound;
import com.graph.service.exceptions.UserNotFoundException;

@RestController
@RequestMapping(value = "api")
public class MainController {

	@Autowired
	private SimilarityService service;

	@RequestMapping(method = RequestMethod.GET, value = "/relevance")
	public CustomResponse relevance(@RequestParam String personName, @RequestParam String movieName,
			@RequestParam String strategy) {
		try {
			long time = System.currentTimeMillis();
			float r = this.service.getRelevance(personName, movieName, strategy);
			time = System.currentTimeMillis() - time;
			if (r >= 0) {
				return new CustomResponse(r, "", true, HttpStatus.OK.value(), time);
			} else {
				return new CustomResponse(r,
						"Não foi possível calcular a relevância devido a insuficiência de dados coletados", true,
						HttpStatus.OK.value(), time);
			}

		} catch (UserNotFoundException | MovieNotFoundException | StrategyNotFound e) {
			return new CustomResponse(null, e.getMessage(), false, HttpStatus.BAD_REQUEST.value(), null);
		}
	}

}
