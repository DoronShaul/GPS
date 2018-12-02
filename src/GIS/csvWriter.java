package GIS;

import java.io.FileWriter;
import java.util.ArrayList;


import Geom.Point3D;

/**
 * this class is writing csv file.
 */
public class csvWriter {

	private static String commaDelimiter = ",";
	private static String newLine = "\n";

	private static String headLine="MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,CurrentLatitude,CurrentLongitude,AltitudeMeters,AccuracyMeters,Type,"; //the head line of the csv file.

	public static void writeCsvFile(String fileName) {

		Point3D p=new Point3D(32.1721826821653, 34.8144640170275, 13.6504088889507);
		Point3D p1=new Point3D(32.1722092595607, 34.8144482983188, 15.376435938028);
		Element elem1=new Element("40:65:a3:35:4c:c4", "Efrat", "[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS]", "2017-12-01 10:49:08", "1", "-75", p, "6", "WIFI");
		String [] efrat=Element.oneElement(elem1);
		Element elem2=new Element("08:97:58:32:69:c6", "Volvo247", "[WPA2-PSK-CCMP][WPS][ESS]", "01/12/2017  10:49:14", "4", "-81", p1, "8", "WIFI");
		String [] volvo=Element.oneElement(elem2);
		ArrayList<String[]> arr = new ArrayList<String[]>(); //this array has all the elements.
		arr.add(efrat);
		arr.add(volvo);

		FileWriter fw = null;

		try {
			fw=new FileWriter(fileName);
			fw.append(headLine.toString());     //writing the head line.
			fw.append(newLine);
			for(int i=0;i<arr.size();i++) {        //walking through all the elements in the array.
				String[] temp = arr.get(i);
				for(int j=0;j<temp.length;j++) {     //walking through each category in all the elements, write it and insert a comma after.
					fw.append(temp[j]);
					if(temp!=arr.get(arr.size()-1) || j!=temp.length-1) {    //if it's the last category in the last element, don't write a comma.
						fw.append(commaDelimiter);
					}
					if(j==temp.length-1) {         //after the last category of each element, start a new line.
						fw.append(newLine);
					}
				}
			}
			
			
			System.out.println("CSV file was created successfully !!!");

		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		}
		
		finally {
			try {
				fw.flush();
				fw.close();
				
			} catch (Exception e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
				e.printStackTrace();
			}
		}


	}
	
	public static void main(String[] args) {
		writeCsvFile("6678.csv");
	}
}
