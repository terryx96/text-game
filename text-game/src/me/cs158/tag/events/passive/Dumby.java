package me.cs158.tag.events.passive;
import me.cs158.tag.events.Event;
import me.cs158.tag.monsters.*;

public class Dumby extends Event {
	
	public Dumby() {
		super();
	}
	
	@Override
	public void actions() {
		System.out.println("This is an action from the Dumby class!\n");
	}
}