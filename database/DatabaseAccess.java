package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DatabaseAccess {
	
	protected SessionFactory sf;
	
	public DatabaseAccess() throws Exception {
		sf = new Configuration()
				.configure()
				.addAnnotatedClass(Student.class).addAnnotatedClass(Adaptor.class).addAnnotatedClass(Client.class)
				.addAnnotatedClass(Computer.class).addAnnotatedClass(Employee.class).addAnnotatedClass(Equipment.class)
				.addAnnotatedClass(ITClub.class).addAnnotatedClass(Software.class)
				.buildSessionFactory();
	}
		
	public void close() {
		try {
			sf.close();
		}
		catch (Exception e) {
			System.out.println("Could not close connection");
		}
	}
	
}