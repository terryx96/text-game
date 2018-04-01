package me.cs158.tag.item;

public class ManaPotion extends Potion {

	private static final Items ITEM = Items.POTION;
	private static final PotionType TYPE = PotionType.MANA;
	
	public ManaPotion(int amount) {
		super(ITEM, TYPE, amount);
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof ManaPotion)) {
			return false;
		}
		ManaPotion potion = (ManaPotion) o;
		return potion.getAmount() == this.getAmount();
	}
	
}
