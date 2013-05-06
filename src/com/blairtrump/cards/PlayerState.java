package com.blairtrump.cards;

public class PlayerState {
	private int hp;
	private Energy energy;
	
	public PlayerState(int hp) {
		this.hp = hp;
		this.energy = new Energy();
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public Energy getEnergy() {
		return energy;
	}

	public void setEnergy(Energy energy) {
		this.energy = energy;
	}
	
	public String toString() {
		return String.format("HP: %s, energy: %s", this.hp, this.energy);
	}

	public void removeHp(int hp) {
		this.hp -= hp;
	}

	public boolean isDead() {
		return hp < 1;
	}
}
