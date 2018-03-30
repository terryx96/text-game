package me.cs158.tag.main;

import java.util.ArrayList;

import me.cs158.tag.inventory.ItemStack;

public class Util {
	
	public static ArrayList<ItemStack> cloneList(ArrayList<ItemStack> list) {
		ArrayList<ItemStack> cloned = new ArrayList<ItemStack>(list.size());
		for(ItemStack is : list) {
			cloned.add(new ItemStack(is.getItem(), is.getCount()));
		}
		return cloned;
	}
	
}
