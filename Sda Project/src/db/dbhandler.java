package db;

import java.sql.*;
//import java.util.ArrayList;

public class dbhandler {
	public void enteremp() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");

			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
		}
	}
	public void verifyloginemp() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root", "root");//Establishing connection
			System.out.println("Connected With the database successfully");

			
		} catch (SQLException e) {
			System.out.println("Error while connecting to the database");
		}
	}
	

}
