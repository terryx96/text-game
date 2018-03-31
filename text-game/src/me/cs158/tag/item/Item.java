package me.cs158.tag.item;

public class Item {
	
	private String name;
	private Items item;
	
	public Item(Items item) {
		this(item, item.toString());
	}
	
	public Item(Items item, String name) {
		this.item = item;
		this.name = name;
	}
	
	public int getStackSize() {
		return ItemData.getStackSize(item);
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}