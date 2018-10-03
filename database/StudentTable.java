package database;


import java.util.List;
import org.hibernate.Session;

public class StudentTable extends DatabaseAccess {

	private Session session;
	
	public StudentTable() throws Exception
	{
		super();
	}
	
	public boolean addStudent(Student student)
	{
		session = sf.getCurrentSession();
		boolean success = false;
		try {
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			session.close();
			success = true;
		}
		catch (Exception e) {}
		return success;
	}
	
	public boolean addStudents(List<Student> students)
	{
		boolean success = false;
		try {
			for (Student student : students)
			{
				addStudent(student);
			}
			success = true;
		}
		catch (Exception e) {}
		return success;
	}
	
	public void editFirst(int row, String newFirst)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Student student = session.get(Student.class, row);
		student.setFirst(newFirst);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editLast(int row, String newLast)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Student student = session.get(Student.class, row);
		student.setLast(newLast);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editId(int row, String newId)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Student student = session.get(Student.class, row);
		student.setId(newId);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, Student student)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Student oldStudent = session.get(Student.class, row);
		oldStudent.setFirst(student.getFirst());
		oldStudent.setLast(student.getLast());
		oldStudent.setId(student.getId());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Student student = session.get(Student.class, row);
			session.delete(student);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public List<Student> getStudents()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Student> students = session.createQuery("from Student").getResultList();
		session.close();
		return students;
	}
}
