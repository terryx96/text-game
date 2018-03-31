package me.cs158.tag.inventory;

import me.cs158.tag.player.Player;

public class PlayerInventory extends Inventory {
	
	private Player owner;
	private int itemStart;
	
	public PlayerInventory(Player owner, int weaponSize, int itemSize) {
		super(weaponSize + itemSize);
		itemStart = weaponSize;
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
}
