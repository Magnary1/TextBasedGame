import java.util.ArrayList;

public class Map {

	User user = new User("X", 100, 20);
	ArrayList<Monster> monsterList = new ArrayList<Monster>();
	
	Monster rat = new Monster("rat", "R", 20, 5, true, false);
	Monster zombie = new Monster("zombie", "Z", 20, 5, true, false);
	Monster boss = new Monster("boss", "B", 20, 5, true, false);
	
	public void addMonsters() {
		monsterList.add(rat);
		monsterList.add(zombie);
		monsterList.add(boss);
		
		for (int i=0; i<monsterList.size(); i++) {
			for (int j=0; j<monsterList.size(); j++) {
				if (i==j) {
					continue;
				} else if (monsterList.get(i).location.getXY().equals(monsterList.get(j).location.getXY()) 
						|| monsterList.get(i).location.getXY().equals(user.location.getXY())) {
					monsterList.get(i).location.resetLocation();
				}
			}
		}
	}
	
	public void printMap() {
		for (int y=5; y>=1; y--) {  // creates map XY with bottom left box being point (1,1)
			
			for (int j=0; j<41;j++) {
				System.out.print("-");
			}
			
			System.out.println();
			
			for (int j=0; j<3; j++) {
				
				// if (userPositionX == keyPositionX && userPositionY == keyPositionY) {

				// }

				for (int x=1; x<=6; x++) {
					boolean foundMatch = false;

					for (int z=0; z<monsterList.size(); z++) {
						if (j==1 && x!=6 && monsterList.get(z).location.getX() == x //if monster is at XY on map
								&& monsterList.get(z).location.getY() == y) {
							if (user.location.getXY().equals(monsterList.get(z).location.getXY()) ) { //if monster and user are at same XY on map
								System.out.print("|  " + user.symbol + "@" + monsterList.get(z).symbol + "  "); //print them together
							} else {
								System.out.print("|   " + monsterList.get(z).symbol + "   "); // if not, just print the monster symbol
							}
							foundMatch = true;
							break;
						}
					}
					if (foundMatch == false && j==1 && x!=6 && user.location.getX() == x && user.location.getY() == y) { // if user is at XY, print user symbol
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
	}



	

}

