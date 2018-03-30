package me.cs158.tag.player;

public class Warrior extends Player {

	public Warrior(String name, int hp, int m) {
		super(name, hp, m);
		//this.inventory.addItem(new MeleeWeapon("ShortSword")); 
	}

	
	@Override
	public String toString() {
		return this.getName() + " Warrior " + this.getHealth() + "HP\nInventory: " + this.getInventory();
	}
}
