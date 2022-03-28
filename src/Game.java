import java.util.Scanner;

//public static boolean atEnemy(Location userLocation, Location ) {
//
//	return false;
//}



public class Game {
	
	public static void printGameStart(User user) {
		System.out.println("You have started the game.");
		System.out.println("What would you like to do?");
		System.out.println();
		printMenu(user);
	}
	
	public static void printMenu(User user) {
		System.out.println("---------------MENU---------------\n");
		System.out.println("Right - move right");
		System.out.println("Left - move left");
		System.out.println("Up - move up");
		System.out.println("Down - move down\n");
		
		System.out.println("Map - display map");
		System.out.println("Heal - heal " + user.getHealthBar() + "\n");
		System.out.println("Help - display commands");
		System.out.println("Quit - end game\n");
		System.out.println("---------------MENU---------------");
	}
	
	public static void executeMenu(String input, Map gameMap, Scanner scnr) {
		input.toLowerCase();
		
		switch (input) {
		case "help":
			printMenu(gameMap.user);
			break;
		case "right":
		case "left":
		case "up":
		case "down":
    		gameMap.user.move(input);
    		if (gameMap.getFightingMonsterIndex() == -1) {
//    			System.out.println("You move " + input + ", but there's nothing of interest.");
    			break;
    		} else {
    			gameMap.executeBattle(gameMap.getFightingMonsterIndex(), scnr);
    		}  //NECESSARY- TRYING TO MOVE SOMEHWERE ELSE
			break;
		case "map":
    		gameMap.printMap();
			break;
		case "heal":
			gameMap.user.heal();
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
                
        printGameStart(gameMap.user);
        String input = scnr.next();
        
        while (!input.toLowerCase().equals("quit")) {
        	executeMenu(input, gameMap, scnr);
        	System.out.println();
        	
        	if (gameMap.user.getHealth() == 0) {
        		printNewGamePrompt();
        		boolean newGameStarted = executeNewGame(scnr, gameMap);
        		if (!newGameStarted) {
        			return;
        		} else {
        			gameMap = new Map();
    		        gameMap.addMonsters();  
    				for (int i=0; i<10; i++) {
    					System.out.println();
    				}
    		        printGameStart(gameMap.user);
        		}
        	}
        	
        	
        	input = scnr.next();
        	
        }
        scnr.close();

	}

	private static boolean executeNewGame(Scanner scnr, Map gameMap) {
		String input = scnr.next();
		boolean newGameCreated = false;
		
		while (!input.toLowerCase().equals("quit") && !newGameCreated) {
			switch (input) {
			case "again":
		        newGameCreated = true;
		        break;
			case "quit":
		        newGameCreated = false;
				break;
			default:
				System.out.println("Nothing interesting happens.");
				input = scnr.next();
				break;
			}
		}
		return newGameCreated;
		
		
	}

	public static void printNewGamePrompt() {
		System.out.println("Play again?");
		System.out.println();
		System.out.println("Again - play again");
		System.out.println("Quit - to quit");
	}


}
