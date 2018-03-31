package me.cs158.tag.item;

public class BroadSword extends MeleeWeapon {
	
	private static final Items ITEM = Items.BROADSWORD;

	public BroadSword(float minDamage, float maxDamage) {
		super(ITEM, minDamage, maxDamage);
	}
	
}
