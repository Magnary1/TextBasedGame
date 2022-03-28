import java.util.Random;

public class User extends Character {
	
	public User(String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap, boolean hasBearHands,
			int healthPotions) {
		super(symbol, health, attackDamage, hasKey, hasMap, hasBearHands, healthPotions);
		// TODO Auto-generated constructor stub
	}

	void attack(Monster monster) {
		
		if (monster.getHealth() == 0) {
			System.out.println("Stop, it's already dead!");
			return;
		}
		
		Random randGen = new Random();
		
		int monsterCurrHealth = monster.getHealth();
		int damageDealt = randGen.nextInt(this.getAttackDamage() + 1);
		
		if (damageDealt > monsterCurrHealth) {
			damageDealt = monsterCurrHealth;
		}
		
		monsterCurrHealth -= damageDealt;

		monster.setHealth(monsterCurrHealth);
		
		if (monster.getHealth() == 0) {
			System.out.println("You have killed the " + monster.getType() + "!");
		} else {
			System.out.println("The " + monster.getType() + " takes " + damageDealt + " damage. (" + 
								monster.getHealth() + "/" + monster.getMaxHealth() + " health)");
		}
	}

}
