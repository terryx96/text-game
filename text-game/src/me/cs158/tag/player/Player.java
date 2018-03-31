package me.cs158.tag.player;

import java.util.Arrays;
import java.util.Scanner;

import me.cs158.tag.inventory.Inventory;
import me.cs158.tag.inventory.PlayerInventory;
import me.cs158.tag.main.Board;
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
	
	public String getInventory() {
		return this.inventory.printInventory();
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
		System.out.print("Which direction: ");
		String direction = input.nextLine();
		
		switch(direction.toLowerCase()) {
			case "north": this.moveypos(1); break;
			case "west": this.movexpos(-1); break;
			case "east": this.movexpos(1); break;
			case "south": this.moveypos(-1);break;
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
	
	public int getxpos() {
		return this.xpos;
	}
	
	public int getypos() {
		return this.ypos;
	}
	
	public void movexpos(int dx) {
		this.xpos+=dx;
	}
	
	public void moveypos(int dy) {
		this.ypos+=dy;
	}
	
	public void takeDamage(int x) {
		this.health-=x;
	}
	
	public void takeHealth(int x) {
		this.health+=x;
	}
	
	public void useMana(int x) {
		this.mana-=x;
	}
	
	public void takeMana(int x) {
		this.mana+=x;
	}
	
	public void setxpos(int x) {
		this.xpos = x;
	}
	
	public void setypos(int y) {
		this.ypos = y;
	}
	
	public void chageAtk(int da) {
		this.attack+=da;
	}
	
	public void changeDef(int dd) {
		this.defense+=dd;
	}
	
	
	
}
