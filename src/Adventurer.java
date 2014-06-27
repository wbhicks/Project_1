import java.util.ArrayList;
public class Adventurer {
public static ArrayList<String> inventory = new ArrayList<String>();
public static int health ;

public static boolean pickUp (ArrayList<String> groundItems, String item){
	boolean result = false;
	if(groundItems.remove(item)){
		result = true;
		inventory.add(item);
	} else{
		System.out.println("Sorry, that item is not present.");
	}
	return result;
}

public static boolean drop (ArrayList<String> groundItems, String item){
	boolean result = false;
	if(inventory.remove(item)){
		result = true;
		groundItems.add(item);
	} else{
		System.out.println("Sorry, that item is not in your inventory.");
	}
	return result;
}

public static void summarize (){
	for (String s : inventory){
		System.out.println(s);
	}
}

}
