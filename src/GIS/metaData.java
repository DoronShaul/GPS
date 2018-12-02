package GIS;

import Geom.Point3D;

public class metaData implements Meta_data {
	
	public metaData() {
		this.metaData = new String [8];
	}
	
	public String[] metaData() {
		String [] res= new String[8];
		return res;
	}

	public String toString() {
		String res="MAC: "+this.metaData()[0]+"SSID: "+this.metaData()[1]+"AuthMode: "+this.metaData()[2]
				+"FirstSeen: "+this.metaData()[3]+"Channel: "+this.metaData()[4]+"RSSI: "+this.metaData()[5]
						+"AccuracyMeters: "+this.metaData()[6]+"type: "+this.metaData()[7];
		
		
		return res;		
	}
	
	
	@Override
	public long getUTC() {
		String s= this.metaData()[3];
		int spaceIndex=s.indexOf(" ");
		s=s.substring(spaceIndex+1);
		long utc = Long.parseLong(s);
		return utc;
	}

	@Override
	public Point3D get_Orientation() {

		
		return null;
	}
	
	
	/////////private///////////
	
	private String [] metaData = new String [8];

}
