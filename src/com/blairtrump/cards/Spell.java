package com.blairtrump.cards;

/**
 * The product of a source card that causes an immediate and/or persistent
 * effect on one or more target cards.
 */
public class Spell {
	private Energy castingCost;

	/**
	 * @return the castingCost
	 */
	public Energy getCastingCost() {
		return castingCost;
	}

	/**
	 * @param castingCost the castingCost to set
	 */
	public void setCastingCost(Energy castingCost) {
		this.castingCost = castingCost;
	}
}
