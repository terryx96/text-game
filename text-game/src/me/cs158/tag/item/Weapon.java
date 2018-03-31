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
	
	public double getDamage() {
		return Util.randomDouble(minDamage, maxDamage);
	}
	
	public double getMinDamage() {
		return minDamage;
	}
	
	public double getMaxDamage() {
		return maxDamage;
	}
	
}
