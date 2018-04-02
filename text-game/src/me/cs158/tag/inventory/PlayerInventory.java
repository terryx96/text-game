package me.cs158.tag.inventory;

import me.cs158.tag.item.Item;
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
	
	/**
	 * Returns the owner of the inventory
	 * @return	the owner of the inventory
	 */
	public Player getOwner() {
		return owner;
	}
	
	/**
	 * Sets the owner of the inventory
	 * @param owner	the new owner of the inventory
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
	/**
	 * Returns the number of weapon slots
	 * @return	the number of weapon slots
	 */
	public int getNumWeaponSlots() {
		return weaponSize;
	}
	
	/**
	 * Returns the number of item slots
	 * @return	the number of item slots
	 */
	public int getNumItemSlots() {
		return size - weaponSize;
	}
	
	/**
	 * Returns the number of occupied weapon slots
	 * @return	the number of occupied weapon slots
	 */
	public int getOccupiedWeaponSlots() {
		int count = 0;
		for(int i = 0;i < weaponSize;i++) {
			if(items.get(i).getItemType() != Items.NOTHING)
				count++;
		}
		return count;
	}
	
	/**
	 * Returns the number of open weapon slots
	 * @return	the number of open weapon slots
	 */
	public int getOpenWeaponSlots() {
		return weaponSize - getOccupiedWeaponSlots();
	}
	
	/**
	 * Returns the number of occupied item slots
	 * @return	the number of occupied item slots
	 */
	public int getOccupiedItemSlots() {
		int count = 0;
		for(int i = weaponSize;i < size;i++) {
			if(items.get(i).getItemType() != Items.NOTHING)
				count++;
		}
		return count;
	}
	
	/**
	 * Returns the number of open item slots
	 * @return	the number of open item slots
	 */
	public int getOpenItemSlots() {
		return (size - weaponSize) - getOccupiedItemSlots();
	}
	
	/**
	 * Returns the player's equipped item stack
	 * @return	the player's equipped item stack
	 */
	public ItemStack getEquippedStack() {
		return items.get(0);
	}
	
	/**
	 * Returns the player's equipped item
	 * @return	the player's equipped item
	 */
	public Item getEquippedItem() {
		return getEquippedStack().getItem();
	}
	
	/**
	 * Change the player's equipped weapon
	 * @param index	the index in the inventory of the weapon to equip
	 * @return	true if the weapon was successfully equipped, false otherwise
	 */
	public boolean setEquippedWeapon(int index) {
		if(index == 0) {
			return true;
		}
		if(index >= weaponSize) {
			return false;
		}
		if(!(items.get(index).getItem() instanceof Weapon)) {
			return false;
		}
		ItemStack swap = items.get(0);
		items.set(0, items.get(index));
		items.set(index, swap);
		return true;
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
	
	@Override
	public String printInventory() {
		String out = "Weapons\n----------\n";
		for(int i = 0;i < weaponSize;i++) {
			ItemStack is = items.get(i);
			if(is.getItemType() != Items.NOTHING) {
				out += is.getCount() + " x " + is.getItemType().toString() + "\n";
			} else {
				out += "AVAILABLE\n";
			}
		}
		out += "\nItems\n----------\n";
		for(int i = weaponSize;i < size;i++) {
			ItemStack is = items.get(i);
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
