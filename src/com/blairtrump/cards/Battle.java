package com.blairtrump.cards;

import java.util.ArrayList;

public class Battle {
	protected class Fight {
		private Card attacker;
		private Object defender;

		public Fight() {
		}

		public Fight(Card attacker, Object defender) {
			this.attacker = attacker;
			this.defender = defender;
		}

		public Card getAttacker() {
			return attacker;
		}

		public void setAttacker(Card attacker) {
			this.attacker = attacker;
		}

		public Object getDefender() {
			return defender;
		}

		public void setDefender(Object defender) {
			this.defender = defender;
		}

		@Override
		public String toString() {
			return "Fight [attacker=" + attacker + ", defender=" + defender
					+ "]";
		}

//		public void resolve() {
//			((CardSummon)this.defender).removeHp(((CardSummon)this.attacker).getAtk());
//			((CardSummon)this.attacker).removeHp(((CardSummon)this.defender).getAtk());
//			
////			this.defender = (CardSummon)this.defender;
////			System.out.println(this.attacker.getClass());
////			this.attacker
////			System.out.println(attacker);
////			System.out.println(defender);
//		}

		public void removeDefender() {
			this.defender = null;
		}

		public boolean noDefender() {
			return defender == null;
		}

	}

	private ArrayList<Fight> fights;
	private Player attacker;
	private Player defender;

	public Battle() {
		this.fights = new ArrayList<Fight>();
	}
	
	public ArrayList<Fight> getFights() {
		return fights;
	}

	public void setFights(ArrayList<Fight> fights) {
		this.fights = fights;
	}

	public void addFight(Fight fight) {
		this.fights.add(fight);
	}

	public void addAttacker(Card attacker) {
		Fight fight = new Fight();
		fight.setAttacker(attacker);
		this.fights.add(fight);
	}

	public void assignDefender(Card attacker, Card defender) {
		for(Fight fight : this.fights) {
			if(fight.attacker.equals(attacker)) {
				fight.setDefender(defender);
				return;
			}
		}
		// otherwise attacker does not exist
		// TODO: need something better here than NULL checking
	}
	
	@Override
	public String toString() {
		return "Battle [fights=" + fights + "]";
	}

	public Player getAttacker() {
		return attacker;
	}

	public void setAttacker(Player attacker) {
		this.attacker = attacker;
	}

	public Player getDefender() {
		return defender;
	}

	public void setDefender(Player defender) {
		this.defender = defender;
	}
}