public class LoadFile {

	public static go() {
		BufferedReader reader = new BufferedReader(new FileReader("test_map.txt"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println("(" + line + ")")
		}
	}
}
