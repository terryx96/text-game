package me.cs158.tag.events.passive;

import javax.swing.JFrame;

import me.cs158.tag.events.DisplayEvent;
import me.cs158.tag.main.Scroll;

public class TurnEightScroll extends DisplayEvent{
	public TurnEightScroll() {
		super(new Scroll("images/turnEight.jpg"));
		JFrame f = new JFrame("HINT");
	}
	
	@Override
	public void actions() {
		f.add(this.src);
		f.setSize(this.src.getWidth() + 20, this.src.getHeight() + 40);
		f.setVisible(true);
		f.toFront();
		f.repaint();
	}
}
