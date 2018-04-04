package me.cs158.tag.monsters;
import me.cs158.tag.main.Util;

import java.util.ArrayList;

public abstract class Monster {
	private int health;
	private int strength = 1;
	protected int distance;
	protected String type;
	private boolean alive = true;
	
	public Monster(int hp, int d) {
		this.health = hp;
		this.distance = d;
	}
	
	public void taunt() {
	}			
	
	public void attack() {
		
	}
	
	public int getHp() {
		return this.health;
	}
	
	public int getDistance() {
		return this.distance;
	}
	
	public void setHp(int d) {
		this.health-=d;
	}
	
	@Override
	public String toString() {
		return "[" + this.type + " " + this.getHp() + "HP]";
	}
	
	public void checkDead() {
		if(this.health <= 0) {
			this.alive = false;
		}
	}
	
	public boolean getAlive() {
		return this.alive;
	}
}
