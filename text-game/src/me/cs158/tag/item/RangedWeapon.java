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
	
	/**
	 * Returns the range of the weapon
	 * @return	the range of the weapon
	 */
	public int getRange() {
		return range;
	}
	
	/**
	 * Returns the chance of the weapon hitting successfully within its range
	 * @return	the chance of the weapon hitting successfully within its range
	 */
	public double getChance() {
		return chance;
	}
	
	/**
	 * Returns the amount by which the chance of hitting decreases per unit of distance beyond the weapon's range
	 * @return	the amount by which the chance of hitting decreases per unit of distance beyond the weapon's range
	 */
	public double getFallOff() {
		return fallOff;
	}
	
	/**
	 * Returns whether or not the weapon hit at a distance
	 * @param distance	the distance from which the weapon was fired
	 * @return	whether or not the weapon hit at the specified distance
	 */
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
