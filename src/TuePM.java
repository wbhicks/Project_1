public class TuePM {

	public static String[][] map;
	public static int myXCoord;
	public static int myYCoord;

	public static void main(String[] arguments) {
		System.out.println("hello world");
		map = new String[10][10];
		myXCoord = 5;
		myYCoord = 5;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = "";
			}
		}
		map[5][5] = "forest";
		System.out.println(showMyLocation(myXCoord, myYCoord, map));
	}

	public static String showMyLocation(int a, int b, String[][] myMap) {
		return myMap[a][b];
	}

}
