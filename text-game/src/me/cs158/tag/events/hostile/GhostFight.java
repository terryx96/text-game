package me.cs158.tag.events.hostile;

import java.util.ArrayList;

import me.cs158.tag.events.Event;
import me.cs158.tag.main.Main;
import me.cs158.tag.main.Util;
import me.cs158.tag.monsters.Ghost;
import me.cs158.tag.monsters.Monster;

public class GhostFight extends Event{
	

	
	public GhostFight() {
		super(Main.p, randomGhosts());
		
	}
	
	@Override
	public void actions() {
		for(Monster e : this.enemies) {
			switch(Util.random(2)) {
			case 0: e.taunt();
			case 1: e.attack();
			}
		}
	}
	
	public static Ghost[] randomGhosts() {
		Ghost[] output = new Ghost[Util.random(1,5)];
		for(int i = 0; i < output.length; i++) {
			output[i] = (new Ghost(Util.random(50, 100), Util.random(10,20), Util.random(2,20)));
		}
		return output;
	}
	
	
}
