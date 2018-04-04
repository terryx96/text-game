package me.cs158.tag.main;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import me.cs158.tag.events.Event;
import me.cs158.tag.events.hostile.GhostFight;
import me.cs158.tag.events.passive.Dummy;
import me.cs158.tag.monsters.Monster;
import me.cs158.tag.monsters.Sandbag;
import me.cs158.tag.player.*;

public class Main {
	
	public static enum SUCCESS { TRUE, FALSE, PARTIAL }
	public static Scanner input = new Scanner(System.in);
	public static Player p;
	public static Board b;
	public static Event currentPosition;
	
	public static void main(String[] args) {
		p = createCharacter();
		b = new Board(10, p);	
		
		
		
		
		do{
			p.move();
			b.checkPos(p);
			currentPosition = b.getBoard(p.getX(), p.getY());

			if(currentPosition.getClass().getPackage().getName().equals("me.cs158.tag.events.hostile")) {
				enterFight();
			}
			else {
				currentPosition.actions();
			}
		}
		while(p.getAlive());
		

	}
	
	public static Player createCharacter() {
		System.out.print("What is your name:\n"
						+ ">>> ");
		String name = input.nextLine();
		System.out.println();
		System.out.print("What class will you play?\n"
						+ "Archer, Paladin, Wizard, Knight, Warrior\n"
						+ ">>> ");
		String classChoice = input.nextLine().toLowerCase();
		System.out.println();
		switch(classChoice){
		case "archer": return new Archer(name, 100, 50);
		case "knight": return new Knight(name, 200, 30);
		case "warrior": return new Warrior(name, 150, 50);
		case "wizard": return new Wizard(name, 80, 200);
		case "paladin": return new Paladin(name, 120, 100);
		default: return new Knight(name, 200, 30);
		}
	}
	
	public static void enterFight() {
		System.out.println(currentPosition.getDescription());
		
		do {
			System.out.println("--------------------------------\n"
							 + "ATTACK | ABILITY | DEFEND | ITEM");
			String choice = input.nextLine();
			switch(choice.toLowerCase()) {
			case "attack": attack(); break;
			case "ability": ability(); break;
			case "defend" : defend(); break;
			case "item" : item(); break;
			default: continue;
			}
			currentPosition.actions();
			
		}
		while(currentPosition.groupHealth() > 0 && p.getHealth() > 0);
		
		if(p.getHealth() <= 0) {
			die();
		}
		else {
		System.out.println("You win!");
		b.setBoard(p.getX(), p.getY(), new Dummy());
		}
	}
	
	private static void attack() {
		ArrayList<Monster> enemies = currentPosition.getEnemies();
		if(enemies.size() > 1) {
			currentPosition.displayEnemies();
			System.out.print("\nWhich enemy will you attack >>> ");
			try {
				int choice = input.nextInt();
				p.attack(enemies.get(choice-1));
				if(!enemies.get(choice-1).getAlive()) {
					enemies.remove(enemies.get(choice-1));
				}
				input.nextLine();
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Pick an enemy!");
			}
		}
		else {
			currentPosition.displayEnemies();
			p.attack(enemies.get(0));
			}
		System.out.println("--------------------------------");
		
		
	}
	
	private static void ability() {
		ArrayList<Monster> enemies = currentPosition.getEnemies();
		if(enemies.size() > 1) {
			currentPosition.displayEnemies();
			System.out.print("\nWhich enemy will you attack >>> ");
			try {
				int choice = input.nextInt();
				p.ability(enemies.get(choice-1));
				if(!enemies.get(choice-1).getAlive()) {
					enemies.remove(enemies.get(choice-1));
				}
				input.nextLine();
			}
			catch(java.util.InputMismatchException e) {
				System.out.println("Pick an enemy!");
			}
		}
		else {
			currentPosition.displayEnemies();
			p.attack(enemies.get(0));
			}
		System.out.println("--------------------------------");
		
		
	}
	
	public static void defend() {
		System.out.println("You brace for impact");
	}
	
	public static void item() {
		System.out.println("--------------------------------");
		System.out.print("Select an item to use:\n>>>");
		p.displayInventory();
		int choice = input.nextInt();
		//p.getInventory().getItems().get(choice-1).use();
		
	}
	
	public static void die() {
		p.kill();
		System.out.println("\nYou have died!\nGame over.");
	}
	
	
	
	
	
	
}
