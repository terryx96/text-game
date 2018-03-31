package me.cs158.tag.events;

import me.cs158.tag.monsters.Ghost;

public class GhostFight extends Event{
	
	public GhostFight() {
		super(new Ghost(100,20));
		this.enemies.add(new Ghost(200,10));
		this.actions();
	}
	
	@Override
	public void actions() {
		int turn = 0;
		while(turn < 5) {		//this is proof of concept, actual events will be better lol
			turn++;
			this.enemies.get(0).speak();
			
		}
		System.out.println("Win!");
		
	}
	
	
}
