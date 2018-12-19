package GIS;

/**
 * this class represents pacman. pacman has id, latitude, longitude, altitude, speed and radius.
 */
public class Pacman {
	
	/**
	 * this method is a constructor.
	 */
	public Pacman() {
		id=0;
		lat=0;
		lon=0;
		alt=0;
		speed=1;
		radius=1;
	}
	/**
	 * this method is a constructor.
	 */
	public Pacman(int id, double lat, double lon, double alt, double speed, double radius) {
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
	public Pacman(Pacman p) {
		this.id=p.id;
		this.lat=p.lat;
		this.lon=p.lon;
		this.alt=p.alt;
		this.speed=p.speed;
		this.radius=p.radius;
	}
	
	public String toString() {
		String s="Pacman id: "+id+" ,lat: "+lat+" ,lon: "+lon+" ,alt: "+alt+" ,speed: "+speed+" ,radius: "+radius;
		return s;
	}
	
	public int getId() {
		return id;
	}
	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

	public double getAlt() {
		return alt;
	}
	
	
	public double getSpeed() {
		return speed;
	}
	

	public double getRadius() {
		return radius;
	}


	//////private//////
	private int id;
	private double lat;
	private double lon;
	private double alt;
	private double speed;
	private double radius=1;
}
