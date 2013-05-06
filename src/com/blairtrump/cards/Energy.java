package com.blairtrump.cards;

import java.util.Random;

public class Energy {
	private int[] energy;

	public Energy() {
		this.energy = new int[EnergyType.COUNT];
		for (int i = 0; i < EnergyType.COUNT; i++) {
			this.energy[i] = 0;
		}
	}

	public Energy(int[] energy) {
		this.energy = energy;
	}

	public static Energy getRandom() {
		int[] energy = new int[EnergyType.values().length];
		Random g = new Random(System.nanoTime());
		for (int i = 0; i < energy.length; i++) {
			energy[i] = g.nextInt(3);
		}
		return new Energy(energy);
	}

	public String toString() {
		String castingCost = "";

		if (this.isEmpty()) {
			return "no energy";
		}
		for (EnergyType c : EnergyType.values()) {
			if (this.energy[c.ordinal()] > 0) {
				castingCost += String.format("%s%c", this.energy[c.ordinal()],
						c.getSymbol());
			}
		}
		return castingCost;
	}

	public boolean isEmpty() {
		int sum = 0;
		for (int i : this.energy) {
			sum += i;
		}
		return sum == 0;
	}
}
