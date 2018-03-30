package me.cs158.tag.player;

public class Wizard extends Player {
	private int spell;
	
	public Wizard(String name, int hp, int m) {
		super(name, hp, m);
		//this.inventory.addItem(new Weapon("Staff")); will add a staff to his inventory evnetually
	}

	
	@Override
	public String toString() {
		return this.getName() + " Wizard " + this.getHealth() + "HP\nInventory: " + this.getInventory();
	}
	
}
