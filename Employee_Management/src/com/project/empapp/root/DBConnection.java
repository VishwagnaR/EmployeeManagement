package com.project.empapp;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	private static String url= "jdbc:mysql://localhost:3306/employee";
	private static String user= "root";
	private static String password= "root";

	public static Connection createDBConnection() {

		try {
			// Load diver

			Class.forName("com.mysql.jdbc.Driver");
			
			// Get Connection

			con = DriverManager.getConnection(url, user, password);
			

		} catch (Exception e) {
			System.out.println("Connection Failed");
		}
		return con;

	}

}
