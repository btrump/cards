package com.blairtrump.cards;

import java.util.HashMap;
import java.util.Map;

public class PlayerStateMap {
	private HashMap<Player, PlayerState> playerStates;
	
	public PlayerStateMap(HashMap<Player, PlayerState> playerStates) {
		this.playerStates = playerStates; 
	}
	
	public PlayerState getPlayerState(Player player) {
		return playerStates.get(player);
	}
	
	public String toString() {
		String out = "";
		for(Map.Entry<Player, PlayerState> playerStatePair : this.playerStates.entrySet()) {
			out += String.format("%s, state: %s\n", playerStatePair.getKey(), playerStatePair.getValue());
		}
		return out;
	}

	public void removeHp(Player player, int hp) {
		playerStates.get(player).removeHp(hp);
	}

	public boolean isDead(Player player) {
		return playerStates.get(player).isDead();
	}
}