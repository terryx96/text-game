package me.cs158.tag.item;

public class Key extends Item {
	
	private static final Items ITEM = Items.KEY;
	private int id;

	public Key(int id) {
		super(ITEM, ITEM.toString() + " " + id);
		this.id = id;
	}
	
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
	
}
