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
	 * this method is a copy constructor.
	 * @param pl: the copied pacman list.
	 */
	public PacmanList(PacmanList pl) {
		al= new ArrayList<>();
		Iterator<Pacman> itp = pl.Iterator();
		while(itp.hasNext()) {
			Pacman temp = itp.next();
			al.add(temp);
		}
	}
	/**
	 * this method get the size of the array.
	 */
	public int getSize() {
		return al.size();
	}
	/**
	 * this method returns the index of a given pacman from the pacman list.
	 * @param pac: the given pacman.
	 * @return
	 */
	public int getPacIndex(Pacman pac) {
		return al.indexOf(pac);
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
	
	public boolean isExist(int pacId) {
		Iterator<Pacman> itp = al.iterator();
		while(itp.hasNext()) {
			Pacman temp = itp.next();
			if(temp.getId()==pacId) {
				return true;
			}
		}
		return false;
	}
	/**
	 * updates the fruitsList according to the pacman that are still in the game.
	 * @param ali :the array list of the indexes of the pacman.
	 */
	public void updatePacmanList(ArrayList<Integer> ali) {
		if(this.getSize()!=ali.size()) {
			Iterator<Pacman> itp = this.Iterator();
			while(itp.hasNext()) {
				boolean exists=false;
				Pacman temp = itp.next();
				for(int i=0;i<ali.size();i++) {
					if(temp.getId()==ali.get(i)) { //if the current pacman on  the pacman list still exists
						exists=true;
						break;
					}
				}
				if(!exists) {
					itp.remove(); //if the fruit was eaten it gets removed
				}
			}
		}
		
	}

	//////private///////
	private ArrayList<Pacman> al = new ArrayList<Pacman>();

}
