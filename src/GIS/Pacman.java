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
		String s="Packman id: "+id+"\nlat: "+lat+"\nlon: "+lon+"\nalt: "+alt+"\nspeed: "+speed+"\nradius: "+radius;
		return s;
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
	
	
	//////private//////
	int id;
	double lat;
	double lon;
	double alt;
	double speed;
	double radius=1;
}
