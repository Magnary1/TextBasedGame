import java.util.Scanner;

//public static boolean atEnemy(Location userLocation, Location ) {
//
//	return false;
//}



public class Game {
	
	public static void printGameStart() {
		System.out.println("You have started the game.");
		System.out.println("What would you like to do? Type \\\"help\\\" for options.");
		System.out.println();
		printMenu();
	}
	public static void printMenu() {
		System.out.println("Help - displays commands");
		System.out.println("Right - move right");
		System.out.println("Left - move left");
		System.out.println("Up - move up");
		System.out.println("Down - move down");
		System.out.println("Map - displays map");
		System.out.println("Quit - ends game");
		
	}
	
	public static void executeMenu(String input, Map gameMap) {
		input.toLowerCase();
		
		switch (input) {
		case "help":
			printMenu();
			break;
		case "right":
		case "left":
		case "up":
		case "down":
    		gameMap.user.move(input);
			break;
		case "map":
    		gameMap.printMap();
			break;
		default:
			System.out.println("Nothing interesting happens. \"help\" for valid commands.");
			break;
		}
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
        Map gameMap = new Map();
        gameMap.addMonsters();
        
//        System.out.println(gameMap.user.location.getXY());
//        System.out.println(gameMap.rat.location.getXY());
//        System.out.println(gameMap.zombie.location.getXY());
//        System.out.println(gameMap.boss.location.getXY());
//        System.out.println(gameMap.monsterList);
//		gameMap.printMap();

        
        printGameStart();
        String input = scnr.next();
        
        while (!input.toLowerCase().equals("quit")) {
        	executeMenu(input, gameMap);
        	System.out.println();
        	input = scnr.next();
        }
        scnr.close();

	}


}
