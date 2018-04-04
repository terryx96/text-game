package me.cs158.tag.item;

import me.cs158.tag.player.Player;

public class Key extends Item {
	
	private static final Items ITEM = Items.KEY;
	private int id;

	public Key(int id) {
		super(ITEM, ITEM.toString() + " " + id);
		this.id = id;
	}
	
	/**
	 * Returns the id of the key
	 * @return	the id of the key
	 */
	public int getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Key)) {
			return false;
		}
		Key key = (Key) o;
		return key.getId() == id;
	}
	
	@Override
	public Item copy() {
		return new Key(id);
	}
	
	@Override
	public boolean use(Player p) {
		return false;
	}
	
}
