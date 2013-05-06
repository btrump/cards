package com.blairtrump.cards;

import java.util.ArrayList;
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

	private long gameId;
	private GameState gameState;
	private ArrayList<Player> players;
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

	public void print() {
		String out = String.format(
				"Game ID: %s\nPlayer 1:%s\nPlayer 2:%s\nCurrent Game State:%s",
				this.gameId, this.players.get(0), this.players.get(1),
				this.getGameState());
		System.out.println(out);
		this.eventLog.toString();
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
}