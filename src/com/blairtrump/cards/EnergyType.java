package com.blairtrump.cards;

public enum EnergyType {
	EARTH("Earth"), FIRE("Fire"), AIR("Air"), WATER("Water"), MACHINA("Machina");
	
	String name;
	public static final int COUNT = EnergyType.values().length;
	
	private EnergyType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getSymbol() {
		return this.name.toLowerCase().charAt(0);
	}
}
