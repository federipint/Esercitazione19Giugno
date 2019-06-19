package com.gruppo.nuovo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbManager {
	
	private static DbManager singleton;
	private static final String URL_DB = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "SYSTEM";
	private static final String PASSWORD = "password";
	
	
	private DbManager() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");    //carico db
		}catch (ClassNotFoundException ex){
			Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE , null, ex);
		}
		
	}
	
	public static DbManager getInstance() {
		if(singleton==null) {
			singleton = new DbManager();
		}
		return singleton;
	}
	
	
	public Connection getConnection() {
		try {
			Connection conn = DriverManager.getConnection(URL_DB, USER , PASSWORD);
			return conn;
		}catch (SQLException ex) {
			Logger.getLogger(DbManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		return null;
		}

}
