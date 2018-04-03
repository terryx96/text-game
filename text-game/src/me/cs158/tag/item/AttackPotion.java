package me.cs158.tag.item;

public class AttackPotion extends Potion {

	private static final Items ITEM = Items.POTION;
	private static final PotionType TYPE = PotionType.ATTACK;
	
	public AttackPotion(int amount) {
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
