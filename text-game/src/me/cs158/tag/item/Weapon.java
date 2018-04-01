package me.cs158.tag.item;

import me.cs158.tag.main.Util;

public abstract class Weapon extends Item {
	
	private double minDamage;
	private double maxDamage;
	
	public Weapon(Items item, double minDamage, double maxDamage) {
		super(item);
		this.minDamage = minDamage;
		this.maxDamage = maxDamage;
	}
	
	/**
	 * Returns the damage the weapon dealt
	 * @return	the damage the weapon dealt
	 */
	public double getDamage() {
		return Util.randomDouble(minDamage, maxDamage);
	}
	
	/**
	 * Returns the minimum damage of the weapon
	 * @return	the minimum damage of the weapon
	 */
	public double getMinDamage() {
		return minDamage;
	}
	
	/**
	 * Returns the maximum damage of the weapon
	 * @return	the maximum damage of the weapon
	 */
	public double getMaxDamage() {
		return maxDamage;
	}
	
}
