package me.cs158.tag.item.potion;

public enum PotionType {
	NOTHING,
	MANA("Mana"),
	HEALTH("Health"),
	ATTACK("Attack"),
	DEFENSE("Defense")
	;
	
	private final String name;
	
	private PotionType() {
		name = null;
	}
	
	private PotionType(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		if(name == null) {
			return this.name() + " Potion";
		}
		return name;
	}
}
