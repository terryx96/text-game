package me.cs158.tag.events.passive;
import me.cs158.tag.events.Event;
import me.cs158.tag.main.Main;
import me.cs158.tag.main.Util;


public class FinalRoom extends Event{
	public FinalRoom() {
		super();
	}
	
	@Override
	public void actions() {
		System.out.println("You've found the ghost core."
				+ "\nYou attack it with all your might."
				+ "\nYou destroy it, and the ghosts dissapear!"
				+ "\nThe end!");
		Main.onGoing = false;
	}
	
	
}
