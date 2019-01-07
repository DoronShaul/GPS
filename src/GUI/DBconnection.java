package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnection {
	
	private double gameHash;
	private double score;
	private int myId;
	private int myId2;
	private int myId3;

	
	public DBconnection() {
		this.gameHash=0;
		this.score=0;
		this.myId=0;
		this.myId2=0;
		this.myId3=0;
	}
	
	public DBconnection(double gameHash, double score, int id, int id2, int id3) {
		this.gameHash=gameHash;
		this.score=score;
		this.myId=id;
		this.myId2=id2;
		this.myId3=id3;
	}
	
	public String dbInfoToString() {
		String ans= "SELECT * FROM logs WHERE ";
		ans+="SomeDouble=" + this.gameHash;	
		ans+=" AND FirstID=" + this.myId;
		return ans;
	}
	
	public static void main(String[] args)
	{
		String jdbcUrl="jdbc:mysql://ariel-oop.xyz:3306/oop"; //?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
		String jdbcUser="student";
		String jdbcPassword="student";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = 
					DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
			
			
			Statement statement = connection.createStatement();
			
			String s = "Ex4_OOP_example4";
			double gameHash=s.hashCode();
			DBconnection dbc = new DBconnection(gameHash, 0, 308545151, 0, 0);
			String ans = dbc.dbInfoToString();
			System.out.println(ans);
			
			//select data
			String allCustomersQuery = ans;
			ResultSet resultSet = statement.executeQuery(allCustomersQuery);
			System.out.println("FirstID\t\tSecondID\tThirdID\t\tLogTime\t\t\t\tPoint\t\tSomeDouble");
			while(resultSet.next())
			{
				System.out.println(resultSet.getInt("FirstID")+"\t\t" +
						resultSet.getInt("SecondID")+"\t\t" +
						resultSet.getInt("ThirdID")+"\t\t" +
						resultSet.getTimestamp("LogTime") +"\t\t\t\t" +
						resultSet.getDouble("Point") +"\t\t" +
						resultSet.getDouble("SomeDouble"));
			}
			
			resultSet.close();		
			statement.close();		
			connection.close();		
		}
		
		catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("Vendor Error: " + sqle.getErrorCode());
		}
		
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
}
