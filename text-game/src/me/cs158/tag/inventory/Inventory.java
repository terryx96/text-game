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
	
	/**
	 * Returns the itemstacks contained within the inventory
	 * @return	the itemstacks contained within the inventory
	 */
	public ArrayList<ItemStack> getItems() {
		return Util.cloneList(items);
	}
	
	/**
	 * Returns the itemstack contained at the specified index
	 * @param index	the index at which to grab the itemstack
	 * @return	the itemstack at the specified index
	 */
	public ItemStack getSlot(int index) {
		return items.get(index);
	}
	
	/**
	 * Returns the size of the inventory
	 * @return	the size of the inventory
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Returns the number of occupied slots in the inventory
	 * @return	the number of occupied slots in the inventory
	 */
	public int getOccupiedSlots() {
		int count = 0;
		for(ItemStack is : items) {
			if(is.getItemType() != Items.NOTHING)
				count++;
		}
		return count;
	}
	
	/**
	 * Returns the number of open slots in the inventory
	 * @return	the number of open slots in the inventory
	 */
	public int getOpenSlots() {
		return size - getOccupiedSlots();
	}
	
	/**
	 * Set the size of the inventory
	 * @param size	the new size of the inventory
	 * @return	true if the size was successfully changed, false otherwise
	 */
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
	
	/**
	 * Add an itemstack to the inventory
	 * @param add	The itemstack to add to the inventory
	 * @return	TRUE if the entire itemstack was added to the inventory, PARTIAL if part of the itemstack was added, and FALSE if none
	 */
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
	
	/**
	 * Remove an itemstack from the inventory
	 * @param index	the index of the itemstack to be removed
	 */
	public void removeItemStack(int index) {
		items.set(index, new ItemStack(new Nothing(), 0));
	}
	
	/**
	 * Set an itemstack in the inventory
	 * @param index	the index of the itemstack to be removed
	 * @param is	the itemstack to insert at index
	 * @return	true if the itemstack was successfully set, false otherwise
	 */
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
	
	/**
	 * Return the inventory in human-readable format to be displayed to the player
	 * @return	the inventory in human-readable format to be displayed to the player
	 */
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
