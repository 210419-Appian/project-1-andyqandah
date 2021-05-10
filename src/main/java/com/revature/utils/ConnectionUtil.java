package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection() throws SQLException {
		try {
			
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:postgresql://appian-2021.caxwqy9zrvhv.us-east-2.rds.amazonaws.com:5432/postgres";
		String username = "postgres"; 
		String password = "Ling5128"; 
		
		return DriverManager.getConnection(url, username, password);
	}}
//
//	public static void main(String[] args) {
//try(Connection conn=ConnectionUtil.getConnection()){
//	System.out.println("Connection successful.");		
//}catch(SQLException e)
//{	e.printStackTrace();
//	}}}
//	
	


	
	
