package me.cs158.tag.inventory;

import me.cs158.tag.exception.InvalidCountException;
import me.cs158.tag.item.Item;
import me.cs158.tag.item.ItemData;
import me.cs158.tag.item.Items;
import me.cs158.tag.item.Nothing;

public class ItemStack {
	
	private Item item;
	private int count;
	
	public ItemStack(Item item, int count) {
		if(item != null && count > 0 && count <= item.getStackSize()) {
			this.item = item;
			this.count = count;
		} else if(count == 0) {
			this.item = new Nothing();
			this.count = 0;
		} else {
			throw new InvalidCountException();
		}
	}
	
	public ItemStack(Item item) {
		this(item, 1);
	}
	
	/**
	 * Returns whether or not the itemstack is empty
	 * @return	whether or not the itemstack is empty
	 */
	public boolean isEmpty() {
		if(count == 0) {
			item = new Nothing();
		}
		return count == 0;
	}
	
	/**
	 * Returns the number of items in the stack
	 * @return	the number of items in the stack
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Sets the number of items in the stack
	 * @param count	the number of items
	 * @return	true if the count was set successfully (valid), false otherwise
	 */
	public boolean setCount(int count) {
		if(count < 0 || count > item.getStackSize()) {
			return false;
		}
		this.count = count;
		isEmpty();
		return true;
	}
	
	/**
	 * Add one to the stack count
	 * @return	true if the count was changed successfully, false otherwise
	 */
	public boolean add() {
		return setCount(count + 1);
	}
	
	/**
	 * Add the specified number to the stack count
	 * @param c	the number to be added
	 * @return	true if the count was changed successfully, false otherwise
	 */
	public boolean add(int c) {
		return setCount(count + c);
	}
	
	/**
	 * Returns the number of items which can be added to this itemstack
	 * @return	the number of items which can be added to this itemstack
	 */
	public int getAvailability() {
		return item.getStackSize() - count;
	}
	
	/**
	 * Remove one from the itemstack count
	 * @return	true if the count was successfully changed, false otherwise
	 */
	public boolean remove() {
		return setCount(count - 1);
	}
	
	/**
	 * Remove the specified number from the itemstack count
	 * @param c	the number of items to remove
	 * @return	true if the count was successfully changed, false otherwise
	 */
	public boolean remove(int c) {
		return setCount(count - c);
	}
	
	/**
	 * Returns the item in the itemstack
	 * @return	the item in the itemstack
	 */
	public Item getItem() {
		return item;
	}
	
	/**
	 * Returns the item type of the itemstack
	 * @return	the item type of the itemstack
	 */
	public Items getItemType() {
		return ItemData.getItemType(item);
	}
	
	/**
	 * Returns part of the itemstack after splitting it
	 * @param count	the number of items to be removed from the stack and added to the new stack
	 * @return	the part of the itemstack removed from the existing stack
	 */
	public ItemStack split(int count) {
		if(count <= 0) {
			return new ItemStack(new Nothing(), 0);
		}
		ItemStack is = this.copy();
		if(count >= this.count) {
			this.setCount(0);
			return is;
		}
		is.setCount(count);
		this.setCount(this.count - count);
		return is;
	}
	
	/**
	 * Returns a copy of the itemstack
	 * @return	a copy of the itemstack
	 */
	public ItemStack copy() {
		return new ItemStack(item.copy(), count);
	}
	
	@Override
	public Object clone() {
		return copy();
	}
	
	@Override
	public String toString() {
		return item.toString() + "x" + count;
	}
	
}
