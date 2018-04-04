package me.cs158.tag.item;

import me.cs158.tag.player.Player;

public abstract class Item {
	
	private String name;
	private Items item;
	
	public Item(Items item) {
		this(item, item.toString());
	}
	
	public Item(Items item, String name) {
		this.item = item;
		this.name = name;
	}
	
	/**
	 * Returns the maximum stack size for this item type
	 * @return	the maximum stack size for this item type
	 */
	public int getStackSize() {
		return ItemData.getStackSize(item);
	}
	
	/**
	 * Returns the name of the item
	 * @return	the name of the item
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	@Override
	public abstract boolean equals(Object o);
	
	@Override
	public Object clone() {
		return this.copy();
	};
	
	/**
	 * Returns a copy of the item
	 * @return	a copy of the item
	 */
	public abstract Item copy();
	
	/**
	 * Uses an item
	 * @param p	the player using the item
	 * @return	true if the the item was successfully used, false otherwise
	 */
	public abstract boolean use(Player p);
	
}
