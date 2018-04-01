package me.cs158.tag.player;

import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.item.Bow;
import me.cs158.tag.item.RangedWeapon;
import me.cs158.tag.main.Util;
import me.cs158.tag.monsters.Monster;

public class Archer extends Player {
	private RangedWeapon b;
	
	public Archer(String name, int hp, int m) {
		super(name, hp, m);
		this.attack = 5;
		this.defense = 6;
		b = new Bow(this.attack, this.attack*2, 0, 100, 0);
		this.inventory.addItem(new ItemStack(b));
		
	}
	
	@Override
	public void attack(Monster target) {
		int damage = 1;
		System.out.println("You fire your bow.");
		if(((RangedWeapon) this.inventory.getSlot(0).getItem()).hit(target.getDistance())) {
			damage = (int) (this.getAtk() + b.getDamage());
		}
		else {
			System.out.println("You missed!");
		}
		target.setHp(damage);
	}
	
	@Override
	public void ability(Monster target) {
		int damage = 1;
		System.out.println("You fire a special arrow!");
		this.takeMana(30);
		if(((RangedWeapon) this.inventory.getSlot(0).getItem()).hit(target.getDistance())) {			
			damage = (int) (this.getAtk()*b.getDamage());
		}
		else {
			System.out.println("You missed!");
		}
		target.setHp(damage);
	}
	
	@Override
	public String toString() {
		return this.getName() + " Archer " + this.getHealth() + " HP " + this.getMana() + " Mana\nInventory: \n" + this.getInventory() 
		+ "\nStats: ATK: " + this.getAtk() + " DEF: " + this.getDef();
	}
}
