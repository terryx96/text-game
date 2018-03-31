package me.cs158.tag.main;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;

import me.cs158.tag.player.*;

public class Main {
	
	public static enum SUCCESS { TRUE, FALSE, PARTIAL }
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		Player p = createCharacter();
		Board b = new Board(10);
		System.out.println("Hello");
		
		while(true) {
			System.out.println("Hi");
			p.move();
		}
		
		/*
		 * This just puts the picture on the screen, I'll make a method for it, and a local directory 
		 * for pictures so it works on computers besides mine
		 * 
		 * Scroll test = new Scroll("C:/Users/Terry/Desktop/east.jpg"); <----- Only works on mine lol fuck
		 * JFrame f = new JFrame("HINT");
		 * f.add(test);
		 * f.setSize(test.getWidth() + 20, test.getHeight() + 40);
		 * f.setVisible(true);
		 */
	}
	
	public static Player createCharacter() {
		System.out.println("What is your name:\n"
						+ ">>>");
		String name = input.nextLine();
		System.out.print("What class will you play?\n"
						+ "Archer, Paladin, Wizard, Knight, Warrior\n"
						+ ">>>");
		String classChoice = input.nextLine().toLowerCase();
		
		switch(classChoice){
		case "archer": return new Archer(name, 100, 50);
		case "knight": return new Knight(name, 200, 30);
		case "warrior": return new Warrior(name, 150, 50);
		case "wizard": return new Wizard(name, 80, 200);
		case "paladin": return new Paladin(name, 120, 100);
		default: return new Knight(name, 200, 30);
		}
	}
	
	
	
	
	
}
