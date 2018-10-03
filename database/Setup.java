package database;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Setup {
	
	public static void main(String[] args)
	{
	Connection con = null;
	Statement stmt = null;
	String sql = "CREATE DATABASE INVENTORY";
	String filename = "databaseAccess.properties";
	String directory;
	String absolutePath = "";
	String newUrl = "jdbc:mysql://localhost/inventory?useSSL=false";
	Scanner stdIn = new Scanner(System.in);
	
	try {
			Class.forName("com.mysql.jdbc.Driver");
		
			Properties properties = new Properties();
			properties.load(new FileInputStream("setup.properties"));
		
			System.out.println("Enter your mySQL user name: ");
			String user = stdIn.nextLine();
			System.out.println("Enter the password for this mySQL user"
					+ "/n If there is no password leave this input blank and hit enter");
			String password = stdIn.nextLine();
			System.out.println("Setting up url at default local host.  If url is not the default local host please edit the Setup.properties file");
			String url = properties.getProperty("url");
			stdIn.close();
		
			con = DriverManager.getConnection(url,user,password);
		
			System.out.println("Connection to " + url + " successful");
			System.out.println("Creating database...");
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Database created");
			System.out.println("Creating new properties file...");
			directory = System.getProperty("user.dir");
			absolutePath = directory + File.separator + filename;
			System.out.println("Attempting to create file at: " + absolutePath);
			File file = new File(absolutePath);
			if (file.createNewFile())
			{
				System.out.println("Writing to properties file");
			} 
			else {
				System.out.println("File may already exist");
			}
			
			PrintWriter writer = new PrintWriter(file);
			writer.println("url=" + newUrl);
			writer.println("user=" + user);
			writer.println("password=" + password);
			writer.close();
			
			System.out.println("Properties file written successfully");
			con.close();

		}
		catch (Exception e) {
			System.out.println("Failed to write properties file");
			e.printStackTrace();
		}
	
	
	}
}
