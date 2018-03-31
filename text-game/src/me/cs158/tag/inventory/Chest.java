package me.cs158.tag.inventory;

import java.util.List;

import me.cs158.tag.main.Main.SUCCESS;

public class Chest extends Inventory {
	
	public Chest(List<ItemStack> items) {
		super(items.size());
	}
	
	@Override
	public int getSize() {
		return items.size();
	}
	
	@Override
	public int getOccupiedSlots() {
		return getSize();
	}
	
	@Override
	public int getOpenSlots() {
		return 0;
	}
	
	@Override
	public boolean setSize(int size) {
		return false;
	}
	
	@Override
	public SUCCESS addItem(ItemStack add) {
		return SUCCESS.FALSE;
	}
	
	@Override
	public void removeItemStack(int index) {
		items.remove(index);
	}
	
	@Override
	public boolean setItemStack(int index, ItemStack is) {
		//maybe add ability?
		return false;
	}
	
}
