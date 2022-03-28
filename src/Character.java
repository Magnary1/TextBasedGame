
public abstract class Character {
	Location location = new Location();
	
	protected String symbol;
	private int health;
	final private int MAX_HEALTH;
	private int attackDamage;
	private boolean hasKey;
	private boolean hasMap;
	private boolean hasBearHands;
	private int healthPotions;
	private String name;
	
	protected boolean isAlive;
	protected boolean inBattle;
	
	public Character(String name, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap, boolean hasBearHands, int healthPotions) {
		this.setName(name);
		this.symbol = symbol;
		this.health = health;
		this.MAX_HEALTH = health;
		this.attackDamage = attackDamage;
		this.hasKey = hasKey;
		this.hasMap = hasMap;
		this.hasBearHands = hasBearHands;
		this.setHealthPotions(healthPotions);
	}
	
	abstract void attack(Character character);
		
	abstract void printAttackMessage(Character character, int damageDealt);

	public void move(String input) {
		switch (input) {
		case "right":
			this.location.moveRight();
			break;
		case "left":
			this.location.moveLeft();
			break;
		case "up":
			this.location.moveUp();
			break;
		case "down":
			this.location.moveDown();
			break;
		default:
			break;
		}
	}
	
	public String getXY() {
		return this.location.getXY();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxHealth() {
		return MAX_HEALTH;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public boolean isInBattle() {
		return inBattle;
	}

	public void setInBattle(boolean inBattle) {
		this.inBattle = inBattle;
	}

	public boolean getHasKey() {
		return hasKey;
	}

	public void setHasKey(boolean hasKey) {
		this.hasKey = hasKey;
	}

	public boolean getHasMap() {
		return hasMap;
	}

	public void setHasMap(boolean hasMap) {
		this.hasMap = hasMap;
	}

	public boolean getHasBearHands() {
		return hasBearHands;
	}

	public void setHasBearHands(boolean hasBearHands) {
		this.hasBearHands = hasBearHands;
	}

	public int getHealthPotions() {
		return healthPotions;
	}

	public void setHealthPotions(int healthPotions) {
		this.healthPotions = healthPotions;
	}


	
}
