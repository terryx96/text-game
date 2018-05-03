package me.cs158.tag.events.passive;
import me.cs158.tag.events.Event;
import me.cs158.tag.main.Util;

public class Dummy extends Event {
	private int randNum = Util.random(3);
	public Dummy() {
		super();
	}
	
	@Override
	public void actions() {
		switch(this.randNum) {
		case 0: System.out.println("You wander through a dark hall."); break;
		case 1: System.out.println("The wild sunflowers please you."); break; 
		case 2: System.out.println("An aroma of saltwater fills your nostrils."); break; 
		case 3: System.out.println("You see a mountain in the distance."); break; 
		case 4: System.out.println("You enter what appears to be a temple."); break; 
		default: System.out.println("You observe the pretty trees.");
		}
	}
}
