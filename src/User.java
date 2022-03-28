import java.util.Random;

public class User extends Character {
	
	public User(String name, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap,
			boolean hasBearHands, int healthPotions) {
		super(name, symbol, health, attackDamage, hasKey, hasMap, hasBearHands, healthPotions);
		// TODO Auto-generated constructor stub
	}

	@Override
	void attack(Character monster) {
		if (monster.getHealth() == 0) {
			System.out.println("Stop, it's already dead!");
			return;
		}
		
		Random randGen = new Random();
		int damageDealt;
		
		if (monster.getName().equals("dog")) {
			this.setHealth(0);
			damageDealt=0;
			printAttackMessage(monster, damageDealt);
			return;
		}  
		
		if (this.getHealth() == 0) {
			return;
		}
		
		
		int characterCurrHealth = monster.getHealth();
		damageDealt = randGen.nextInt(this.getAttackDamage() + 1);
		
		if (damageDealt > characterCurrHealth) {
			damageDealt = characterCurrHealth;
		}
		characterCurrHealth -= damageDealt;

		monster.setHealth(characterCurrHealth);
		
		printAttackMessage(monster, damageDealt);
		
		
		return;
		
	}
	
	@Override
	void printAttackMessage(Character monster, int damageDealt) {
		
		if (monster.getName().equals("dog")) {
			System.out.println("You slip and die an embarassing death. The dog wags its tail.");
		} else {
			if (monster.getHealth() == 0) {
				System.out.println("You have killed the " + monster.getName() + "!");
				return;
			} else if (this.getHasBearHands()) {
				System.out.print("You attack with your bear hands. "); 
			} else {
				System.out.print("You attack with your bare hands. ");
			}
			System.out.println("The " + monster.getName() + " takes " + damageDealt + " damage. ("  
							+ monster.getHealth() + "/" + monster.getMaxHealth() + " health)");
	}
		
	}
}

