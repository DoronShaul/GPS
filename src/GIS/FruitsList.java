package GIS;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class represents fruits list in an array list.
 */
public class FruitsList {
	/**
	 * this method is a constructor.
	 */
	public FruitsList() {
		ArrayList<Fruit> al = new ArrayList<>();
	}
	/**
	 * this method gets the size of the array.
	 */
	public static int getSize() {
		return al.size();
	}
	/**
	 * this method adding fruit to the list.
	 */
	public static void add(Fruit f) {
		al.add(f);
	}
	/**
	 * this method clears the list.
	 */
	public static void clear() {
		al.clear();
	}
	/**
	 * this method is an iterator.
	 */
	public static Iterator<Fruit> Iterator() {
		return al.iterator();
	}
	/**
	 * this method prints the fruits list.
	 */
	public static void print() {
		Iterator<Fruit> it = al.iterator();
		while(it.hasNext()) {
			Fruit temp= it.next();
			System.out.println(temp);
		}
		
	}
	
	//////private///////
	static ArrayList<Fruit> al = new ArrayList<Fruit>();
}
