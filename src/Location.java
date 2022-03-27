import java.util.Random;

public class Location {
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
		++y;
	}

	public void moveDown() {
		--y;
	}
	
	public void moveRight() {
		++x;
	}
	
	public void moveLeft() {
		--x;
	}


	
}
