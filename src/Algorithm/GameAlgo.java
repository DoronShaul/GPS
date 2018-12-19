package Algorithm;

import java.awt.Point;
import java.util.Iterator;

import Coords.myCoords;
import GIS.Fruit;
import GIS.FruitsList;
import GIS.Pacman;
import GIS.PacmanList;
import GIS.Path;
import GIS.PathList;
import Geom.Point3D;

public class GameAlgo {

	/**
	 * this method calculate the time from pacman to a fruit, as a function of distance/speed of pacman.
	 * @param p: the given pacman.
	 * @param f: the given fruit.
	 */
	public static double timePacToFruit(Pacman p, Fruit f) {
		Point3D pacPoint = new Point3D(p.getLat(), p.getLon(), p.getAlt());
		Point3D fruPoint = new Point3D(f.getLat(), f.getLon(), f.getAlt());
		myCoords m = new myCoords();
		double time=0;
		time=(m.distance3d(pacPoint, fruPoint))/p.getSpeed();        //time=the time that takes the pacman to reach the fruit.
		return time;
	}

	/**
	 * this method arranging the paths in the paths list. finding for each fruit which path it belongs to. 
	 * @param pl: the given paths list. initialized with all the pacman paths.
	 * @param fl: the given fruits list.
	 */
	public static void arrangePath(PathList pl, FruitsList fl) {
		double minTime=Double.MAX_VALUE;
		int minPacId=0;                         //the id of the closest pacman to the fruit.
		Iterator<Fruit> itFruit = fl.Iterator();
		while(itFruit.hasNext()) {
			Fruit tempFruit = itFruit.next();         //the current fruit.
			Iterator<Path> itPath = pl.Iterator();
			while(itPath.hasNext()) {
				Path tempPath = itPath.next();        //the current path.
				Point3D currentPoint = tempPath.lastPoint();      //the last point in the current path. 
				Pacman tempPac = new Pacman(tempPath.getId(), currentPoint.x(), currentPoint.y(),
						currentPoint.z(), tempPath.getSpeed(), tempPath.getRadius());        //creating a temp pacman with the values of it's last position.
				double time=timePacToFruit(tempPac, tempFruit)+tempPath.getOverallTime();        //the time takes the temp pacman to reach the fruit. take in consideration it's overall time. 
				if(time<minTime) {
					minTime=time;
					minPacId=tempPac.getId();
				}
			}
			(pl.searchPath(minPacId)).fruitAdd(tempFruit);         //adds the current fruit to the right path.
			(pl.searchPath(minPacId)).adjustTime(minTime);         //adjusts the time of the path.
			minTime=Double.MAX_VALUE;
		}
		fl.clear();
	}

}

