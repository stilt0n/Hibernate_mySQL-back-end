package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.PreparedStatement;

/**
 * 
 * This program runs sql scripts to set up database tables
 *
 */
public class TableSetup {

	private String sql;
	private PreparedStatement ps;
	private Connection con;
	
	public static void main(String[] args) {
		TableSetup ts = new TableSetup();
		ts.setUp();
	}
	
	public void setUp()
	{
		System.out.println("This program may not work if you haven't run"
				+ " 'setup' yet. ");
		System.out.println("Getting database connection...");
		
		try {
			//Establishing connection
			Properties properties = new Properties();
			properties.load(new FileInputStream("databaseAccess.properties"));
			
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String url = properties.getProperty("url");
			
			con = DriverManager.getConnection(url,user,password);
			
			System.out.println("Connection successful...");
			System.out.println("Creating database tables...");
			//Adaptor table
			System.out.println("Creating adaptor table...");
			sql = "CREATE TABLE Adaptors("
					+ "LineNumber Integer NOT NULL AUTO_INCREMENT, "
					+ "Name VARCHAR(255) NOT NULL, "
					+ "Quantity VARCHAR(255) NOT NULL, "
					+ "Location VARCHAR(255), "
					+ "Comment VARCHAR(255), "
					+ "PRIMARY KEY (LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//Client table
			System.out.println("Creating client table...");
			sql = "CREATE TABLE Clients("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "Name VARCHAR(255) NOT NULL, "
					+ "Date VARCHAR(255), "
					+ "Computer VARCHAR(255), "
					+ "Diagnosis VARCHAR(255), "
					+ "Proc VARCHAR(255), "
					+ "Functional VARCHAR(255), "
					+ "Comment VARCHAR(255), "
					+ "Password VARCHAR(255), "
					+ "PhoneNumber VARCHAR(25), "
					+ "LeadTech VARCHAR(45), "
					+ "Notes VARCHAR(255), "
					+ "PRIMARY KEY (LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//Computer table
			System.out.println("Creating computer table...");
			sql = "CREATE TABLE Computers("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "Make VARCHAR(255) NOT NULL, "
					+ "Model VARCHAR(255) NOT NULL, "
					+ "Description VARCHAR(255) NOT NULL,"
					+ "CPU VARCHAR(255), "
					+ "RAM VARCHAR(255), "
					+ "Location VARCHAR(255), "
					+ "Functional VARCHAR(45), "
					+ "ServiceTag VARCHAR(255), "
					+ "MAC VARCHAR(255), "
					+ "Comment VARCHAR(255), "
					+ "HDD VARCHAR(255), "
					+ "PRIMARY KEY (LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//Employee Table
			System.out.println("Creating employee table...");
			sql = "CREATE TABLE Employees("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "First VARCHAR(45) NOT NULL, "
					+ "Last VARCHAR(45) NOT NULL, "
					+ "Position VARCHAR(45) NOT NULL, "
					+ "Phone VARCHAR(45), "
					+ "Email VARCHAR(100), "
					+ "PRIMARY KEY (LineNUmber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//Equipment table
			System.out.println("Creating Equipment table...");
			sql = "CREATE TABLE Equipment("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "Name VARCHAR(255), "
					+ "Description VARCHAR(255), "
					+ "Quantity VARCHAR(45), "
					+ "Location VARCHAR(45), "
					+ "Comment VARCHAR(255), "
					+ "PRIMARY KEY (LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//IT Club Table
			System.out.println("Creating IT Club table...");
			sql = "CREATE TABLE ITClub("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "Name VARCHAR(45), "
					+ "Description VARCHAR(255), "
					+ "Quantity VARCHAR(45), "
					+ "Comment VARCHAR(255), "
					+ "PRIMARY KEY(LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//Software Table
			System.out.println("Creating software table...");
			sql = "CREATE TABLE Software("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "Name VARCHAR(255) NOT NULL, "
					+ "Quantity VARCHAR(45), "
					+ "Description VARCHAR(255), "
					+ "KeysAvailable VARCHAR(45), "
					+ "PRIMARY KEY (LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			//Student table
			System.out.println("Creating Student table...");
			sql = "CREATE TABLE Students("
					+ "LineNumber INTEGER NOT NULL AUTO_INCREMENT, "
					+ "FirstName VARCHAR(40) NOT NULL, "
					+ "LastName  VARCHAR(40) NOT NULL, "
					+ "StudentId INTEGER, "
					+ "PRIMARY KEY (LineNumber)"
					+ ");";
			ps = con.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("Creation successful...");
			System.out.println("Table setup complete!");
			
		} catch (Exception e) {
			System.out.println("setup failed");
		}

	}

	public void resetDemo() //truncates student table so indexes don't mismatch on reruns
	{
		String reset = "TRUNCATE TABLE inventory.students;";
		try {
			ps = con.prepareStatement(reset);
			ps.executeUpdate();
		} catch (Exception e) {}
	}
}
