package File_format;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * this class is used to read from a csv file.
 */
public class csvReader {

	public static ArrayList<String[]> csv(String fileName) {
		
		ArrayList<String[]> array = new ArrayList<>();

		File file=new File(fileName);

		try {
			
			Scanner inputStream=new Scanner(file);
			inputStream.useDelimiter(",");       //split the data where there is comma.
			while(inputStream.hasNext()) {
				String[]s=new String[11];
				for(int i=0;i<11;i++) {
					String data=inputStream.next();
					s[i]=data;                      //insert the relevance data to it's place in the string's array.
					if(!inputStream.hasNext()) {
						break;
					}
				}
				array.add(s);            //adding the string to the array list.
			}
			inputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return array;	
	}
	public static void main(String[] args) {
		ArrayList<String[]> a = csv("6678.csv");
		a.remove(0);
			
		Csv2kml.writeFileKML(a, "8899.kml");
	}
}
