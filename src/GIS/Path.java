package GIS;

import java.util.ArrayList;
import java.util.Iterator;

import GIS.Fruit;
import GIS.Pacman;
import Geom.Point3D;

/**
 * this method is a constructor.
 */
public class Path {
	/**
	 * this method sets a pacman to the beginning of the path.
	 */
	public Path(Pacman pac) {
		alp = new ArrayList<>();
		pacPath=pac;
		alTime = new ArrayList<>();
		overallTime=0;
		Point3D pacPoint=new Point3D(pac.getLat(), pac.getLon(),pac.getAlt());
		alp.add(pacPoint);
		alTime.add(0.0);
	}

	/**
	 * this method adds a fruit to the path.
	 */
	public void fruitAdd(Fruit f) {
		Point3D fruitPoint=new Point3D(f.getLat(), f.getLon(), f.getAlt());
		alp.add(fruitPoint);
	}
	/**
	 * this method is an iterator.
	 * @return the array of points iterator.
	 */
	public Iterator<Point3D> Iterator() {
		return alp.iterator();
	}
	/**
	 * this method is an iterator.
	 * @return the array of time iterator.
	 */
	public Iterator<Double> timeIterator() {
		return alTime.iterator();
	}

	/**
	 * this method adding the given time to the time list and sums it up with the overall time.
	 * @param time: the given time.
	 */
	public void adjustTime(double time) {
		alTime.add(time);
		double newTime=this.overallTime+time;
		this.overallTime=newTime;
	}
	/**
	 * this method returns the size of the points list of a path.
	 */
	public int getPointListSize() {
		return alp.size();
	}

	/**
	 * this method returns the last point in the points array.
	 */
	public Point3D lastPoint() {
		return alp.get(alp.size()-1);
	}
	/**
	 * this method returns the first point in the points array.
	 */
	public Point3D firstPoint() {
		return alp.get(0);
	}

	/**
	 * this method return the id of the path.
	 */
	public int getId() {
		return pacPath.getId();
	}
	/**
	 * this method return the radius of the path.
	 */
	public double getRadius() {
		return pacPath.getRadius();
	}
	/**
	 * this method return the overall time of the path.
	 */
	public double getOverallTime() {
		return overallTime;
	}

	/**
	 * this method returns the index of the given time in the time list.
	 * @param time: the given time.
	 */
	public int getIndexOfTime(double time) {		
		return alTime.indexOf(time);
	}
	/**
	 * this method returns a point from given index.
	 * @param index: the given index.
	 */
	public Point3D getPointByIndex(int index) {
		return alp.get(index);
	}
	/**
	 * this method return the speed of the path's pacman.
	 */
	public double getSpeed() {
		return pacPath.getSpeed();
	}
	/**
	 * this method return the pacman of the path.
	 */
	public Pacman getPac() {		
		return pacPath;
	}

	/////private//////
	private ArrayList<Point3D> alp = new ArrayList<>();
	private ArrayList<Double> alTime = new ArrayList<>();
	private double overallTime;
	private Pacman pacPath;
	

}
