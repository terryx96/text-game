package me.cs158.tag.inventory;

import me.cs158.tag.exception.InvalidCountException;
import me.cs158.tag.item.Item;

public class ItemStack {
	
	private Item item;
	private int count;
	
	public ItemStack(Item item, int count) {
		if(item != null && count > 0 && count <= item.getStackSize()) {
			this.item = item;
			this.count = count;
		} else {
			throw new InvalidCountException();
		}
	}
	
	public ItemStack(Item item) {
		this(item, 1);
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean setCount(int count) {
		if(count < 0 || count > item.getStackSize()) {
			return false;
		}
		this.count = count;
		return true;
	}
	
	public boolean add() {
		return setCount(count + 1);
	}
	
	public boolean add(int c) {
		return setCount(count + c);
	}
	
	public int getAvailability() {
		return item.getStackSize() - count;
	}
	
	public boolean remove() {
		return setCount(count - 1);
	}
	
	public boolean remove(int c) {
		return setCount(count - c);
	}
	
	public Item getItem() {
		return item;
	}
	
}
