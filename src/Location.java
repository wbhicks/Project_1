import java.util.ArrayList;
public class Location {
public ArrayList<String> items = new ArrayList<String>();
public ArrayList<Mob> mobs = new ArrayList<Mob>();
public String environment;
public int temperature;

public static String[][] convertLocToString (Location[][] initialMap){
	String[][] map = new String[AdventureGame.NUM_OF_ROWS][AdventureGame.NUM_OF_COLUMNS];
	for(int i = 0; i < AdventureGame.NUM_OF_ROWS; i++){
		for(int j = 0; j < AdventureGame.NUM_OF_COLUMNS; j++){
			map[i][j] = initialMap[i][j].environment;
		}
	}
	return map;
}

}