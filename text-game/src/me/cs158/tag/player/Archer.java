package me.cs158.tag.player;

public class Archer extends Player {
	
	
	public Archer(String name, int hp, int m) {
		super(name, hp, m);
		//this.inventory.addItem(new Weapon("Bow")); 
	}

	
	@Override
	public String toString() {
		return this.getName() + " Archer " + this.getHealth() + "HP\nInventory: " + this.getInventory();
	}
}
