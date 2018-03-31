package me.cs158.tag.inventory;

import me.cs158.tag.item.Items;
import me.cs158.tag.item.Weapon;
import me.cs158.tag.main.Main.SUCCESS;
import me.cs158.tag.player.Player;

public class PlayerInventory extends Inventory {
	
	private Player owner;
	private int weaponSize;
	
	public PlayerInventory(Player owner, int weaponSize, int itemSize) {
		super(weaponSize + itemSize);
		this.weaponSize = weaponSize;
		this.owner = owner;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	public int getNumWeaponSlots() {
		return weaponSize;
	}
	
	public int getNumItemSlots() {
		return size - weaponSize;
	}
	
	public int getOccupiedWeaponSlots() {
		int count = 0;
		for(int i = 0;i < weaponSize;i++) {
			if(items.get(i).getItemType() != Items.NOTHING)
				count++;
		}
		return count;
	}
	
	public int getOpenWeaponSlots() {
		return weaponSize - getOccupiedWeaponSlots();
	}
	
	public int getOccupiedItemSlots() {
		int count = 0;
		for(int i = weaponSize;i < size;i++) {
			if(items.get(i).getItemType() != Items.NOTHING)
				count++;
		}
		return count;
	}
	
	public int getOpenItemSlots() {
		return (size - weaponSize) - getOccupiedItemSlots();
	}
	
	@Override
	public boolean setSize(int size) {
		if(size < weaponSize) {
			return false;
		}
		return super.setSize(size);
	}
	
	@Override
	public SUCCESS addItem(ItemStack add) {
		SUCCESS success = SUCCESS.FALSE;
		if(add.getItem() instanceof Weapon) {
			if(getOpenWeaponSlots() == 0) {
				return SUCCESS.FALSE;
			}
			for(int i = 0;i < weaponSize;i++) {
				if(items.get(i).getItemType() == Items.NOTHING) {
					items.set(i, add);
					return SUCCESS.TRUE;
				}
			}
			return SUCCESS.FALSE;
		} else {
			if(getOpenItemSlots() == 0) {
				return SUCCESS.FALSE;
			}
			for(int i = weaponSize;i < size;i++) {
				ItemStack is = items.get(i);
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
			for(int i = weaponSize;i < size;i++) {
				ItemStack is = items.get(i);
				if(is.getItemType() == Items.NOTHING) {
					items.set(i, add);
					return SUCCESS.TRUE;
				}
			}
		}
		return success;
	}
	
	@Override
	public boolean setItemStack(int index, ItemStack is) {
		if((index < weaponSize && is.getItem() instanceof Weapon) ||
				index >= weaponSize && !(is.getItem() instanceof Weapon)) {
			items.set(index, is);
			return true;
		}
		return false;
	}
	
}
