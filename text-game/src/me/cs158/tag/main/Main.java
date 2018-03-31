package me.cs158.tag.main;
import java.util.Scanner;

import me.cs158.tag.monsters.Sandbag;
import me.cs158.tag.player.*;

public class Main {
	
	public static enum SUCCESS { TRUE, FALSE, PARTIAL }
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//Player p = createCharacter();
		Board b = new Board(10);	
		Player x = new Archer("Terry", 10,10);
		System.out.println(x);
		
		Sandbag poorboy = new Sandbag(1000, 2);
		System.out.println(poorboy.getHp());
		while(poorboy.dead()) {
			x.attack(poorboy);
			System.out.println(poorboy.getHp());
		}
		
		
		
		/*while(true) {
			p.move();
			b.checkPos(p);
			b.getBoard(p.getxpos(), p.getypos()).actions();
			
			
		}
		*/

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
	
	
	
	
	
	
	
}
