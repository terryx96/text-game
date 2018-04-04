package me.cs158.tag.events;

import java.util.ArrayList;

import me.cs158.tag.main.Util;
import me.cs158.tag.monsters.Monster;
import me.cs158.tag.player.Player;

public abstract class Event {
	Player p;
	protected ArrayList<Monster> enemies;
	protected String description;

	public Event() {
		this.enemies = null;
	}
	
	public Event(Player p, Monster... monsters) {
		
		this.p = p;
		this.description = "This is an event";
		this.enemies = new ArrayList<Monster>();
		for(Monster e : monsters) {
			enemies.add(e);
		}
	}
	
	public void actions() {
		for(Monster e : this.enemies) {
			if(e.getHp() > 0) {
			switch(Util.random(2)) {
			case 0: e.taunt(); break;
			case 1: e.attack(); break;
			default: e.taunt(); break;
			}
		}
			else {
				continue;
			}
		}
	}
	
	public int groupHealth() {
		int output = 0;
		for(Monster e : this.enemies) {
			output+=e.getHp();
			}
		return output;
	}
	
	@Override
	public String toString() {
		return "This is an event!"; 
	}
	
	public ArrayList<Monster> getEnemies(){
		return this.enemies;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void displayEnemies() {
		int num = 1;
		for(Monster e : this.enemies) {
			System.out.print(num + ". " + e + " ");
			num++;
		}
	}
	
}
