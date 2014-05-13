package com.dh.core;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	/**
	 * @author chen 2013-11-4
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/gisrf", "root", "sqlpass");
		
		DatabaseMetaData md = conn.getMetaData();
		
		System.out.println(md.getDriverVersion());
	}

}
