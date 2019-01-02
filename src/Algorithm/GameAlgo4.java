package Algorithm;

import Coords.myCoords;
import Geom.Point3D;

public class GameAlgo4 {
 /**
  * this function gives the azimuth between two points.
  * @param playerPoint : the first point that represents the player current position
  * @param destPoint : the destination point.
  * @return azimuth.
  */
	public static double movePlayer(Point3D playerPoint,Point3D destPoint) {
		double[]azi=new double[3];
		myCoords m = new myCoords();
		azi=m.azimuth_elevation_dist(playerPoint, destPoint); //the calculation of the azimuth
		return azi[0];
	}
}
