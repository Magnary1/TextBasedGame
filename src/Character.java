
public abstract class Character {
	Location location = new Location();
	
	protected String symbol;
	protected int health;
	protected int attackDamage;
	protected boolean isAlive;
	protected boolean inBattle;
	
	public Character(String symbol, int health, int attackDamage) {
		this.symbol = symbol;
		this.health = health;
		this.attackDamage = attackDamage;
	}
	
	abstract void attack();
	
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

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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
	
}
