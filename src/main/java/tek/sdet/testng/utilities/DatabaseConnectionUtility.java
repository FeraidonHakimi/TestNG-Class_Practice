package tek.sdet.testng.utilities;

import com.aventstack.extentreports.service.ExtentTestManager;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DatabaseConnectionUtility {
	
	/*Code inside the class has written to connect us to the dataBase
	 * 
	 * JDBC(Java DataBase Connectivity): In order to connect to a dataBase we need to use JDBC.
	 * JDBC is the libraries which allow us to connect to DataBase(MySQL, SQL Server and ...)
	 * Then for connecting to DataBase we must have bellow information:
	 * UserName:
	 * Password:
	 * URl: jdbc:mysql://tek-database-server.mysql.database.azure.com:3306/tek_insurance_app?useSSL=true&requireSSL=false
	 * URl syntax = jdbc:DataBaseType://Host:port/DataBaseName
	 * URL must contain these sections:
	 * DataBaseType: jdbc:mysql
	 * Host: tek-database-server.mysql.database.azure.com
	 * Port: 3306
	 * DataBaseName: tek_insurance_app
	 * 
	 * Note: this information will provided by developer or dataBase Manager
	 * 
	 * Steps of JDBC:
	 * 
	 * Step 1: make connection to data base using connection interface - 
	 * we also use driverManager class which come from JDBC in order to establish the 
	 * connection between java and DB And then pass the URL, UserName, pasword
	 * 
	 * Step 2 : when connection is done, we use statement method
	 * in order to establish to send query
	 * 
	 * Step 3 : ExecuteQuery method to send our swl query.
	 * 
	 * Step 4 : Return the resultSet interface
	 * 
	 * Step 5 : Store the resultSet in collection(HashMap)
	 * 
	 * Note: in every framework that we want to use JDBC in order to connect with DB
	 * we use take care of the dependency of that.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
    private final String url;
    private final String username;
    private final String password;

    public DatabaseConnectionUtility(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() {
        try {
            ExtentTestManager.getTest().info("Making Connection to Database"); // take care of Extend report
            System.out.println("Making Connection to Database");
            return DriverManager.getConnection(url, username, password);// to connect to dataBase
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            ExtentTestManager.getTest().fail("Failed Making Connection to Database with message " + e.getMessage());
            throw new RuntimeException("Error Connecting to Database");
        }
    }

    private Statement getConnectionStatement() {
        try {
            ExtentTestManager.getTest().info("Creating Connection Statement");
            System.out.println("Creating Connection Statement");
            return getConnection().createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            throw new RuntimeException("Error Error Creating Statement");
        }
    }

    public ResultSet executeQuery(String query) {
        Statement statement;
        try {
            ExtentTestManager.getTest().info("Executing Query " + query);
            System.out.println("Executing Query " + query);
            statement = this.getConnectionStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            ExtentTestManager.getTest().fail("Error Executing Query with message " + e.getMessage());
            throw new RuntimeException("Error executing query");
        }
    }

    public List<Map<String, Object>> convertResultToMap(String query) {
        Statement statement = null;
        try {
            List<Map<String, Object>> list = new LinkedList<>();

            ResultSet resultSet = this.executeQuery(query);
            statement = resultSet.getStatement();
            ResultSetMetaData metadata = resultSet.getMetaData();
            int columns = metadata.getColumnCount();

            while (resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                for (int i = 1; i <= columns; i++) {
                    map.put(metadata.getColumnName(i), resultSet.getObject(i));
                }
                list.add(map);
            }
            return list;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            throw new RuntimeException("Error executing query");
        }finally {
            if (statement != null) {
                try {
                    ExtentTestManager.getTest().info("Attempting to close all database connections");
                    statement.getConnection().close();
                    statement.close();
                } catch (SQLException e) {
                    ExtentTestManager.getTest().fail("Failed to Close Connections " + e.getMessage());
                }
            }
        }
    }

}
