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
	
	public boolean isEmpty() {
		if(count == 0) {
			item = new Nothing();
		}
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
	
	public Items getItemType() {
		return ItemData.getItemType(item);
	}
	
	@Override
	public String toString() {
		return item.toString() + "x" + count;
	}
	
}
