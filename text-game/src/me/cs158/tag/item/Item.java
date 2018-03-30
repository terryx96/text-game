package me.cs158.tag.item;

public class Item {
	
	private String name;
	private int stackSize;
	
	public Item(String name, int stackSize) {
		this.name = name;
		this.stackSize = stackSize;
	}
	
	public int getStackSize() {
		return stackSize;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
