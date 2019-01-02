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
	
	public void add(Ghost g) {
		this.alg.add(g);
	}
	
	public Iterator<Ghost> Iterator() {
		return alg.iterator();
	}
	
	public void print() {
		Iterator<Ghost> it = alg.iterator();
		while(it.hasNext()) {
			Ghost temp= it.next();
			System.out.println(temp);
		}
	}
	
	public void clear() {
		alg.clear();
	}
	
	//////private/////
	private ArrayList<Ghost> alg = new ArrayList<Ghost>();

	

	
}
