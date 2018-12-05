package com.graph.service.strategies;

public final class RelevanceFactory {

	public final static String FRIEND_OF_FRIEND = "FRIEND_OF_FRIEND";
	public final static String FRIEND = "FRIEND";
	public final static String ALL = "ALL";
	
	
	private RelevanceFactory() {
		
	}
	
	public static RelevanceStrategy createStrategy(String strategy) {
		if(strategy.equals(FRIEND)) {
			return new FriendStrategy();
		}else if(strategy.equals(FRIEND_OF_FRIEND)) {
			return new FriendOfFriendStrategy();
		}else if(strategy.equals(ALL)) {
			return new AllUsersStrategy();
		}
		return null;
	}
}
