package me.cs158.tag.player;

import me.cs158.tag.item.MeleeWeapon;

public class Knight extends Player{
	private int shieldBashes;
	
	public Knight(String name, int hp, int m) {
		super(name, hp, m);
	}
	
	@Override
	public String toString() {
		return this.getName() + " Knight " + this.getHealth() + "HP\nInventory: " + this.getInventory();
	}

}
