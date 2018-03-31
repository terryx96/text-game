package me.cs158.tag.player;

import me.cs158.tag.item.MeleeWeapon;

public class Knight extends Player{
	private int shieldBashes;
	
	public Knight(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 8;
		this.defense = 11;
	}
	
	@Override
	public String toString() {
		return this.getName() + " Knight " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: " + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();	}

}
