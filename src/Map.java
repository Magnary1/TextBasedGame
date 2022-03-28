import java.util.ArrayList;
import java.util.Scanner;

public class Map {

	User user = new User("you", "X", 100, 4, false, false, false, 0);
	
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	Monster rat = new Monster("rat", "R", 10, 5, true, false, false, 1);
	Monster dog = new Monster("dog", "D", 1, 1000, false, false, false, 1);
	Monster bear = new Monster("bear", "B", 50, 10, false, true, true, 2);
	Monster boss = new Monster("king", "K", 200, 20, false, false, false, 100);
	
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
		
		System.out.println();
		printBattleStart(currMonster);
		
		String input = scnr.next();
		while (!input.toLowerCase().equals("run")) {
			System.out.println();
			switch (input) {
			case "attack":
				user.attackSequence(currMonster);
//				currMonster.dropItem(user); // necessary. trying to simplify
//				currMonster.attack(user); // necessary. trying to simplify
				break;
			case "heal":
				user.heal();
				break;
			case "run":
				System.out.println("You run away!");
				break;
			case "help":
				printFightMenu(currMonster);
				break;
			case "pet":
				currMonster.dropItem(user);
				break;
			default:
				System.out.println("Nothing interesting happens. \"help\" for valid commands.");
				break;
			}
			if (user.getHealth() == 0) {
				return;
			}
			System.out.println();
			input = scnr.next();
		}
		
	}

//	private void petTheDog(Monster currMonster) {
//		
//		
//	}

	public void printBattleStart(Monster currMonster) {
		System.out.print("You have run into ");
		
		if (currMonster.getName().equals("king")) {
			System.out.print("the ");
		} else {
			System.out.print("a ");
		}
		System.out.println(currMonster.getName() + "! (" + currMonster.getHealth() + " health)");
		
		System.out.println("What would you like to do?\n");
		
		printFightMenu(currMonster);
	}

	public void printFightMenu(Monster currMonster) {
		System.out.println("---------------FIGHT MENU---------------\n");
		System.out.println("Attack - attack");
		System.out.println("Heal - heal " + user.getHealthBar());
		if (currMonster.getName().equals("dog")) {
			System.out.println("Pet - pet the dog");
		}
		System.out.println();
		System.out.println("Run - run");
		System.out.println("Help - display commands\n");
		System.out.println("---------------FIGHT MENU---------------");
		System.out.println();

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
				System.out.print(monsterList.get(i).symbol + ": " + monsterList.get(i).getName());
			} else {
				System.out.print(monsterList.get(i).symbol + ": " + monsterList.get(i).getName() + ", ");
			}
		}
		System.out.println();
		
		
	}

}

