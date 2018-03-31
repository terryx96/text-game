package me.cs158.tag.monsters;
import me.cs158.tag.main.Util;

import java.util.ArrayList;

public abstract class Monster {
	private int health;
	private int strength = 1;
	protected ArrayList<String> sentences;
	
	public Monster(int hp) {
		this.health = hp;
	}
	
	public String speak() {
		int temp = (int) (Math.random()*this.sentences.size() + 1) - 1; //The last index of the monster's sentences
		return sentences.get(temp);										//will be reserved for it's introduction
	}																	//only. The -1 on the outside prevents 
																		//it from being used again
	public int attack() {
		return Util.random(10) * this.strength;
	}
}
