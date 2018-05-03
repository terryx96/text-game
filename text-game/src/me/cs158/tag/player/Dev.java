package me.cs158.tag.player;

import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.Bow;
import me.cs158.tag.monsters.Monster;

public class Dev extends Player {
	public Dev(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 1000;
		this.defense = 1000;	
	}
	
	@Override
	public void attack(Monster target) {
		target.setHp(-1);
	}
}
