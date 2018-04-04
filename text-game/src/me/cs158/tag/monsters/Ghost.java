package me.cs158.tag.monsters;
import me.cs158.tag.main.Main;
import me.cs158.tag.main.Util;
import java.util.ArrayList;

public class Ghost extends Monster{
	private int ectoplasm;
	private String type = "Ghost";
	
	public Ghost(int hp, int d, int ecto) {
		super(hp, d);
	}
	
	@Override
	public void attack() {
		System.out.println("Ghost attacks!");
		Main.p.changeHealth(-Util.random(0,this.ectoplasm));
	}
	
	@Override
	public void taunt() {
		String[] sentences = {"Boo!", "Haha!", "You scared?"};
		System.out.println(sentences[Util.random(2)]);
	}
	
	
	
	
	
	
}
