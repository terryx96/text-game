package me.cs158.tag.player;

import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.BroadSword;
import me.cs158.tag.item.MeleeWeapon;

public class Knight extends Player{
	private int shieldBashes;
	
	public Knight(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 8;
		this.defense = 11;
		this.inventory.addItem(new ItemStack(new BroadSword(2,10)));
	}
	
	@Override
	public String toString() {
		return this.getName() + " Knight " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: \n" + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();	}

}
