package me.cs158.tag.events.passive;

import me.cs158.tag.events.Event;
import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.ManaPotion;
import me.cs158.tag.main.Util;
import me.cs158.tag.player.Player;

public class FindManaPotion extends Event{
	Player p;
	public FindManaPotion(Player p) {
		super();
		this.p = p;
	}
	
	@Override
	public void actions() {
		p.getInventory().addItem(new ItemStack(new ManaPotion(Util.random(1, 3))));
	}
}
