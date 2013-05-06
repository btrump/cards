package com.blairtrump.cards;

import java.util.ArrayList;

public class CardAttribute {
	private String name;
	private String nameShort;
	private ArrayList<Integer> values;
	private int id;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the nameShort
	 */
	public String getNameShort() {
		return nameShort;
	}

	/**
	 * @param nameShort
	 *            the nameShort to set
	 */
	public void setNameShort(String nameShort) {
		this.nameShort = nameShort;
	}

	/**
	 * @return the values
	 */
	public ArrayList<Integer> getValues() {
		return values;
	}

	/**
	 * @param values
	 *            the values to set
	 */
	public void setValues(ArrayList<Integer> values) {
		this.values = values;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}