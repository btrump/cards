package com.blairtrump.cards;

import java.util.ArrayList;

public class PlayerAction {
	public enum Type {
		INITIATE_BATTLE, CAST_SPELL, PLAY_SOURCE, SUMMON, USE_CARD, DRAW_CARD;

		public static Type random() {
			java.util.Random g = new java.util.Random(System.nanoTime());

			return Type.values()[g.nextInt(Type.values().length)];
		}
	}
	
	private Type type;
	private Object subject;
	
//	public PlayerAction(Type type, Object subject) {
//		// TODO: Investigate casting in Java
//		switch(type) {
//		case CAST_SPELL:
//			
//		case DRAW_CARD:
//		case INITIATE_BATTLE:
//			// actor is an ArrayList of attacking cards
//			// actor = ((ArrayList<Card>) actor);
//		case PLAY_SOURCE:
//		case SUMMON:
//		case USE_CARD:
//		default:
//			break;
//		}
//	}
	public PlayerAction(Type type, Object subject) {
		this.type = type;
		this.subject = subject;
	}
}
