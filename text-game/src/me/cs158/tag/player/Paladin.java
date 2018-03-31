package me.cs158.tag.player;

public class Paladin extends Player {

	public Paladin(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 7;
		this.defense = 7;
	}

	
	@Override
	public String toString() {
		return this.getName() + " Paladin " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: \n" + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();	}
}
