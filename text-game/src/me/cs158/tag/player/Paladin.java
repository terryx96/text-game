package me.cs158.tag.player;

public class Paladin extends Player {

	public Paladin(String name, int hp, int m) {
		super(name, hp, m);
		//this.inventory.addItem(new MeleeWeapon("LongSword")); 
	}

	
	@Override
	public String toString() {
		return this.getName() + " Paladin " + this.getHealth() + "HP\nInventory: " + this.getInventory();
	}
}
