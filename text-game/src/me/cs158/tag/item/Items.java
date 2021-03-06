package me.cs158.tag.item;

public enum Items {
	NOTHING,
	BROADSWORD("Broad Sword"),
	POTION("Potion"),
	KEY("Key"),
	BOW("Bow")
	;
	
	private final String name;
	
	private Items() {
		name = null;
	}
	
	private Items(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		if(name == null) {
			return this.name();
		}
		return name;
	}
}
