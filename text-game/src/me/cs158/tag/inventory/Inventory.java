package me.cs158.tag.inventory;

import java.util.ArrayList;

import me.cs158.tag.main.Main.SUCCESS;
import me.cs158.tag.item.Items;
import me.cs158.tag.main.Util;

public class Inventory {
	
	private int size;
	private ArrayList<ItemStack> items;
	
	public Inventory(int size) {
		this.size = size;
		items = new ArrayList<ItemStack>(size);
		for(int i = 0;i < size;i++) {
			items.add(new ItemStack(Items.NOTHING, 0));
		}
	}
	
	public ArrayList<ItemStack> getItems() {
		return Util.cloneList(items);
	}
	
	public int getSize() {
		return size;
	}
	
	public int getOccupiedSlots() {
		int count = 0;
		for(ItemStack is : items) {
			if(is.getItem() != Items.NOTHING)
				count++;
		}
		return count;
	}
	
	public int getOpenSlots() {
		return size - getOccupiedSlots();
	}
	
	public boolean setSize(int size) {
		if(size > this.size) {
			for(int i = this.size;i < size;i++) {
				items.set(i, new ItemStack(Items.NOTHING, 0));
			}
			this.size = size;
			return true;
		} else if(size < this.size && size >= getOccupiedSlots()) {
			int index = size;
			for(int i = size;i < this.size;i++) {
				items.remove(index);
			}
			return true;
		}
		return false;
	}
	
	public SUCCESS addItem(ItemStack add) {
		SUCCESS success = SUCCESS.FALSE;
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
					success = SUCCESS.PARTIAL;
				}
			}
		}
		for(int i = 0;i < items.size();i++) {
			ItemStack is = items.get(i);
			if(is.getItem() == Items.NOTHING) {
				items.set(i, add);
				return SUCCESS.TRUE;
			}
		}
		return success;
	}
	
}
