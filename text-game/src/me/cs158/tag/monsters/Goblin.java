package me.cs158.tag.monsters;

import me.cs158.tag.main.Main;
import me.cs158.tag.main.Util;

public class Goblin extends Monster{
	
	
	public Goblin(int hp, int d) {
		super(hp, d);
	}
	
	@Override
	public void attack() {
		System.out.println("Goblin attacks!");
		Main.p.changeHealth(-Util.random(1000, 100000));
	}
	
	@Override
	public void taunt() {
		String[] sentences = {"Nyeahahahaa!!", "Bahhhh!!", "Die!?"};
		System.out.println(sentences[Util.random(2)]);
	}
}
