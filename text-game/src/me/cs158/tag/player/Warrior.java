package me.cs158.tag.player;

public class Warrior extends Player {

	public Warrior(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 11;
		this.defense = 8;	}

	
	@Override
	public String toString() {
		return this.getName() + " Warrior " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: \n" + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();	}
}
