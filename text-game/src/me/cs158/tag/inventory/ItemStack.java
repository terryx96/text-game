package me.cs158.tag.inventory;

import me.cs158.tag.exception.InvalidCountException;
import me.cs158.tag.item.ItemData;
import me.cs158.tag.item.Items;

public class ItemStack {
	
	private Items item;
	private int count;
	
	public ItemStack(Items item, int count) {
		if(item != null && count > 0 && count <= ItemData.getStackSize(item)) {
			this.item = item;
			this.count = count;
		} else if(count == 0) {
			this.item = Items.NOTHING;
			this.count = 0;
		} else {
			throw new InvalidCountException();
		}
	}
	
	public ItemStack(Items item) {
		this(item, 1);
	}
	
	public boolean isEmpty() {
		if(count == 0) {
			item = Items.NOTHING;
		}
		return count == 0;
	}
	
	public int getCount() {
		return count;
	}
	
	public boolean setCount(int count) {
		if(count < 0 || count > ItemData.getStackSize(item)) {
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
		return ItemData.getStackSize(item) - count;
	}
	
	public boolean remove() {
		return setCount(count - 1);
	}
	
	public boolean remove(int c) {
		return setCount(count - c);
	}
	
	public Items getItem() {
		return item;
	}
	
}
