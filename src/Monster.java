
public class Monster extends Character {
	private String type;
	
	public Monster(String type, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap, boolean hasBearHands,
			int healthPotions) {
		super(symbol, health, attackDamage, hasKey, hasMap, hasBearHands, healthPotions);
		this.setType(type);
	}

	
//	public Monster(String type, String symbol, int health, int attackDamage, boolean hasKey, boolean hasMap) {
//		super(symbol, health, attackDamage);
//		this.type = type;
//		this.HasKey(hasKey);
//		this.hasMap(hasMap);
//	}

	void attack(User user) {
		// TODO Auto-generated method stub
		
	}

	public void resetLocation() {
		this.location.resetLocation();
	}

	public void dropItem(User user) {
		if (this.getHealth() == 0) {
			if (this.getHasKey()) {
				user.setHasKey(true);
				this.setHasKey(false);
				System.out.println("The " + this.type + " has dropped a key!");
			}
			if (this.getHasBearHands()) {
				user.setHasBearHands(true);
				this.setHasBearHands(false);
				System.out.println("The " + this.type + " has dropped bear hands!");
			}
			if (this.getHasMap()) {
				user.setHasMap(true);
				this.setHasMap(false);
				System.out.println("The " + this.type + " has dropped a map!");
			}
			
			
			if (this.getHealthPotions() > 0) {
				user.setHealthPotions(user.getHealthPotions() + this.getHealthPotions());
				this.setHealthPotions(0);
				
				if (this.type.equals("dog")) {
					System.out.println("The nice dog wags its tail and gives you a health potion!");
				}
				System.out.println("The " + this.type + " has dropped health potions!");
			}
		}
		
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}





}
