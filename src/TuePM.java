public class TuePM {

	public static String[][] map;
	public static int myXCoord;
	public static int myYCoord;
	public static int NUM_OF_ROWS = 10;
	public static int NUM_OF_COLUMNS = 10;

	public static void main(String[] arguments) {
		System.out.println("hello world");
		map = new String[NUM_OF_ROWS][NUM_OF_COLUMNS];
		myXCoord = 5;
		myYCoord = 5;
		for (int i = 0; i < NUM_OF_ROWS; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				map[i][j] = "";
			}
		}
		map[5][5] = "a forest";
		map[5][6] = "a mountain";
		map[4][5] = "a castle";
		map[5][4] = "a canyon";
		map[6][5] = "a meadow";
		System.out.println("You are curently in " + showMyLocation(myXCoord, myYCoord, map));
		System.out.println(showSurroundings(myXCoord, myYCoord, map));
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
