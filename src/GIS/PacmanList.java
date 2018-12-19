package GIS;

import java.util.*;

import Geom.Point3D;

/**
 * this class represents pacman list in an array list.
 */
public class PacmanList {
	/**
	 * this method is a constructor.
	 */
	public PacmanList() {
		al = new ArrayList<Pacman>();
	}
	/**
	 * this method get the size of the array.
	 */
	public int getSize() {
		return al.size();
	}
	/**
	 * this method adding a pacman to the list.
	 */
	public void add(Pacman p) {
		al.add(p);
	}
	/**
	 * this method clear the list.
	 */
	public void clear() {
		al.clear();
	}
	/**
	 * this method is an iterator.
	 */
	public Iterator<Pacman> Iterator() {
		return al.iterator();
	}
	/**
	 * this method prints the pacman list.
	 */
	public void Print() {
		Iterator<Pacman> it = al.iterator();
		while(it.hasNext()) {
			Pacman temp= it.next();
			System.out.println(temp);
		}
	}
	
	/**
	 * this method returns the last pacman in the pacman's array.
	 */
	public Pacman lastPacman() {
		return al.get(al.size()-1);
	}
	
	
	
	//////private///////
	private ArrayList<Pacman> al = new ArrayList<Pacman>();
	
}