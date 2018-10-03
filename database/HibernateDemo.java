package database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.ArrayList;

import org.hibernate.Session;

public class HibernateDemo /*console demo of some of the back end functions*/ {

	public static void printStudents(ArrayList<Student> students)
	{
		System.out.println("Current table contents: ");
		for (Student student : students)
		{
			System.out.println(student.toString());
		}
	}
	
	public static void main(String[] args) {
		System.out.println("This demo will set up the tables, but some prior set up"
				+ "/n  will still be necessary.  If the demo does not run properly make"
				+ "/n sure that you have set up mysql, and run Setup.java."
				+ "/n It will also be necessary to make sure that the hibernate.cfg.xml file included"
				+ "/n has the proper information (password and user) for your database in it.");
		ArrayList<Student> students = new ArrayList<Student>();
		ArrayList<Student> outputStudents = new ArrayList<Student>();
		Student extraStudent = new Student("Extra","Student","0045");
		students.add(new Student("Jane", "Plain", "3746"));
		students.add(new Student("John","Doe","2783"));
		TableSetup ts = new TableSetup();
		try {
			ts.setUp();
		} catch (Exception e) {
			System.out.println("Setup failed it may have been done before, if not see above message");
		}
		
		try {
			ts.resetDemo();
			StudentTable table = new StudentTable();
			table.addStudents(students);
			outputStudents.addAll(table.getStudents());
			printStudents(outputStudents);
			outputStudents.clear();
			
			//add student
			System.out.println("Adding student");
			table.addStudent(extraStudent);
			outputStudents.addAll(table.getStudents());
			printStudents(outputStudents);
			outputStudents.clear();
			
			//modify a student
			System.out.println("Modifying a student");
			table.editLast(1, "Extraordinary");
			outputStudents.addAll(table.getStudents());
			printStudents(outputStudents);
			outputStudents.clear();
			
			//delete a student
			System.out.println("Deleting a student");
			table.deleteRow(3);
			outputStudents.addAll(table.getStudents());
			printStudents(outputStudents);
			outputStudents.clear();
			table.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}