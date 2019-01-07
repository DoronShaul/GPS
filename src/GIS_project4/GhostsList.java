package GIS_project4;

import java.util.ArrayList;
import java.util.Iterator;

public class GhostsList {
	
	/**
	 * this method is a constructor.
	 */
	public GhostsList() {
		alg=new ArrayList<Ghost>();
	}
	
	/**
	 * this method is a copy constructor.
	 * @param gl: the given ghost list.
	 */
	public GhostsList(GhostsList gl) {
		this.alg=gl.alg;
	}
	
	/**
	 * this method adds a ghost to the ghosts list.
	 * @param g: the given ghost.
	 */
	public void add(Ghost g) {
		this.alg.add(g);
	}
	
	/**
	 * this method returns the iterator of the ghosts list.
	 * @return
	 */
	public Iterator<Ghost> Iterator() {
		return alg.iterator();
	}
	
	/**
	 * this method prints the ghosts list.
	 */
	public void print() {
		Iterator<Ghost> it = alg.iterator();
		while(it.hasNext()) {
			Ghost temp= it.next();
			System.out.println(temp);
		}
	}
	
	/**
	 * this method clears the ghosts list.
	 */
	public void clear() {
		alg.clear();
	}
	
	/**this function updates each ghost location according to the game board. 
	 * 
	 * @param split :the relevant line in the board which represents the ghost.
	 */
	public void updateGhost(String [] split) {
		Iterator<Ghost> itg = this.Iterator();
		while(itg.hasNext()) {
			Ghost temp = itg.next();
			if(temp.getId()==Integer.parseInt(split[1])) {  
				temp.setLat(Double.parseDouble(split[2])); //sets the temp ghost latitude according to the game board 
				temp.setLon(Double.parseDouble(split[3])); //sets the temp ghost longitude according to the game board
			}
		}
	}
	
	//////private/////
	private ArrayList<Ghost> alg = new ArrayList<Ghost>();

	

	
}
