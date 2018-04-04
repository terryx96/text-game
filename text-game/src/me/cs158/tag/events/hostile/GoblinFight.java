package me.cs158.tag.events.hostile;

import me.cs158.tag.events.Event;
import me.cs158.tag.main.Main;
import me.cs158.tag.main.Util;
import me.cs158.tag.monsters.Ghost;
import me.cs158.tag.monsters.Goblin;
import me.cs158.tag.monsters.Monster;

public class GoblinFight extends Event{
	
	public GoblinFight() {
		super(Main.p, randomGoblins());
		this.description = "A band of little goblins attack you!";
	}
	
	/*@Override
	public void actions() {
		for(Monster e : this.enemies) {
			switch(Util.random(2)) {
			case 0: e.taunt(); break;
			case 1: e.attack(); break;
			default: e.taunt(); break;
			}
		}
	}
	*/
	
	
	
	public static Goblin[] randomGoblins() {
		Goblin[] output = new Goblin[Util.random(1,4)];
		for(int i = 0; i < output.length; i++) {
			output[i] = (new Goblin(Util.random(10, 30), Util.random(2,8)));
		}
		return output;
	}
}
