package me.cs158.tag.events.hostile;

import me.cs158.tag.events.Event;
import me.cs158.tag.monsters.Ghost;
import me.cs158.tag.monsters.Monster;

public class GhostFight extends Event{
	
	public GhostFight() {
		super(new Ghost(100,20), new Ghost(60, 30));
	}
	
	@Override
	public void actions() {
		for(Monster e : this.enemies) {
			System.out.println(e);
		}
		
	}
	
	
}
