package me.cs158.tag.main;

import me.cs158.tag.player.Knight;
import me.cs158.tag.player.Wizard;

public class Main {
	
	//public static enum SUCCESS { TRUE, FALSE, PARTIAL }
	
	public static void main(String[] args) {
		Knight terry = new Knight("Terry", 100,3);
		Wizard preston = new Wizard("Preston",100,100);
		System.out.println(terry);
		System.out.println(preston);
	}
	
}
