package me.cs158.tag.events;

import java.util.ArrayList;

import me.cs158.tag.monsters.Monster;
import me.cs158.tag.player.Player;

public abstract class Event {
	Player p;
	protected ArrayList<Monster> enemies;

	public Event() {
		this.enemies = null;
	}
	
	public Event(Player p, Monster... monsters) {
		this.p = p;
		this.enemies = new ArrayList<Monster>();
		for(Monster e : monsters) {
			enemies.add(e);
		}
	}
	
	public void actions() {
		System.out.println("Actions will be here");
	}
	
	public int groupHealth() {
		int output = 0;
		for(Monster e : enemies) {
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
	
	public void displayEnemies() {
		int num = 1;
		for(Monster e : this.enemies) {
			System.out.print(num + ". " + e + " ");
			num++;
		}
	}
	
}
