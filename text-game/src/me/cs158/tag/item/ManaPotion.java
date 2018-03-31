package me.cs158.tag.item;

public class ManaPotion extends Potion {

	private static final Items ITEM = Items.MANA_POTION;
	
	public ManaPotion() {
		super(ITEM);
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof ManaPotion;
	}
	
}
