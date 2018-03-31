package me.cs158.tag.item;

public enum Items {
	NOTHING,
	BROADSWORD("Broad Sword"),
	MANA_POTION("Mana Potion")
	;
	
	private final String name;
	
	private Items() {
		name = null;
	}
	
	private Items(String value) {
		name = value;
	}
	
	@Override
	public String toString() {
		if(name == null) {
			return this.name();
		}
		return name;
	}
}
