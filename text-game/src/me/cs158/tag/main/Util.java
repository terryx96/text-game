package me.cs158.tag.main;

import java.util.ArrayList;

import me.cs158.tag.inventory.ItemStack;

public class Util {
	
	/**
	 * Returns a list of cloned items
	 * @param list	the list from which to clone the objects
	 * @return	a list containing cloned objects from the specified list
	 */
	public static ArrayList<ItemStack> cloneList(ArrayList<ItemStack> list) {
		ArrayList<ItemStack> cloned = new ArrayList<ItemStack>(list.size());
		for(ItemStack is : list) {
			cloned.add(new ItemStack(is.getItem(), is.getCount()));
		}
		return cloned;
	}
	
	/**
	 * Returns a random integer between 0 and a value
	 * @param max	the maximum output value
	 * @return	a random integer between 0 and the specified value
	 */
	public static int random(int max) {
		return random(0, max);
	}
	
	/**
	 * Returns a random integer between two values
	 * @param min	the minimum output value
	 * @param max	the maximum output values
	 * @return	a random integer between the specified values
	 */
	public static int random(int min, int max) {
		int diff = max - min + 1;
		return ((int) (Math.random() * diff)) + min;
	}
	
	/**
	 * Returns a random double between two values
	 * @param min	the minimum output value
	 * @param max	the maximum output value
	 * @return	a random double between the specified values
	 */
	public static double randomDouble(double min, double max) {
		double diff = max - min;
		return (Math.random() * diff) + min;
	}
	
}
