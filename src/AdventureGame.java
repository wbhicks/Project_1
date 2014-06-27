import java.util.ArrayList;
import java.util.Scanner;
public class AdventureGame {


	public static int myXCoord;
	public static int myYCoord;
	public static int NUM_OF_ROWS = 10;
	public static int NUM_OF_COLUMNS = 10;
	public static Location[][] bigMap;
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void dump(){
		for(int i = 0; i < NUM_OF_ROWS; i++){
			System.out.println("i =" + i);
			for(int j = 0; j < NUM_OF_COLUMNS; j++){
				System.out.print(bigMap[i][j].items.size());
			}
		}
	}

	public static void initialize(){
		for (int i = 0; i < NUM_OF_ROWS; i++) {
			for (int j = 0; j < NUM_OF_COLUMNS; j++) {
				bigMap[i][j] = new Location();
				bigMap[i][j].environment = "a plain";
				bigMap[i][j].items.add("a pumpkin");
				bigMap[i][j].mobs.add("a creeper");
			}
		}
		bigMap[5][5].environment = "a forest";
		bigMap[5][6].environment = "a mountain";
		bigMap[4][5].environment = "a castle";
		bigMap[5][4].environment = "a canyon";
		bigMap[6][5].environment = "a meadow";
	}
	
	public static void main(String[] arguments) {
		System.out.println("hello world");
		myXCoord = 5;
		myYCoord = 5;
		bigMap = new Location[NUM_OF_ROWS][NUM_OF_COLUMNS];
		initialize();

		while (true) {
			System.out.println("You are curently at "
					+ showMyLocation(myXCoord, myYCoord, Location.convertLocToString(bigMap)));
			System.out.println(showSurroundings(myXCoord, myYCoord, Location.convertLocToString(bigMap)));
			System.out.println("The objects in the room are ");
			ArrayList<String> stuff = showAllObjects(myXCoord, myYCoord, bigMap);
			for (String s : stuff) {
			    System.out.println(s);
			}
		determineAction();	
		}
	}
	
	public static void determineAction (){
		System.out.println("tell me what to do");
		String answer = myScanner.nextLine();
		optPickUp(answer);
		optSummary(answer);
		myXCoord = myXCoord + moveWestOrEast(answer);
		myYCoord = myYCoord + moveNorthOrSouth(answer);
	}

	public static boolean optPickUp(String answer){
		boolean result = false;
		if (answer.length() >= 9) {
			String key = answer.substring(0,8);
			if(key.equals("pick up ")){
				String object = answer.substring(8);
				result = Adventurer.pickUp(bigMap[myXCoord][myYCoord].items, object);
			}
		}
		return result;
	}
	
	public static boolean optSummary(String answer){
		boolean result = false;
		if(answer.equals("show")){
			Adventurer.summarize();
		}
		return result;
	}
	
	public static ArrayList<String> showAllObjects(int x, int y,
			Location[][] map) {

		ArrayList<String> result = map[x][y].items;
		return result;
	}

	public static int moveWestOrEast(String direction) {
		int result = 0;
		if (direction.equals("east")) {
			result = 1;
		} else if (direction.equals("west")) {
			result = -1;
		}
		return result;
	}

	public static int moveNorthOrSouth(String direction) {
		int result = 0;
		if (direction.equals("north")) {
			result = 1;
		} else if (direction.equals("south")) {
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
				+ ", to your south is " + sResult + ", to your west is "
				+ wResult;

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
