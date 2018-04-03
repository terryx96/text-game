package me.cs158.tag.events.passive;

import me.cs158.tag.events.Event;
import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.ManaPotion;
import me.cs158.tag.item.*;
import me.cs158.tag.main.Util;
import me.cs158.tag.player.Player;

public class FindPotion extends Event{
	Player p;
	public FindPotion(Player p) {
		super();
		this.p = p;
	}
	
	@Override
	public void actions() {
		p.getInventory().addItem(new ItemStack(this.randomPotion()));
	}
	
	public Potion randomPotion() {
		int type = Util.random(0, 3);
		int amount = Util.random(1,3);
		switch(type) {
		case 0: return new ManaPotion(amount);
		case 1:	return new HealthPotion(amount);
		case 2:	return new DefensePotion(amount);
		case 3: return new AttackPotion(amount);
		default: return null;
		}
	}
}
