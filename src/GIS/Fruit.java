package GIS;

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

	public String toString() {
		String s="Fruit id: "+id+"\nlat: "+lat+"\nlon: "+lon+"\nalt: "+alt+"\nweight: "+weight;
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
	double weight;
}
