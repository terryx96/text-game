package me.cs158.tag.player;

import java.util.Arrays;
import java.util.Scanner;

import me.cs158.tag.inventory.Inventory;
import me.cs158.tag.inventory.ItemStack;
import me.cs158.tag.inventory.PlayerInventory;
import me.cs158.tag.item.Item;
import me.cs158.tag.item.Weapon;
import me.cs158.tag.main.Board;
import me.cs158.tag.main.Main.SUCCESS;
import me.cs158.tag.monsters.Monster;

public abstract class Player {
	public static Scanner input = new Scanner(System.in);
	private String name;
	protected PlayerInventory inventory;
	private int health;
	private int mana;
	private int xpos = 0;
	private int ypos = 0;
	protected int attack;
	protected int defense;
	
	public Player(String name, int hp, int m) {
		this.name = name;
		this.inventory = new PlayerInventory(this, 3, 6);
		this.health = hp;
		this.mana = m;
		this.attack = 0;
		this.defense = 0;
		
	}
	
	public void ability(Monster target) {
		
	}
	
	public void attack(Monster target) {
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public void displayInventory() {
		System.out.println(this.inventory.printInventory());
	}
	
	public PlayerInventory getInventory() {
		return this.inventory;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public int getMana() {
		return this.mana;
	}
	
	public int getAtk() {
		return this.attack;
	}
	
	public int getDef() {
		return this.defense;
	}
	
	public void move() {
		System.out.print("North, South, East or West to move. Inv to see inventory ");
		String direction = input.nextLine();
		
		switch(direction.toLowerCase()) {
			case "north": this.moveY(1); break;
			case "west": this.moveX(-1); break;
			case "east": this.moveX(1); break;
			case "south": this.moveY(-1);break;
			case "inv": this.displayInventory(); break;
			default: System.out.println("Invalid, valid directions are: north, south, east, west");
		}
		
		System.out.println("Current Position: " + this.displayPosition());
		
	}
	
	
	
	
	@Override
	public String toString() {
		return "I am a player at " + this.displayPosition();
	}
	
	public String displayPosition() {
		return "(" + this.xpos + "," + this.ypos + ")";
	}
	
	public int getX() {
		return this.xpos;
	}
	
	public int getY() {
		return this.ypos;
	}
	
	public void moveX(int dx) {
		this.xpos+=dx;
	}
	
	public void moveY(int dy) {
		this.ypos+=dy;
	}
	
	@Deprecated
	public void takeDamage(int x) {
		changeHealth(-1 * x);
	}
	
	public void changeHealth(int x) {
		this.health+=x;
	}
	
	public void changeMana(int x) {
		this.mana+=x;
	}
	
	public void setX(int x) {
		this.xpos = x;
	}
	
	public void setY(int y) {
		this.ypos = y;
	}
	
	public void changeAttack(int da) {
		this.attack+=da;
	}
	
	public void changeDefense(int dd) {
		this.defense+=dd;
	}
	
	public SUCCESS giveItems(ItemStack... items) {
		int startCount = this.inventory.getTotalCount();
		int addCount = 0;
		for(ItemStack is : items) {
			this.inventory.addItem(is);
			addCount += is.getCount();
		}
		int finalCount = this.inventory.getTotalCount();
		if(startCount == finalCount) {
			return SUCCESS.FALSE;
		}
		if(finalCount == startCount + addCount) {
			return SUCCESS.TRUE;
		}
		return SUCCESS.PARTIAL;
	}
	
	public SUCCESS giveItem(ItemStack is) {
		return this.inventory.addItem(is);
	}
	
	public boolean giveItem(Item item) {
		return this.inventory.addItem(new ItemStack(item, 1)) == SUCCESS.TRUE;
	}
	
	public ItemStack getEquippedWeaponStack() {
		return this.inventory.getEquippedWeaponStack();
	}
	
	public Weapon getEquippedWeapon() {
		return this.inventory.getEquippedWeapon();
	}
	
}
