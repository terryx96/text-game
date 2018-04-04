package me.cs158.tag.item.potion;

import me.cs158.tag.item.Consumable;
import me.cs158.tag.item.Items;

public abstract class Potion extends Consumable {
	
	private PotionType potionType;
	private int amount;
	
	public Potion(Items item, PotionType potionType, int amount) {
		super(item, potionType.toString() + " " + Items.POTION.toString());
		this.potionType = potionType;
		this.amount = amount;
	}
	
	/**
	 * Returns the type of the potion
	 * @return	the type of the potion
	 */
	public PotionType getPotionType() {
		return potionType;
	}
	
	/**
	 * Returns the amount by which this potion should change the player's stat
	 * @return	the amount by which this potion should change the player's stat
	 */
	public int getAmount() {
		return amount;
	}
	
}
