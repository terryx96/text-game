package me.cs158.tag.events;

import java.util.ArrayList;

import me.cs158.tag.monsters.Monster;

public abstract class Event {
	protected ArrayList<Monster> enemies;

	public Event() {
		this.enemies = null;
	}
	
	public Event(Monster... monsters) {
		this.enemies = new ArrayList<Monster>();
		for(Monster e : monsters) {
			enemies.add(e);
		}
	}
	
	public void actions() {
		System.out.println("Actions will be here");
	}
	
	
	@Override
	public String toString() {
		return "This is an event!"; 
	}
	
}
