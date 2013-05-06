package com.blairtrump.cards;

import java.util.ArrayList;

public class GameEvent {
	public enum Type {
		BATTLE, CAST_SPELL, PLAY_SOURCE, RESOLVE_PHASE, SUMMON, TAP_SOURCE, USE_ABILITY;

		public void RESOLVE_PHASE(Phase phase) {
			switch (phase) {
			case DRAW:
			case REFRESH:
			case PRESERVE:
			default:
				break;
			}
		}
		
		public static Type random() {
			java.util.Random g = new java.util.Random(System.nanoTime());
			
			return Type.values()[g.nextInt(Type.values().length)];
		}
	}

	private Type type;
	private Card actor;
	private ArrayList<Object> targets;
	private ArrayList<Card> defenders;
	private Battle battle;

	public GameEvent() {
	}
	
	public GameEvent(GameEvent.Type type) {
		this.type = type;

		switch(type) {
		case BATTLE:
			this.battle = new Battle();
		case RESOLVE_PHASE:
		case USE_ABILITY:
		case PLAY_SOURCE:
		case TAP_SOURCE:
		case CAST_SPELL:
		case SUMMON:
		}
	}
	
	public static GameEvent random() {
		GameEvent event = new GameEvent();
		event.setType(GameEvent.Type.random());
		
		switch(event.type) {
		case BATTLE:
		case RESOLVE_PHASE:
		case USE_ABILITY:
		case PLAY_SOURCE:
		case TAP_SOURCE:
		case CAST_SPELL:
		case SUMMON:
			System.out.println(event.type);
		}
		
		return event;
	}
	
	public void print() {
		System.out.print(this.toString());
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Card getActor() {
		return actor;
	}

	public void setActor(Card actor) {
		this.actor = actor;
	}

	public ArrayList<Object> getTargets() {
		return targets;
	}

	public void setTargets(ArrayList<Object> targets) {
		this.targets = targets;
	}

	public ArrayList<Card> getDefenders() {
		return defenders;
	}

	public void setDefenders(ArrayList<Card> defenders) {
		this.defenders = defenders;
	}
	
	public Battle getBattle() {
		return this.battle;
	}

	@Override
	public String toString() {
		return "GameEvent [type=" + type + ", actor=" + actor + ", targets="
				+ targets + ", defenders=" + defenders + ", battle=" + battle
				+ "]";
	}
}