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
	
	public static int random(int max) {
		return random(0, max);
	}
	
	public static int random(int min, int max) {
		int diff = max - min + 1;
		return ((int) (Math.random() * diff)) + min;
	}
	
	public static double randomDouble(double min, double max) {
		double diff = max - min;
		return (Math.random() * diff) + min;
	}
	
}
