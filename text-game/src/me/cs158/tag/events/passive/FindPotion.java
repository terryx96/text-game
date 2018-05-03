package me.cs158.tag.events.passive;

import me.cs158.tag.events.Event;
import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.*;
import me.cs158.tag.item.potion.AttackPotion;
import me.cs158.tag.item.potion.DefensePotion;
import me.cs158.tag.item.potion.HealthPotion;
import me.cs158.tag.item.potion.ManaPotion;
import me.cs158.tag.item.potion.Potion;
import me.cs158.tag.main.Main;
import me.cs158.tag.main.Util;
import me.cs158.tag.player.Player;

public class FindPotion extends Event{
	
	public FindPotion() {
		super();
	}
	
	@Override
	public void actions() {
		System.out.println("You found a potion!");
		Main.p.getInventory().addItem(new ItemStack(this.randomPotion()));
	}
	
	public Potion randomPotion() {
		int type = Util.random(0, 3);
		int amount = 1;
		switch(type) {
		case 0: return new ManaPotion(amount); 
		case 1:	return new HealthPotion(amount); 
		case 2:	return new DefensePotion(amount); 
		case 3: return new AttackPotion(amount);
		default: return null;
		}
	}
}
