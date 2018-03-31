package me.cs158.tag.player;

public class Wizard extends Player {
	private int spell;
	
	public Wizard(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 3;
		this.defense = 5;	
		}

	
	@Override
	public String toString() {
		return this.getName() + " Wizard " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: " + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();	}
	
}
