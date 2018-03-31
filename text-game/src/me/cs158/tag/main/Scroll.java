package me.cs158.tag.main;

import javax.swing.*; 
import java.io.*; 
import java.awt.*; 
import java.awt.image.*; 
import javax.imageio.*; 

@SuppressWarnings("serial")
public class Scroll extends JPanel{
	private BufferedImage pic;
	private int height;
	private int width; 
	
	public Scroll(String path) {
		super();
		try {
			this.pic = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.height = pic.getHeight();
		this.width = pic.getWidth();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(this.pic, 0, 0, null);
		repaint();
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
}
