package com.blairtrump.cards;

import java.util.LinkedList;

public class CardState {
	public enum Location {
		IN_HAND, IN_DECK, IN_GRAVEYARD, IN_PLAY, EXHAUSTED, IN_RED_ZONE;
	}

	private Location location;
	private LinkedList<SpellEffect> effect;

	public CardState() {
		this.location = Location.IN_DECK;
		this.effect = new LinkedList<SpellEffect>();
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public LinkedList<SpellEffect> getEffect() {
		return effect;
	}

	public void setEffect(LinkedList<SpellEffect> effect) {
		this.effect = effect;
	}
}
