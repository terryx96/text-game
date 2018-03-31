package me.cs158.tag.events;

import javax.swing.JFrame;

import me.cs158.tag.main.Scroll;

public abstract class DisplayEvent extends Event{
	protected JFrame f;
	protected Scroll src;
	
	public DisplayEvent(Scroll s) {
		this.src = s;
		this.f = new JFrame("HINT");
	}

	public void actions() {
		System.out.println("Actions will go here");
	}
}
