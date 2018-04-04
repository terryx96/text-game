package me.cs158.tag.item;

import me.cs158.tag.player.Player;

public class BroadSword extends MeleeWeapon {
	
	private static final Items ITEM = Items.BROADSWORD;

	public BroadSword(double minDamage, double maxDamage) {
		super(ITEM, minDamage, maxDamage);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof BroadSword)) {
			return false;
		}
		BroadSword bs = (BroadSword) o;
		return (this.getMinDamage() == bs.getMinDamage() && this.getMaxDamage() == bs.getMaxDamage());
	}
	
	@Override
	public Item copy() {
		return new BroadSword(this.getMinDamage(), this.getMaxDamage());
	}
	
	@Override
	public boolean use(Player p) {
		return false;
	}
	
}
