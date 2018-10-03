package database;

import java.util.List;
import org.hibernate.Session;

public class EmployeeTable extends DatabaseAccess {

	private Session session;
	
	public EmployeeTable() throws Exception
	{
		super();
	}
	
	public boolean addEmployee(Employee employee)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public boolean addEmployees(List<Employee> employees)
	{
		boolean success = false;
		try {
			for (Employee employee : employees)
			{
				addEmployee(employee);
			}
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public void editFirst(int row, String first)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, row);
		employee.setFirst(first);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editLast(int row, String last)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, row);
		employee.setLast(last);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editPosition(int row, String position)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, row);
		employee.setPosition(position);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editPhone(int row, String phone)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, row);
		employee.setPhone(phone);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editEmail(int row, String email)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee employee = session.get(Employee.class, row);
		employee.setEmail(email);
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateRow(int row, Employee employee)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Employee oldEmployee = session.get(Employee.class, row);
		oldEmployee.setFirst(employee.getFirst());
		oldEmployee.setLast(employee.getLast());
		oldEmployee.setPosition(employee.getPosition());
		oldEmployee.setPhone(employee.getPhone());
		oldEmployee.setEmail(employee.getEmail());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Employee employee = session.get(Employee.class, row);
			session.delete(employee);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public List<Employee> getEmployees()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Employee> employees = session.createQuery("from Employee").getResultList();
		session.close();
		return employees;
	}
}
