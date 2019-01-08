package GIS_project4;

import java.util.Iterator;

import Coords.myCoords;
import GIS.Fruit;
import GIS.FruitsList;
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
	
	/**
	 * this method updates the player location.
	 * @param lat: the given latitude.
	 * @param lon: the given logitude.
	 */
	public void updatePlayer(double lat,double lon) {
		this.setLat(lat);
		this.setLon(lon);
	}
	
	/**
	 * this method returns a point from the player location.
	 * @return
	 */
	public Point3D playerToPoint() {
		Point3D point = new Point3D(this.getLat(), this.getLon());
		return point;
	}
	
	public String toString() {
		String s="Player id: "+id+" ,lat: "+lat+" ,lon: "+lon+" ,alt: "+alt+" ,speed: "+speed+" ,radius: "+radius+" ,score: "+score;
		return s;
	}
	/**
	 * this method returns the player's id.
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * this method sets the player's id.
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * this method returns the player's latitude.
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * this method sets the player's latitude.
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * this method returns the player's longitude.
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * this method sets the player's longitude.
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * this method returns the player's altitude.
	 */
	public double getAlt() {
		return alt;
	}

	/**
	 * this method sets the player's altitude.
	 */
	public void setAlt(double alt) {
		this.alt = alt;
	}

	/**
	 * this method returns the player's radius.
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * this method sets the player's radius.
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/**
	 * this method returns the player's speed.
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * this method returns the player's score.
	 */
	public double getScore() {
		return score;
	}

	/**
	 * this method sets the player's speed.
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * this method sets the player's score.
	 */
	public void setScore(double score) {
		this.score = score;
	}

	/**
	 * this method checks if the player location is in a box.
	 * @param b: the given box.
	 * @return true if the player location is in the box, false otherwise.
	 */
	public boolean isInBox(Box b) {
		boolean ans = false;
		if((this.getLat()>=b.getMin().x() && this.getLat()<=b.getMax().x()) &&
				(this.getLon()>=b.getMin().y() && this.getLon()<=b.getMax().y())) {
			ans=true;
		}
		
		return ans;
	}
	
	/**
	 * this method returns the fruit's index of the closest fruit to the player.
	 * @param fl: the given fruits list.
	 */
	public int closestFruitToPlayer(FruitsList fl) {
		int fruitIndex=-1;
		double minDist=Double.MAX_VALUE;
		double dist=0;
		myCoords m = new myCoords();
		Iterator<Fruit> itf = fl.Iterator();
		while(itf.hasNext()) {
			Fruit temp = itf.next();
			dist=m.distance3d(temp.fruitToPoint(), this.playerToPoint());
			if(dist<minDist) {
				minDist=dist;
				fruitIndex=fl.flArray().indexOf(temp);//return the index of the fruit in the arrayList.
			}
		}
		
		return fruitIndex;
	}
	
	/**
	 * this method returns the azimuth from the player to a close ghost. if there is no ghost closer than 4 meters to the player,
	 * the azimuth remains -1. if there is a ghost less than 4 meters from the player, it calculates the azimuth between them,
	 * and return it.
	 * @param gl: the given ghosts list.
	 */
	public double isGhostClose(GhostsList gl) {
		double azimuth=-1;
		double dist=0;
		double [] aziElevDist = new double [2];     //for the azimuth_elevation_dist function.
		myCoords m = new myCoords();
		Iterator<Ghost> itg = gl.Iterator();
		while(itg.hasNext()) {
			Ghost temp = itg.next();
			dist=m.distance3d(this.playerToPoint(), temp.ghostToPoint());
			if(dist<4) {
				aziElevDist=m.azimuth_elevation_dist(this.playerToPoint(), temp.ghostToPoint());
				azimuth=aziElevDist[0];
				break;
			}
		}
		
		return azimuth;
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
