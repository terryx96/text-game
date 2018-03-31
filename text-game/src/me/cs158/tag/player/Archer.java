package me.cs158.tag.player;

import me.cs158.tag.main.Util;

public class Archer extends Player {
	
	
	public Archer(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 5;
		this.defense = 6;
	}

	@Override
	public int ability() {
		System.out.println("You fire a special arrow!");
		this.takeMana(30);
		return Util.random(3, 10);
	}
	
	@Override
	public String toString() {
		return this.getName() + " Archer " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: " + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();
	}
}
