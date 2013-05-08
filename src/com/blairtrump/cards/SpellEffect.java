package com.blairtrump.cards;

import java.util.Random;

/**
 * A persistent effect on a player or card that results from an action.
 */
public class SpellEffect {
	public enum Type {
		OVER_TIME, HITPOINT_MOD, ATTACK_MOD, EXHAUST
	}

	private Type type;
	private int value;
	private int duration;

	public SpellEffect() {
	}

	public SpellEffect(Type type, int value, int duration) {
		this.type = type;
		this.setValue(value);
		this.setDuration(duration);
	}

	public static SpellEffect random() {
		SpellEffect effect = new SpellEffect();
		Random g = new Random(System.nanoTime());
		effect.type = Type.values()[g.nextInt(Type.values().length)];
		return effect;
	}

	public Type getEffect() {
		return type;
	}

	public void setEffect(Type effect) {
		this.type = effect;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
}