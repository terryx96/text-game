package me.cs158.tag.monsters;
import me.cs158.tag.main.Util;
import java.util.ArrayList;

public class Ghost extends Monster{
	private int ectoplasm;
	
	public Ghost(int hp, int ecto) {
		super(hp);
		this.ectoplasm = ecto;
		this.sentences = new ArrayList<String>();
		this.sentences.add("Boo!");
		this.sentences.add("Haha!"); //probably a better way to do this ...
		this.sentences.add("Go away!");
		this.sentences.add("I'm a ghost, fight me!");
	}
	
	@Override
	public int attack() {
		this.speak();
		return Util.random(this.ectoplasm);
	}
	
	@Override
	public String toString() {
		return "Boo! I am a ghost!";
	}
	
	
	
	
	
}
