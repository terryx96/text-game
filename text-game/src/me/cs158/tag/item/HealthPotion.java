package me.cs158.tag.item;

public class HealthPotion extends Potion {

	private static final Items ITEM = Items.POTION;
	private static final PotionType TYPE = PotionType.HEALTH;
	
	public HealthPotion(int amount) {
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
	
	@Override
	public Item copy() {
		return new ManaPotion(this.getAmount());
	}
	
}
