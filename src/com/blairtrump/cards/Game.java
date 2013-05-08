package com.blairtrump.cards;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Game {
	public enum Constants {
		STARTING_HAND_SIZE(7), MAX_DECK_SIZE(20), STARTING_PLAYER_HP(20);
		int intValue;
		String stringValue;

		private Constants(int value) {
			this.intValue = value;
		}

		private Constants(String value) {
			this.stringValue = value;
		}

		public int getValue() {
			return intValue;
		}
	}
	private class GameState {
		private int turnCounter;
		private ArrayList<Player> players;
		private ArrayList<Player> turnOrder;
		private CardStateMap cardStates;
		private PlayerStateMap playerStates;

		public GameState(ArrayList<Player> players) {
			this.turnCounter = 0;
			this.players = players;
			// TODO: need a way to define or randomize the turn order
			this.turnOrder = players;
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

		public Player getCardOwner(Card card) throws Exception {
			for (Player player : players) {
				if (player.hasCard(card))
					return player;
			}
			throw new Exception();
		}

		public GameState update(GameEvent event) {
			return this;
		}

		public String toString() {
			return String
					.format("Turn #%s.  %s players.  %s's turn.\nCard states:\n%sPlayer states:\n%s",
							this.turnCounter + 1, this.players.size(),
							getCurrentPlayerTurn(), this.cardStates, this.playerStates);
		}

		/**
		 * @param turnOrder the turnOrder to set
		 */
		public void setTurnOrder(ArrayList<Player> turnOrder) {
			this.turnOrder = turnOrder;
		}
	}

	private long gameId;
	private GameState gameState;
	private ArrayList<Player> players;

	/**
	 * @return the gameId
	 */
	public long getGameId() {
		return gameId;
	}

	/**
	 * @param gameId
	 *            the gameId to set
	 */
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	/**
	 * @return the eventLog
	 */
	public LinkedList<GameEvent> getEventLog() {
		return eventLog;
	}

	/**
	 * @param eventLog
	 *            the eventLog to set
	 */
	public void setEventLog(LinkedList<GameEvent> eventLog) {
		this.eventLog = eventLog;
	}

	/**
	 * @param gameState
	 *            the gameState to set
	 */
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	private LinkedList<GameEvent> eventLog;

	public Game() {
		this.gameId = System.currentTimeMillis();
		this.eventLog = new LinkedList<GameEvent>();
		this.players = new ArrayList<Player>();
		for (int i = 0; i < 2; i++) {
			this.players.add(new Player());
		}
		this.gameState = new GameState(this.players);
	}

	public Game(ArrayList<Player> players) {
		this.gameId = System.currentTimeMillis();
		this.eventLog = new LinkedList<GameEvent>();
		this.players = players;
		this.gameState = new GameState(players);
	}

	public void print() {
		String out = String.format(
				"Game ID: %s\nPlayer 1:%s\nPlayer 2:%s\nCurrent Game State:%s",
				this.gameId, this.players.get(0), this.players.get(1),
				this.getGameState());
		System.out.println(out);
		this.eventLog.toString();
	}

	@Override
	public String toString() {
		return String.format("Game %s: %s players, %s turns", this.gameId,
				this.players.size(), this.eventLog.size());
	}

	public GameState getGameState() {
		return this.gameState;
	}

	public String getPlayersAsString() {
		String players = "";

		for (Player p : this.players) {
			players += p.toString();
		}

		return players;
	}

	public void printPlayers() {
		System.out.println(getPlayersAsString());
	}

	public static void main(String[] args) throws Exception {
		try {
			Game game = new Game();
			GameEvent event = GameEvent.random();

			System.out.println(game);
			System.out.println(event);
			// event.getBattle().resolve();
		} finally {

		}
		// catch (NullPointerException e) {
		// System.out.println("Exception: " + e);
		// } catch (Exception e) {
		// System.out.println("Exception: " + e.getCause());
		// }
	} // main()

	public int getTurn() {
		return this.gameState.turnCounter;
	}

	/**
	 * Advances the game one turn, incrementing the turn counter and advancing the current player
	 */
	public int advanceTurn() {
		return ++this.gameState.turnCounter;
	}

	/**
	 * Determines whose turn it is based on the turn counter.
	 * @return Player
	 */
	public Player getCurrentPlayerTurn() {
		return this.gameState.turnOrder.get(this.gameState.turnCounter % this.players.size());
	}

	public ArrayList<Player> getTurnOrder() {
		return this.gameState.turnOrder;
	}
}