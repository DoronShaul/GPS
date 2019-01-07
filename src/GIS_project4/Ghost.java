package GIS_project4;

import Geom.Point3D;

public class Ghost {
	/**
	 * this method is a constructor.
	 */
	public Ghost() {
		id=0;
		lat=0;
		lon=0;
		alt=0;
		radius=1;
		speed=1;
	}
	
	/**
	 * this method is a constructor.
	 */
	public Ghost(int id, double lat, double lon, double alt, double speed, double radius) {
		this.id=id;
		this.lat=lat;
		this.lon=lon;
		this.alt=alt;
		this.speed=speed;
		this.radius=radius;
	}
	
	/**
	 * this method is a copy constructor.
	 */
	public Ghost(Ghost g) {
		this.id=g.id;
		this.lat=g.lat;
		this.lon=g.lon;
		this.alt=g.alt;
		this.speed=g.speed;
		this.radius=g.radius;
	}
	
	public String toString() {
		String s="Ghost id: "+id+" ,lat: "+lat+" ,lon: "+lon+" ,alt: "+alt+" ,speed: "+speed+" ,radius: "+radius;
		return s;
	}
	
	/**
	 * this method returns the ghost's id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * this method sets the ghost's id.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * this method returns the ghost's latitude.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * this method sets the ghost's latitude.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * this method returns the ghost's longitude.
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * this method sets the ghost's longitude.
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * this method returns the ghost's altitude.
	 */
	public double getAlt() {
		return alt;
	}

	/**
	 * this method sets the ghost's altitude.
	 */
	public void setAlt(double alt) {
		this.alt = alt;
	}

	/**
	 * this method returns the ghost's radius.
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * this method sets the ghost's radius.
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * this method returns the ghost's speed.
	 */
	public double getSpeed() {
		return speed;
	}
	
	/**
	 * this method sets the ghost's speed.
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * this method returns a point with the ghost location.
	 */
	public Point3D ghostToPoint() {
		Point3D ans = new Point3D(this.getLat(), this.getLon());
		return ans;
	}
	//////private///////
	int id;
	private double lat;
	private double lon;
	private double alt;
	private double radius;
	private double speed;

}
