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
		al = new ArrayList<>();
	}
	/**
	 * this method is a copy constructor.
	 * @param fl
	 */
	public FruitsList(FruitsList fl) {
		al= new ArrayList<>();
		Iterator<Fruit> itf = fl.Iterator();
		while(itf.hasNext()) {
			Fruit temp = itf.next();
			al.add(temp);
		}
	}
	/**
	 * this method gets the size of the array.
	 */
	public int getSize() {
		return al.size();
	}
	/**
	 * this method adding fruit to the list.
	 */
	public void add(Fruit f) {
		al.add(f);
	}
	
	/**
	 * this method removes a fruit from the list.
	 * @param f: the fruit to remove.
	 */
	public void remove(Fruit f) {	
		al.remove(f);
	}
	/**
	 * this method returns the last fruit in the list.
	 */
	public Fruit lastFruit() {
		return al.get(al.size()-1);
	}
	/**
	 * this method clears the list.
	 */
	public void clear() {
		al.clear();
	}
	/**
	 * this method returns an iterator.
	 */
	public Iterator<Fruit> Iterator() {
		return al.iterator();
	}
	/**
	 * this method returns an arraylist.
	 */
	public ArrayList<Fruit> flArray() {
		return al;
	}
	/**
	 * this method prints the fruits list.
	 */
	public void print() {
		Iterator<Fruit> it = al.iterator();
		while(it.hasNext()) {
			Fruit temp= it.next();
			System.out.println(temp);
		}
		
	}
	
	//////private///////
	private  ArrayList<Fruit> al = new ArrayList<Fruit>();
}
