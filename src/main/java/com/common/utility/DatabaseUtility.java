/**
 * Author:- Manjeet Kumar
 */

package com.common.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.training.constants.ConfigConstant;
import com.training.webdriverhelper.BaseTestSetup;

public class DatabaseUtility extends BaseTestSetup {

	private static Logger logger = LoggerFactory.getLogger(DatabaseUtility.class);

	private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    public static String databaseType;
	
    public DatabaseUtility() throws SQLException, IOException{

    	configDataList = readConfigData();
    	databaseType = configDataList.get(ConfigConstant.DATABASENAME).toString();
    }

	@SuppressWarnings("static-access")
	public Connection getDBConnection(String databaseType) {
		this.databaseType = databaseType;

		try{
		if (connection == null || connection.isClosed()) {

			switch (databaseType) {

			case "mysql":
				// URL of mySQl database server
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {					
					e1.printStackTrace();
				}  
				  
				connection = DriverManager.getConnection(properties.getProperty("dbConnectionURL"), properties.getProperty("dbUserName"),
						properties.getProperty("dbPassword"));
				break;

			case "oracle":

				// properties for creating connection to Oracle database
				properties.setProperty("user", "scott");
				properties.setProperty("password", "tiger");

				// creating connection to Oracle database using JDBC
				connection = DriverManager.getConnection(properties.getProperty("dbConnectionURL"), properties);
				break;

			case "sql":
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
					properties.put("user", properties.getProperty("dbUserName"));
					//properties.put("password", "secret");
					connection = DriverManager.getConnection(properties.getProperty("dbConnectionURL"));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return connection;
    }

	@SuppressWarnings("unused")
	public String executeQuery(String query){
		int count = 0;
		String result = null;
		boolean found = true;

		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			 while (resultSet.next()) {
				 result = resultSet.getString(1);
				 count++;
             }

             if (count <=  0) {
                 found = false;
             }

		connection.close();
		}
		catch (SQLException e) {
			logger.error("There is no entry in database or the query resulted empty data set!" , e);
		}


		return result;

	}
}
