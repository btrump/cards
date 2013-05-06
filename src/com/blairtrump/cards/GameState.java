package com.blairtrump.cards;

import java.util.ArrayList;
import java.util.HashMap;

public class GameState {
	private int turnCounter;
	private int playerTurn;
	private ArrayList<Player> players;
	private CardStateMap cardStates;
	private PlayerStateMap playerStates;

	public GameState(ArrayList<Player> players) {
		this.turnCounter = 0;
		this.playerTurn = 0;
		this.players = players;
		this.cardStates = new CardStateMap(players);
		HashMap<Player, PlayerState> playerStates = new HashMap<Player, PlayerState>();
		for(Player player : players) {
			playerStates.put(player, new PlayerState(20));
		}
		this.playerStates = new PlayerStateMap(playerStates); 
	}

	public CardState getCardState(Card card) {
		return this.cardStates.getCardState(card);
	}

	public PlayerState getPlayerState(Player player) {
		return playerStates.getPlayerState(player);
	}

	public int getTurn() {
		return this.turnCounter;
	}

	public Player getCardOwner(Card card) throws Exception {
		for (Player player : players) {
			if (player.hasCard(card))
				return player;
		}
		throw new Exception();
	}

	public GameState update(GameEvent event) {
		switch (event.getType()) {
		case BATTLE:
			// handleBattle(event);
		case RESOLVE_PHASE:
		case USE_ABILITY:
		case PLAY_SOURCE:
		case TAP_SOURCE:
		case CAST_SPELL:
		case SUMMON:
		}
		return this;
	}

	public void setTurn(int player) {
		this.playerTurn = player;
	}

	public int advanceTurn() {
		return ++this.turnCounter;
	}

	public String toString() {
		return String
				.format("Turn #%s.  %s players.  %s's turn.\nCard states:\n%sPlayer states:\n%s",
						this.turnCounter + 1, this.players.size(),
						this.playerTurn, this.cardStates, this.playerStates);
	}
}