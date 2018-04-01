package me.cs158.tag.item;

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
	
}
