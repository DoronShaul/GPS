package GIS;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Arrays;

import javax.jws.Oneway;

import Coords.myCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class Element implements GIS_element {

	/**
	 * this function is constructor.
	 */
	public Element() {
		this.MAC=null;
		this.SSID=null;
		this.AuthMode=null;
		this.FirstSeen=null;
		this.Channel=null;
		this.RSSI=null;
		this.point=new Point3D(0, 0, 0);
		this.AccuracyMeters=null;
		this.type=null;
	}

	/**
	 * this function is constructor.
	 */
	public Element(String MAC, String SSID, String AuthMode, String FirstSeen,
			String Channel, String RSSI, Point3D coords, String AccuracyMeters, String type) {
		this.MAC=MAC;
		this.SSID=SSID;
		this.AuthMode=AuthMode;
		this.FirstSeen=FirstSeen;
		this.Channel=Channel;
		this.RSSI=RSSI;
		this.point=new Point3D(coords);
		this.AccuracyMeters=AccuracyMeters;
		this.type=type;
	}

	/**
	 * this function is constructor.
	 */
	public static String[] oneElement(Element element) {
		
		String [] res = new String[11];
		res[0]=element.MAC;
		res[1]=element.SSID;
		res[2]=element.AuthMode;
		res[3]=element.FirstSeen;
		res[4]=element.Channel;
		res[5]=element.RSSI;
		res[6]=String.valueOf(element.point.x());
		res[7]=String.valueOf(element.point.y());
		res[8]=String.valueOf(element.point.z());
		res[9]=element.AccuracyMeters;
		res[10]=element.type;
		
		return res;
	}
	
	
	

	/**
	 * this function get the x,y,z values of an element.
	 */
	@Override
	public Geom_element getGeom() {
		Point3D res=new Point3D(this.point.x(),this.point.y(),this.point.x());
		return res;
	}

	
	/**
	 * this function represents all the data of the element, excluded the x,y,z values.
	 */
	@Override
	public Meta_data getData() {
		metaData md=new metaData();
		md.metaData()[0]=this.MAC;
		md.metaData()[1]=this.SSID;
		md.metaData()[2]=this.AuthMode;
		md.metaData()[3]=this.FirstSeen;
		md.metaData()[4]=this.Channel;
		md.metaData()[5]=this.RSSI;
		md.metaData()[6]=this.AccuracyMeters;
		md.metaData()[7]=this.type;
		return md;
	}

	/**
	 * this function gets a vector and translate the x,y,z values to a new point.
	 */
	@Override
	public void translate(Point3D vec) {
		myCoords m = new myCoords();		
		this.point=m.add(this.point, vec);
		
	}
	
	
	////////////private//////////
	
	private String MAC;
	private String SSID;
	private String AuthMode;
	private String FirstSeen;
	private String Channel;
	private String RSSI;
	private String AccuracyMeters;
	private String type;
	private Point3D point;

}
