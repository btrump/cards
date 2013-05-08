package com.blairtrump.cards;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

/**
 * 1. Game advances turn, listens to next player
 * 2. Player draws a card
 * 2. Generate legal action table
 * 3. Action is selected by player
 * 4. Action is passed to Game by Player
 * 5. Game creates a GameEvent from the action of type Action 
 * 6. GameState processes GameEvent transition
 * 7. Returns to Game, update frontend/players on new GameState
 * 8. Advances to next player
 */
public class GameTest {
	final int NUM_PLAYERS = 4;
	private Game game;

	@Before
	public void setUp() throws Exception {
		ArrayList<Player> players = new ArrayList<Player>();
		for(int i=0; i < this.NUM_PLAYERS; i++) {
			players.add(new Player());
		}
		
		this.game = new Game(players);
	}

	@Test
	public void testPlayerCount() {
		assertEquals(String.format("Player count should be %s", this.NUM_PLAYERS), this.NUM_PLAYERS, game.getPlayers().size());
	}
	
	@Test
	public void testInitialTurn() {
		assertEquals("Should be turn 0", this.game.getTurn(), 0);
	}
	
	@Test
	public void testAdvanceTurn() {
		int goalTurn = 10;
		Player goalPlayer = this.game.getTurnOrder().get(goalTurn/this.NUM_PLAYERS);
		for(int i=0; i < goalTurn; i++) {
			this.game.advanceTurn();
		}
		assertEquals(String.format("Should be turn %s", goalPlayer), goalPlayer, this.game.getCurrentPlayerTurn());
	}
}