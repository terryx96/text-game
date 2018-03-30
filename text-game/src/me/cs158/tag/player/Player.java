package me.cs158.tag.player;

import me.cs158.tag.inventory.Inventory;

public abstract class Player {
	private String name;
	protected Inventory inventory;
	private int health;
	private int mana;
	
	public Player(String name, int hp, int m) {
		this.name = name;
		this.inventory = new Inventory(10);
		this.health = hp;
		this.mana = m;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getInventory() {
		return this.inventory.toString();
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	@Override
	public String toString() {
		return "I am a player";
	}
	
	public void takeDamage(int x) {
		this.health-=x;
	}
	
	public void takeHealth(int x) {
		this.health+=x;
	}
	
	public void useMana(int x) {
		this.mana-=x;
	}
	
	public void takeMana(int x) {
		this.mana+=x;
	}
}
