package com.blairtrump.cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.List;

public enum CardType {
	SPELL, SPIRIT, BUILDING, RESOURCE;
	private static final List<CardType> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
	private static final int SIZE = values().length;
	private static final Random g = new Random(System.nanoTime());

	public static CardType random() {
		return VALUES.get(g.nextInt(SIZE));
	}
}
