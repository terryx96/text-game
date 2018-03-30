package me.cs158.tag.item;

public class ItemData {
	
	public static int getStackSize(Items item) {
		switch(item) {
		case NOTHING:
			return 0;
		default: return 0;
		}
	}
	
}
