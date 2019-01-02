package GIS_project4;

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

	public void setSpeed(double speed) {
		this.speed = speed;
	}


	//////private///////
	int id;
	private double lat;
	private double lon;
	private double alt;
	private double radius;
	private double speed;
}
