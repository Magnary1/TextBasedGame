import java.util.ArrayList;
import java.util.Scanner;

public class Map {

	User user = new User("X", 100, 20, false, false, false, 0);
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	Monster rat = new Monster("rat", "R", 20, 5, true, false, false, 2);
	Monster dog = new Monster("dog", "D", 1000, 1000, false, false, false, 1);
	Monster bear = new Monster("bear", "B", 20, 5, false, true, true, 5);
	Monster boss = new Monster("king", "K", 20, 5, false, false, false, 100);
	
	public void addMonsters() {
		monsterList.add(rat);
		monsterList.add(dog);
		monsterList.add(bear);
		monsterList.add(boss);
		
		for (int i=0; i<monsterList.size(); i++) {
			for (int j=0; j<monsterList.size(); j++) {
				if (i==j) {
					continue;
				} else if (monsterList.get(i).getXY().equals(monsterList.get(j).getXY()) 
						|| monsterList.get(i).getXY().equals(user.getXY())) {
					monsterList.get(i).resetLocation();
				}
			}
		}
	}
	
	public int getFightingMonsterIndex() {
		
		for (int i=0; i<monsterList.size(); i++) {
			if (monsterList.get(i).getXY().equals(user.getXY())) {
				return i; //get monster index of what you're fighting
			}
		}
		return -1;  // -1 = not fighting monster
	}
	

	public void executeBattle(int fightingMonsterIndex, Scanner scnr) {
		Monster currMonster = monsterList.get(fightingMonsterIndex);
		
		printBattleStart(currMonster);
		
		String input = scnr.next();
	
		while (!input.toLowerCase().equals("run")) {
			switch (input) {
			case "attack":
				user.attack(currMonster);
				currMonster.dropItem(user);
				currMonster.attack(user);
				break;
			case "heal":
				
				break;
			case "run":
				System.out.println("You run away");
				break;
			case "help":
				printFightMenu();
				break;

			default:
				break;
			}
			input = scnr.next();
		}
		
	}

	public void printBattleStart(Monster currMonster) {
		System.out.print("You have run into ");
		
		if (currMonster.getType().equals("king")) {
			System.out.print("the ");
		} else {
			System.out.print("a ");
		}
		System.out.println(currMonster.getType() + "! (" + currMonster.getHealth() + " health)");
		
		System.out.println("What would you like to do?\n");
		
		printFightMenu();
	}

	public void printFightMenu() {
		System.out.println("Attack - attack");
		System.out.println("Heal - heal");
		System.out.println("Run - run");
		System.out.println("Help - display commands");
	}
	public void printMap() {
		for (int y=5; y>=1; y--) {  // creates map XY with bottom left box being point (1,1)
			
			for (int j=0; j<41;j++) {
				System.out.print("-");
			}
			
			System.out.println();
			
			for (int j=0; j<3; j++) {
				for (int x=1; x<=6; x++) {
					
					boolean foundMatch = false;
					
					for (int z=0; z<monsterList.size(); z++) {
						if (j==1 && x!=6 && monsterList.get(z).getXY().equals(x + " " + y)) {//if monster is at XY on map
							if (user.getXY().equals(monsterList.get(z).getXY()) ) { //if monster and user are at same XY on map
								System.out.print("|  " + user.symbol + "@" + monsterList.get(z).symbol + "  "); //print them together
							} else {
								System.out.print("|   " + monsterList.get(z).symbol + "   "); // if not, just print the monster symbol
							}
							foundMatch = true;
							break;
						}
					}
					if (foundMatch == false && j==1 && x!=6 && user.getXY().equals(x + " " + y)) { // if user is at XY, print user symbol
						System.out.print("|   " + user.symbol + "   ");
					} else if (foundMatch == false){
						System.out.print("|       ");
					}
				}
				System.out.println();
			}
		}
		for (int j=0; j<41;j++) {
			System.out.print("-");
		}
		System.out.println();
		printMapKey();
		
	}

	private void printMapKey() {
		System.out.print(user.symbol + ": You, ");
		for (int i=0; i<monsterList.size(); i++) {
			if (monsterList.size()-1 == i) {
				System.out.print(monsterList.get(i).symbol + ": " + monsterList.get(i).getType());
			} else {
				System.out.print(monsterList.get(i).symbol + ": " + monsterList.get(i).getType() + ", ");
			}
		}
		System.out.println();
		
		
	}

}

