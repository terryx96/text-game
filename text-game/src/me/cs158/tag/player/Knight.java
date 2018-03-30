package me.cs158.tag.player;

public class Knight extends Player{
	private int shieldBashes;
	
	public Knight(String name, int hp, int m) {
		super(name, hp, m);
		//this.inventory.addItem(new MeleeWeapon("Sword")); will add a knightly broadsword to his inventory
		//this.inventory.addItem(new Item("Shield")); will add a knightly shield to his inventory
	}
	
	@Override
	public String toString() {
		return this.getName() + " Knight " + this.getHealth() + "HP\nInventory: " + this.getInventory();
	}

}
