package Algorithm;

import java.util.Iterator;

import GIS.Fruit;
import GIS.FruitsList;
import GIS.Pacman;
import GIS.Path;
import GIS.PathList;
import Geom.Point3D;

public class GameAlgo {

	/**
	 * this method finds the closest pacman's path to a given fruit, from a path list.
	 * by calculates the time from the last point in the path, to the fruit.
	 * @param fruit: the given fruit.
	 * @param pl: the given path list.
	 * @return ans: double[2]. [0]=pacId, [1]=time.
	 */
	public static double[] closesetPacToFruit(Fruit fruit, PathList pl) {
		double [] ans = new double [2];          //[0]=pacId, [1]=time.
		double minTime= Double.MAX_VALUE;
		int pacId=0;
		Iterator<Path> itpl = pl.Iterator();
		while(itpl.hasNext()) {
			Path tempPath= itpl.next();
			Point3D tempPoint=tempPath.lastPoint();	         //taking the last point of the current path.	
			double tempTime=fruit.distToPoint(tempPoint);       //calculates the distance between the fruit and the path's last point.
			double finalTime=(tempTime/tempPath.getPac().getSpeed())+tempPath.getOverallTime();       //calculate the actual time by considering the pacman's speed and the path's overall time.
			if(finalTime<minTime) {
				minTime=finalTime;
				pacId=tempPath.getId();
			}
		}	
		ans[0]=pacId;
		ans[1]=minTime;

		return ans;
	}
	/**
	 * this method finds the closest fruit to a pacman, from a given pacman's path and fruits list.
	 * @param path: the given pacman's path.
	 * @param fl: the given fruits list.
	 */
	public static Fruit closestFruitToPac(Path path, FruitsList fl) {
		Fruit ans= new Fruit();
		double minTime=Double.MAX_VALUE;
		Point3D lastPoint = path.lastPoint();         //taking the last point of the path.
		Pacman lastPos = new Pacman (path.getPac());  //copy the path's pacman.
		lastPos.setLat(lastPoint.x());                //set the copied pacman's latitude to be as the path's last point latitude.
		lastPos.setLon(lastPoint.y());                //set the copied pacman's longitude to be as the path's last point longitude.              
		lastPos.setAlt(lastPoint.z());                //set the copied pacman's altitude to be as the path's last point altitude.
		Iterator<Fruit> itf = fl.Iterator();
		while(itf.hasNext()) {
			Fruit tempFru = itf.next();
			double tempTime=lastPos.timePacToFruit(tempFru);          //calculates the time that takes to reach the fruit from the path's last point, by using the copied pacman.
			double finalTime=tempTime+path.getOverallTime();          //adds the path's overall time to the tempTime.
			if(finalTime<minTime) {
				minTime=finalTime;
				ans=tempFru;
			}

		}
		return ans;
	}
	/**
	 * this method arrange a path list, by adding the right fruit to his right path.
	 * the method finds the closest path's pacman from a path list to a given fruit, then finds the closest fruit to that pacman's path from a fruits list.
	 * if the given fruit and the closest fruit to the pacman are equals, it adds the fruit to the pacman's path.
	 * @param pl: the given path list.
	 * @param fl: the given fruits list.
	 */
	public static void pathArrange(PathList pl, FruitsList fl) {
		double [] closePacFru= new double [2];         //saves the closest pacman's id, and the time to the fruit.
		while(fl.getSize()>0) {                    	   //while there's still fruits in the fruits list.
			Iterator<Fruit> itf = fl.Iterator();
			while(itf.hasNext()) {
				Fruit tempFru = itf.next();
				closePacFru=closesetPacToFruit(tempFru, pl);              //finds the closest pacman's path to tempFru.
				Path currentPath = pl.searchPath((int)closePacFru[0]);    //currentPath = the closest path to the fruit.
				Fruit closeFru = closestFruitToPac(currentPath, fl);      //finds the closest fruit to the current path.
				if(tempFru==closeFru) {
					currentPath.fruitAdd(tempFru);				//adds the fruit to the current path.
					currentPath.adjustTime(closePacFru[1]-currentPath.getOverallTime());		//adjust the time of the current path.
					fl.remove(tempFru); 				//remove the fruit from the fruits list.
					break;
				}
			}	
		}

	}

}

