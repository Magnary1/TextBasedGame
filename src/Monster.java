
public class Monster extends Character {
	boolean hasKey;
	boolean hasMap;
	String type;
	
	public Monster(String type, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap) {
		super(symbol, health, attackDamage);
		this.type = type;
		this.hasKey = hasKey;
		this.hasMap = hasMap;
	}

	@Override
	void attack() {
		// TODO Auto-generated method stub
		
	}

}
