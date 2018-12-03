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
	private static ArrayList<String[]> arr = new ArrayList<>();

	private static String headLine="MAC,SSID,AuthMode,FirstSeen,Channel,RSSI,CurrentLatitude,CurrentLongitude,AltitudeMeters,AccuracyMeters,Type,"; //the head line of the csv file.

	public static void writeCsvFile(String fileName) {

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
