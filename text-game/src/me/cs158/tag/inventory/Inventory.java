package me.cs158.tag.inventory;

import java.util.ArrayList;

import me.cs158.tag.main.Main.SUCCESS;
import me.cs158.tag.item.Items;
import me.cs158.tag.item.Nothing;
import me.cs158.tag.main.Util;

public class Inventory {
	
	protected int size;
	protected ArrayList<ItemStack> items;
	
	public Inventory(int size) {
		this.size = size;
		items = new ArrayList<ItemStack>(size);
		for(int i = 0;i < size;i++) {
			items.add(new ItemStack(new Nothing(), 0));
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
			if(is.getItemType() != Items.NOTHING)
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
				items.set(i, new ItemStack(new Nothing(), 0));
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
					is.add(add.getCount());
					add.remove(add.getCount());
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
			if(is.getItemType() == Items.NOTHING) {
				items.set(i, add);
				return SUCCESS.TRUE;
			}
		}
		return success;
	}
	
	public void removeItemStack(int index) {
		items.set(index, new ItemStack(new Nothing(), 0));
	}
	
	public boolean setItemStack(int index, ItemStack is) {
		items.set(index, is);
		return true;
	}
	
	@Override
	public String toString() {
		return toString(false);
	}
	
	public String toString(boolean includeEmpty) {
		String out = "";
		for(ItemStack is : items) {
			if(is.getItemType() != Items.NOTHING || includeEmpty) {
				out += is.toString() + ",";
			}
		}
		if(out.length() == 0) {
			return "";
		}
		out = out.substring(0, out.length() - 1);
		return out;
	}
	
	public String printInventory() {
		String out = "";
		for(ItemStack is : items) {
			if(is.getItemType() != Items.NOTHING) {
				out += is.getCount() + " x " + is.getItemType().toString() + "\n";
			} else {
				out += "AVAILABLE\n";
			}
		}
		out = out.substring(0, out.length() - 1);
		return out;
	}
	
}
