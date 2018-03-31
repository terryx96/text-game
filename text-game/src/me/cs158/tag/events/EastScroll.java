package me.cs158.tag.events;

import javax.swing.JFrame;

import me.cs158.tag.main.Scroll;

public class EastScroll extends DisplayEvent{
	public EastScroll() {
		super(new Scroll("C:/Users/Terry/Desktop/east.jpg"));
		JFrame f = new JFrame("HINT");
	}
	
	@Override
	public void actions() {
		f.add(this.src);
		f.setSize(this.src.getWidth() + 20, this.src.getHeight() + 40);
		f.setVisible(true);
	}
}
