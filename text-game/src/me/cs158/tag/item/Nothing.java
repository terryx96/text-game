package me.cs158.tag.item;

public class Nothing extends Item {
	
	private static final Items ITEM = Items.NOTHING;
	
	public Nothing() {
		super(ITEM, ITEM.toString());
	}
	
}
