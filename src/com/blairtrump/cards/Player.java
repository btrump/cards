package com.blairtrump.cards;

public class Player {
	private String name;
	private long playerId;
	private Deck deck;

	public Player() {
		this.name = "Random Player";
		this.playerId = System.currentTimeMillis();
		this.deck = new Deck();
//		this.deck.fill(Constants.MAX_DECK_SIZE.getValue());
		this.deck.shuffle();
	}
	
	public Player(String name, Deck deck) {
		this.playerId = System.currentTimeMillis();
		this.name = name;
		this.deck = deck;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Deck getDeck() {
		return this.deck;
	}
	
	public long getPlayerId() {
		return this.playerId;
	}
	
	public String toString() {
		return String.format("Name: %s, ID: %s", this.name, this.playerId);
	}

	public boolean hasCard(Card card) {
		return this.deck.hasCard(card);
	}
	
	public Card getFirstCard() {
		return this.deck.getFirstCard();
	}

}