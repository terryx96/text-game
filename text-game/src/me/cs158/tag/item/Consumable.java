package me.cs158.tag.item;

public abstract class Consumable extends Item {

	public Consumable(Items item) {
		super(item);
	}
	
	public Consumable(Items item, String name) {
		super(item, name);
	}
	
}
