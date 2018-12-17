package GIS;

import java.util.*;

/**
 * this class represents pacman list in an array list.
 */
public class PacmanList {
	/**
	 * this method is a constructor.
	 */
	public PacmanList() {
		ArrayList<Pacman> al = new ArrayList<Pacman>();
	}
	/**
	 * this method get the size of the array.
	 */
	public static int getSize() {
		return al.size();
	}
	/**
	 * this method adding a pacman to the list.
	 */
	public static void add(Pacman p) {
		al.add(p);
	}
	/**
	 * this method clear the list.
	 */
	public static void clear() {
		al.clear();
	}
	/**
	 * this method is an iterator.
	 */
	public static Iterator<Pacman> Iterator() {
		return al.iterator();
	}
	/**
	 * this method prints the pacman list.
	 */
	public static void Print() {
		Iterator<Pacman> it = al.iterator();
		while(it.hasNext()) {
			Pacman temp= it.next();
			System.out.println(temp);
		}
	}
	
	
	
	//////private///////
	 static ArrayList<Pacman> al = new ArrayList<Pacman>();
	
}
