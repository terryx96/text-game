package me.cs158.tag.item;

public class ItemData {
	
	/**
	 * Returns the maximum stack size for an item type
	 * @param item	the item type
	 * @return	the maximum stack size for the specified item type
	 */
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
	
	/**
	 * Get the type of an item
	 * @param item	the item
	 * @return	the type of the specified item
	 */
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
		if(item instanceof Bow) {
			return Items.BOW;
		}
		
		//default
		return Items.NOTHING;
	}
	
}
