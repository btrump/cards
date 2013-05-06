package com.blairtrump.cards;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class CardStateMap {
	private HashMap<Card, CardState> cardStates;

	public CardStateMap(ArrayList<Player> players) {
		this.cardStates = new HashMap<Card, CardState>();
		for (Player player : players) {
			for (Card card : player.getDeck().getCards()) {
				this.cardStates.put(card, new CardState());
			}
		}
	}

	public CardState getCardState(Card card) {
		return this.cardStates.get(card);
	}
	
	public CardState update(Card card, CardState cardState) {
		return this.cardStates.put(card, cardState);
	}
	
	public String toString() {
		String out = "";
		for(Map.Entry<Card, CardState> cardStatePair : this.cardStates.entrySet()) {
			out += String.format("%s, States: %s\n", cardStatePair.getKey(), cardStatePair.getValue());
		}
		return out;
	}
}
