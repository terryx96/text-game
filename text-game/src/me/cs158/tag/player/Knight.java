package me.cs158.tag.player;

import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.BroadSword;
import me.cs158.tag.item.MeleeWeapon;
import me.cs158.tag.item.RangedWeapon;
import me.cs158.tag.monsters.Monster;

public class Knight extends Player{
	private MeleeWeapon s;
	
	public Knight(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 8;
		this.defense = 11;
		s = new BroadSword(2,10);
		this.inventory.addItem(new ItemStack(s));
	}
	
	@Override
	public void attack(Monster target) {
		int damage = 1;
		System.out.println("You slash your sword!");
		target.setHp(damage);
	}
	
	@Override
	public String toString() {
		return this.getName() + " Knight " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: \n" + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();	}

}
