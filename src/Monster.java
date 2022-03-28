import java.util.Random;

public class Monster extends Character {

	public Monster(String name, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap,
			boolean hasBearHands, int healthPotions) {
		super(name, symbol, health, attackDamage, hasKey, hasMap, hasBearHands, healthPotions);
		// TODO Auto-generated constructor stub
	}

	public void resetLocation() {
		this.location.resetLocation();
	}

	public void dropItem(User user) {
		if (this.getHealth() == 0) {
			if (this.getHasKey()) {
				user.setHasKey(true);
				this.setHasKey(false);
				System.out.println("The " + this.getName() + " has dropped a key!");
			}
			if (this.getHasBearHands()) {
				user.setHasBearHands(true);
				user.setAttackDamage(user.getAttackDamage()*2);
				this.setHasBearHands(false);
				System.out.println("The " + this.getName() + " has dropped bear hands!");
			}
			if (this.getHasMap()) {
				user.setHasMap(true);
				this.setHasMap(false);
				System.out.println("The " + this.getName() + " has dropped a map!");
			}
			
			
			if (this.getHealthPotions() > 0) {
				user.setHealthPotions(user.getHealthPotions() + this.getHealthPotions());
				this.setHealthPotions(0);
				
				if (this.getName().equals("dog")) {
					System.out.println("The nice dog wags its tail and gives you a health potion!");
				}
				System.out.println("The " + this.getName() + " has dropped health potions!");
			}
		}
		
	}

	

	@Override
	void attack(Character user) {
				
		if (this.getHealth() == 0) {
			return;
		}
		
		Random randGen = new Random();
		
		int userCurrHealth = user.getHealth();
		int damageDealt = randGen.nextInt(this.getAttackDamage() + 1);
		
		if (damageDealt > userCurrHealth) {
			damageDealt = userCurrHealth;
		}
		userCurrHealth -= damageDealt;

		user.setHealth(userCurrHealth);
		
		printAttackMessage(user, damageDealt);
		
		
		return;
		
		
	}
	
	@Override
	void printAttackMessage(Character user, int damageDealt) {
		
		if (user.getHealth() == 0) {
			System.out.println("The " + this.getName() + " has killed " + user.getName() + "!");
		} else {
			System.out.println("The " + this.getName() + " attacks back and " + user.getName() + " take " 
						+ damageDealt + " damage. (" + user.getHealth() + "/" + user.getMaxHealth() + " health)");
		}
	}
	
}

