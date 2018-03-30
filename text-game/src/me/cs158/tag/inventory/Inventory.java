package me.cs158.tag.inventory;

import java.util.ArrayList;

import me.cs158.tag.main.Main.SUCCESS;
import me.cs158.tag.main.Util;

public class Inventory {
	
	private int size;
	private ArrayList<ItemStack> items;
	
	public Inventory(int size) {
		this.size = size;
		items = new ArrayList<ItemStack>(size);
	}
	
	public ArrayList<ItemStack> getItems() {
		return Util.cloneList(items);
	}
	
	public int getSize() {
		return size;
	}
	
	public int getOccupiedSlots() {
		return items.size();
	}
	
	public int getOpenSlots() {
		return size - items.size();
	}
	
	public boolean setSize(int size) {
		if(size >= items.size()) {
			this.size = size;
			return true;
		}
		return false;
	}
	
	public SUCCESS addItem(ItemStack add) {
		for(ItemStack is : items) {
			if(is.getItem().equals(add.getItem())) {
				if(is.getAvailability() >= add.getCount()) {
					add.remove(add.getCount());
					is.add(add.getCount());
					return SUCCESS.TRUE;
				} else {
					int c = is.getAvailability();
					add.remove(c);
					is.add(c);
				}
			}
		}
	}
	
}
