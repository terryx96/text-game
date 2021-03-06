package me.cs158.tag.item.potion;

import me.cs158.tag.item.Item;
import me.cs158.tag.item.Items;
import me.cs158.tag.player.Player;

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
	
	@Override
	public boolean use(Player p) {
		p.changeHealth(this.getAmount());
		return true;
	}
	
}
