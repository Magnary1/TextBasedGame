import java.util.Random;

public class Location {
	private int amountOfOutOfBoundsAttempts = 0;
    Random randGen = new Random();
    
	private int x = randGen.nextInt(5)+1;
	private int y = randGen.nextInt(5)+1;
	
//	public UserLocation() {
//		x = randGen.nextInt(5)+1;
//		y = randGen.nextInt(5)+1;
//	}
	
	public void resetLocation() {
		x = randGen.nextInt(5)+1;
		y = randGen.nextInt(5)+1;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public String getXY() {
		return x + " " + y;
	}
	
	public void moveUp() {
		if (y == 5) {
			printWallMessage();
			return;
		}
		++y;
	}

	public void moveDown() {
		if (y==1) {
			printWallMessage();
			return;
		}
		--y;
	}
	
	public void moveRight() {
		if (x==5) {
			printWallMessage();
			return;
		}
		++x;
	}
	
	public void moveLeft() {
		if (x==1) {
			printWallMessage();
			return;
		}
		--x;
	}
	
	public void printWallMessage() {
		if (amountOfOutOfBoundsAttempts < 2) {
			System.out.println("You see a bee and decide to not move that way!");
		} else if (amountOfOutOfBoundsAttempts < 4) {
			System.out.println("Several bees seem to be congregating together, so you don't move anywhere!");
		} else {
			System.out.println("Thousands of bees have formed an impenetrable wall, preventing you from moving that way!");			
		}
		++amountOfOutOfBoundsAttempts;
		
	}


	
}
