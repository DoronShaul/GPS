package GIS_project4;

import Geom.Point3D;

public class Player {
	/**
	 * this method is a constructor.
	 */
	public Player() {
		id=0;
		lat=0;
		lon=0;
		alt=0;
		radius=1;
		speed=1;
		score=0;
	}
	
	/**
	 * this method is a constructor.
	 */
	public Player(int id, double lat, double lon, double alt, double speed, double radius, double score) {
		this.id=id;
		this.lat=lat;
		this.lon=lon;
		this.alt=alt;
		this.speed=speed;
		this.radius=radius;
		this.score=score;
	}
	
	/**
	 * this method is a copy constructor.
	 */
	public Player(Player p) {
		this.id=p.id;
		this.lat=p.lat;
		this.lon=p.lon;
		this.alt=p.alt;
		this.speed=p.speed;
		this.radius=p.radius;
		this.score=p.score;
	}
	public void updatePlayer(double lat,double lon) {
		this.setLat(lat);
		this.setLon(lon);
	}
	public Point3D playerToPoint() {
		Point3D point = new Point3D(this.getLat(), this.getLon());
		return point;
	}
	
	public String toString() {
		String s="Player id: "+id+" ,lat: "+lat+" ,lon: "+lon+" ,alt: "+alt+" ,speed: "+speed+" ,radius: "+radius+" ,score: "+score;
		return s;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getSpeed() {
		return speed;
	}
	
	public double getScore() {
		return score;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setScore(double score) {
		this.score = score;
	}

	public boolean isInBox(Box b) {
		boolean ans = false;
		if((this.getLat()>=b.getMin().x() && this.getLat()<=b.getMax().x()) &&
				(this.getLon()>=b.getMin().y() && this.getLon()<=b.getMax().y())) {
			ans=true;
		}
		
		return ans;
	}
	//////private///////
	private int id;
	private double lat;
	private double lon;
	private double alt;
	private double radius;
	private double speed;
	private double score;
}
