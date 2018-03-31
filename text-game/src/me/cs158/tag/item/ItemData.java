package me.cs158.tag.item;

public class ItemData {
	
	public static int getStackSize(Items item) {
		switch(item) {
		case NOTHING:
			return 0;
		case BROADSWORD:
		case KEY:
		case BOW:
			return 1;
		case MANA_POTION:
			return 3;
		default: return 0;
		}
	}
	
	public static Items getItemType(Item item) {
		if(item instanceof BroadSword) {
			return Items.BROADSWORD;
		}
		if(item instanceof ManaPotion) {
			return Items.MANA_POTION;
		}
		if(item instanceof Key) {
			return Items.KEY;
		}
		
		//default
		return Items.NOTHING;
	}
	
}
