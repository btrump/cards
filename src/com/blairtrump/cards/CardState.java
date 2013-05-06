package com.blairtrump.cards;

import java.util.LinkedList;

public class CardState {
	public enum Location {
		IN_HAND, IN_DECK, IN_GRAVEYARD, IN_PLAY, EXHAUSTED, IN_RED_ZONE;
	}

	private Location location;
	private LinkedList<ActionEffect> effect;

	public CardState() {
		this.location = Location.IN_DECK;
		this.effect = new LinkedList<ActionEffect>();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public LinkedList<ActionEffect> getEffect() {
		return effect;
	}

	public void setEffect(LinkedList<ActionEffect> effect) {
		this.effect = effect;
	}
}
