import java.util.Random;

public class User extends Character {
	
	public User(String name, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap,
			boolean hasBearHands, int healthPotions) {
		super(name, symbol, health, attackDamage, hasKey, hasMap, hasBearHands, healthPotions);
		// TODO Auto-generated constructor stub
	}

	public void attackSequence(Monster currMonster) {
		User user = this;
		boolean canAttack = isAttackable(currMonster);
		
		if (canAttack) {
			attack(currMonster);
			currMonster.dropItem(user); 
			currMonster.attack(user);
		} else {
			printCantAttack();
		}
	}
	
	private void printCantAttack() {
		System.out.println("You try to attack, but you're just so weak. Try fighting something else?");
		
	}

	private boolean isAttackable(Monster currMonster) {
		
		User user = this;
		
		switch (currMonster.getName()) {
		case "rat":
		case "dog":
			return true;
		case "bear":
			if (user.getHasKey()) {
				return true;
			} else {
				return false;
			}
			
		case "king":
			if (user.getHasBearHands()) {
				return true;
			} else {
				return false;
			}

		default:
			System.out.println("issue in isAttackable(). monster name doesn't exist");
			return false;
		}
				
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

	public void heal() {
		int amountToHeal = 20;
		int healthDifference = this.getMaxHealth() - this.getHealth();
		
		if (this.getHealthPotions() == 0) {
			System.out.println("You don't have any health potions!");
			return;
		}
		if (this.getHealth() == this.getMaxHealth()) {
			System.out.println("Your health is already full!");
			return;
		} else if (healthDifference < amountToHeal) {
			amountToHeal = healthDifference;
		}
		
		this.setHealth(this.getHealth() + amountToHeal);
		this.setHealthPotions(this.getHealthPotions()-1);
		System.out.println("You healed for " + amountToHeal + " health. " + this.getHealthBar());
		
	}
}

