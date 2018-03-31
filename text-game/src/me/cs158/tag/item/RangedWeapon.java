package me.cs158.tag.item;

public abstract class RangedWeapon extends Weapon {
	
	protected int range;
	protected double chance;
	protected double fallOff;
	
	public RangedWeapon(Items item, double minDamage, double maxDamage, int range, double chance, double fallOff) {
		super(item, minDamage, maxDamage);
		this.range = range;
		this.chance = chance;
		this.fallOff = fallOff;
	}
	
	public int getRange() {
		return range;
	}
	
	public double getChance() {
		return chance;
	}
	
	public double getFallOff() {
		return fallOff;
	}
	
	public boolean hit(int distance) {
		double finalChance;
		if(distance <= range) {
			finalChance = chance; 
		} else {
			finalChance = chance - (fallOff * (distance - range));
		}
		return Math.random() < finalChance;
	}
	
}
