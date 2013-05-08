package com.blairtrump.cards;

import java.util.Random;
import java.util.ArrayList;

public class Card {
	private String name;
	private String flavorText;
	private CardType cardType;
	private ArrayList<CardAttribute> attributes = new ArrayList<CardAttribute>();
	private ArrayList<Spell> spells = new ArrayList<Spell>();

	public Card() {
		this.name = generateRandomName(LanguageBlock.FANTASY);
		this.flavorText = "Placeholder text here";
	}
	
	public Card(String name, String flavorText, CardType cardType) {
		this.name = name;
		this.flavorText = flavorText;
		this.cardType = cardType;
	}
	
	public static Card generate(CardType cardType, ArrayList<CardAttribute> attributes, ArrayList<Spell> spells) {
		Card card = new Card();
		card.cardType = cardType;
		card.attributes = attributes;
		card.spells = spells;
		return card;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}

	private String generateRandomName(LanguageBlock language) {
		Random g = new Random(System.nanoTime());
		String[] nameBlocks = language.getBlocks();
		String[] names = new String[g.nextInt(3) + 1];
		String finalName = "";

		// Build a random name for each of the 1-3 names from the name blocks
		for (int i = 0; i < names.length; i++) {
			names[i] = "";
			int numBlocksInName = g.nextInt(3) + 1;
			for (int j = 0; j < numBlocksInName; j++) {
				names[i] += nameBlocks[g.nextInt(nameBlocks.length)];
			}
		}

		// Titlecase name
		for (int i = 0; i < names.length; i++) {
			names[i] = names[i].substring(0, 1).toUpperCase()
					+ names[i].substring(1);
			if (!finalName.isEmpty())
				finalName += " ";
			finalName += names[i];
		}
		return finalName;
	}

	public CardType getCardType() {
		return this.cardType;
	}

	/**
	 * @return the attributes
	 */
	public ArrayList<CardAttribute> getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(ArrayList<CardAttribute> attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the actions
	 */
	public ArrayList<Spell> getActions() {
		return spells;
	}

	/**
	 * @param actions the actions to set
	 */
	public void setActions(ArrayList<Spell> actions) {
		this.spells = actions;
	}
}