package me.cs158.tag.item;

public class ItemData {
	
	public static int getStackSize(Items item) {
		switch(item) {
		case NOTHING:
			return 0;
		case BROADSWORD:
			return 1;
		default: return 0;
		}
	}
	
	public static Items getItemType(Item item) {
		if(item instanceof BroadSword) {
			return Items.BROADSWORD;
		}
		
		//default
		return Items.NOTHING;
	}
	
}
