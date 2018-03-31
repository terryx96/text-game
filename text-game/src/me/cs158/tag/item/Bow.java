package me.cs158.tag.item;

public class Bow extends RangedWeapon {
	
	private static final Items ITEM = Items.BOW;

	public Bow(double minDamage, double maxDamage, int range, double chance, double fallOff) {
		super(ITEM, minDamage, maxDamage, range, chance, fallOff);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Bow)) {
			return false;
		}
		Bow bow = (Bow) o;
		return this.getMinDamage() == bow.getMinDamage() &&
				this.getMaxDamage() == bow.getMaxDamage() &&
				this.getRange() == bow.getRange() &&
				this.getChance() == bow.getChance() &&
				this.fallOff == bow.getFallOff();
	}
	
}
