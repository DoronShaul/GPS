package GIS_project4;

import Geom.Point3D;

public class Box {
	/**
	 * this method is a constructor.
	 */
	public Box() {
		id=0;
		min=new Point3D(0, 0);
		max=new Point3D(0, 0);
	}
	/**
	 * this method is a constructor.
	 */
	public Box(int id, Point3D min, Point3D max) {
		this.id=id;
		this.min=min;
		this.max=max;
	}
	/**
	 * this method is a copy constructor.
	 */
	public Box(Box b) {
		this.id=b.id;
		this.min=b.min;
		this.max=b.max;
	}
	
	public String toString() {
		String s="Box id: "+id+" ,minLat: "+min.x()+" ,minLon: "+min.y()+" ,minAlt: "+min.z()+
				" ,maxLat: "+max.x()+" ,maxLon: "+max.y()+" ,maxAlt: "+max.z();
		return s;
	}
	
	
	public Point3D getMin() {
		return min;
	}
	public void setMin(Point3D min) {
		this.min = min;
	}
	public Point3D getMax() {
		return max;
	}
	public void setMax(Point3D max) {
		this.max = max;
	}
	public int getId() {
		return id;
	}


	//////private/////
	private int id;
	private Point3D min;
	private Point3D max;
}
