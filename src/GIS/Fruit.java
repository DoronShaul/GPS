package GIS;

import Coords.myCoords;
import Geom.Point3D;

/**
 * this class represents a fruit. fruit has id, latitude, longitude, altitude and weight.
 */
public class Fruit {
	/**
	 * this method is a constructor.
	 */
	public Fruit() {
		id=0;
		lat=0;
		lon=0;
		alt=0;
		weight=1;
	}
	
	/**
	 * this method is a constructor.
	 */
	public Fruit(int id, double lat, double lon, double alt, double weight) {
		this.id=id;
		this.lat=lat;
		this.lon=lon;
		this.alt=alt;
		this.weight=weight;
	}
	/**
	 * this method is a copy constructor.
	 */
	public Fruit(Fruit f) {
		this.id=f.id;
		this.lat=f.lat;
		this.lon=f.lon;
		this.alt=f.alt;
		this.weight=f.weight;
	}
	/**
	 * this method returns a point with the coordinates values of a fruit.
	 */
	public Point3D fruitToPoint() {
		Point3D point = new Point3D(this.getLat(), this.getLon(), this.getAlt());
		return point;
	}
	/**
	 * this method returns the distance between a fruit and a given point.
	 * @param p: the given point.
	 */
	public double distToPoint(Point3D p) {
		myCoords m = new myCoords();
		double dist=m.distance3d(this.fruitToPoint(), p);
		return dist;
	}

	public String toString() {
		String s="Fruit id: "+id+" ,lat: "+lat+" ,lon: "+lon+" ,alt: "+alt+" ,weight: "+weight;
		return s;
	}
	/**
	 * this method returns the id of the fruit.
	 */
	public int getId() {
		return id;
	}
	/**
	 * this method returns the latitude of the fruit.
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * this method returns the longitude of the fruit.
	 */
	public double getLon() {
		return lon;
	}
	/**
	 * this method returns the altitude of the fruit.
	 */
	public double getAlt() {
		return alt;
	}
	
	
	public double getWeight() {
		return weight;
	}


	//////private//////
	int id;
	double lat;
	double lon;
	double alt;
	double weight;
}
