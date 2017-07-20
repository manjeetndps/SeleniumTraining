package com.training.abcofselenium;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.common.utility.DatabaseUtility;

public class ConnectToDB {

	private DatabaseUtility databaseUtility;

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws InterruptedException, IOException, SQLException {

		ConnectToDB scrShot = new ConnectToDB();
		Connection connection = null;

		try {
			scrShot.databaseUtility = new DatabaseUtility();

			connection = scrShot.databaseUtility.getDBConnection(scrShot.databaseUtility.databaseType);

			scrShot.databaseUtility.executeQuery("SELECT NAME FROM employee WHERE id = 100;");

			System.out.println("DB connection successful.");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB Connection failed.");
		}

		finally {
			connection.close();
			System.out.println("Connection Closed.");
		}
	}

}
