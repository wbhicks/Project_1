import java.util.Scanner;
public class TuePM {

	public static String[][] map;
	public static int myXCoord;
	public static int myYCoord;
	public static int NUM_OF_ROWS = 10;
	public static int NUM_OF_COLUMNS = 10;
	public static Location[][] bigMap;

	public static void main(String[] arguments) {
		System.out.println("hello world");
		map = new String[NUM_OF_ROWS][NUM_OF_COLUMNS];
		myXCoord = 5;
		myYCoord = 5;
		bigMap = new Location[NUM_OF_ROWS][NUM_OF_COLUMNS];
		for (int i = 0; i < NUM_OF_ROWS; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				map[i][j] = "a plain";
			}
		}
		for (int i = 0; i < NUM_OF_ROWS; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				bigMap[i][j].environment = "a plain";
			}
		}
		map[5][5] = "a forest";
		map[5][6] = "a mountain";
		map[4][5] = "a castle";
		map[5][4] = "a canyon";
		map[6][5] = "a meadow";
		Scanner myScanner = new Scanner(System.in);
		while (true) {
			System.out.println("You are curently at "
					+ showMyLocation(myXCoord, myYCoord, map));
			System.out.println(showSurroundings(myXCoord, myYCoord, map));
			System.out.println("which direction do you want to go?");
			String answer = myScanner.nextLine();
			myXCoord = myXCoord + moveWestOrEast(answer);
			myYCoord = myYCoord + moveNorthOrSouth(answer);
		}
	}

	public static int moveWestOrEast(String direction){
		int result = 0;
		if (direction.equals("east")){
			result = 1;
		} else if (direction.equals("west")){
			result = -1;
		}
		return result;
	}
	
	public static int moveNorthOrSouth(String direction){
		int result = 0;
		if (direction.equals("north")){
			result = 1;
		} else if (direction.equals("south")){
			result = -1;
		}
		return result;
	}
	
	public static String showMyLocation(int x, int y, String[][] myMap) {
		return myMap[x][y];
	}

	

	public static String showSurroundings(int x, int y, String[][] myMap) {
		String nResult = whatIsToTheNorth(x, y, myMap);
		String eResult = whatIsToTheEast(x, y, myMap);
		String sResult = whatIsToTheSouth(x, y, myMap);
		String wResult = whatIsToTheWest(x, y, myMap);

		return " To your north is " + nResult + ", to your east is " + eResult
				+ ", to your south is " + sResult + ", to your west is " + wResult;

	}

	public static String whatIsToTheNorth(int x, int y, String[][] myMap) {
		String result = "";
		if (y <= NUM_OF_COLUMNS) {
			result = myMap[x][y + 1];
		}
		return result;
	}

	public static String whatIsToTheEast(int x, int y, String[][] myMap) {
		String result = "";
		if (x <= NUM_OF_ROWS) {
			result = myMap[x + 1][y];
		}
		return result;
	}

	public static String whatIsToTheSouth(int x, int y, String[][] myMap) {
		String result = "";
		if (y > 0) {
			result = myMap[x][y - 1];
		}
		return result;
	}

	public static String whatIsToTheWest(int x, int y, String[][] myMap) {
		String result = "";
		if (x > 0) {
			result = myMap[x - 1][y];
		}
		return result;
	}

	public static String directionAsString(int myX, int myY, int x, int y) {
		
		String result = ""; 
		if (y < myY) {
			result = "north";
		} else if (y > myY) {
			result = "south";
		}
		if (x < myX) {
			result += "west";
		} else if (x > myX) {
			result += "east";
		}
		return result;
	}
}
