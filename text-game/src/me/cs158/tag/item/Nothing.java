package me.cs158.tag.item;

import me.cs158.tag.player.Player;

public class Nothing extends Item {
	
	private static final Items ITEM = Items.NOTHING;
	
	public Nothing() {
		super(ITEM, ITEM.toString());
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Nothing);
	}
	
	public Item copy() {
		return new Nothing();
	}
	
	@Override
	public boolean use(Player p) {
		return false;
	}
	
}
