package me.cs158.tag.item;

public class Nothing extends Item {
	
	private static final Items ITEM = Items.NOTHING;
	
	public Nothing() {
		super(ITEM, ITEM.toString());
	}
	
	@Override
	public boolean equals(Object o) {
		return (o instanceof Nothing);
	}
	
}
