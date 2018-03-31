package me.cs158.tag.inventory;

import me.cs158.tag.player.Player;

public class PlayerInventory extends Inventory {
	
	private Player owner;
	
	public PlayerInventory(Player owner, int size) {
		super(size);
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
}
