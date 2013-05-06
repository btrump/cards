package com.blairtrump.cards;

import java.util.LinkedList;

public class Deck {
	private LinkedList<Card> cards;

	public Deck() {
		this.cards = new LinkedList<Card>();
	}
	
	public Deck(LinkedList<Card> cards) {
		this.cards = cards;
	}
	
	public Deck(Card card) {
		this.cards = new LinkedList<Card>();
		cards.add(card);
	}
	public LinkedList<Card> getCards() {
		return this.cards;
	}

	public void pushCard(Card card) {
		this.cards.add(card);
	}

	public Card popCard() {
		return this.cards.removeLast();
	}
	
	public Card getFirstCard() {
		return this.cards.getFirst();
	}

	public int size() {
		return this.cards.size();
	}

	public void shuffle() {
		return;
	}

	public String toString() {
		String output = String.format("%s cards: \n", this.cards.size());
		for (Card c : this.cards) {
			output += String.format("%s. %s\n", this.cards.indexOf(c) + 1,
					c.toString());
		}

		return output;
	}

	public void fillFromStack(Deck sourceStack, int numCards) {
		for (int i = 0; i < numCards; i++) {
			this.pushCard(sourceStack.popCard());
		}
	}

	public boolean hasCard(Card card) {
		return this.cards.contains(card);
	}
}