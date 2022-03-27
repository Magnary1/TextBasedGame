
public class User extends Character {

	public User(String symbol, int health, int attackDamage) {
		super(symbol, health, attackDamage);
		
	}

	@Override
	void attack() {
		health -= 20;
	}

}
