package database;

import java.util.List;
import org.hibernate.Session;

public class ComputerTable extends DatabaseAccess{
	
	private Session session;
	
	public ComputerTable() throws Exception
	{
		super();
	}
	
	public boolean addComputer(Computer computer)
	{
		session = sf.getCurrentSession();
		boolean success = false;
		try {
			session.beginTransaction();
			session.save(computer);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e){}
		return success;
	}
	
	public boolean addComputers(List<Computer> computers)
	{
		boolean success = false;
		try {
			for (Computer computer : computers)
			{
				addComputer(computer);
			}
			success = true;
		} catch (Exception e){}
		return success;
	}
	
	public void editMake(int row, String make)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setMake(make);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editModel(int row, String model)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setModel(model);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editDescription(int row, String description)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setDescription(description);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editCpu(int row, String cpu)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setCpu(cpu);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRam(int row, String ram)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setRam(ram);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editLocation(int row, String location)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setLocation(location);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editFunctional(int row, String functional)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setFunctional(functional);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editServiceTag(int row, String serviceTag)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setServiceTag(serviceTag);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editMac(int row, String mac)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setMac(mac);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editComment(int row, String comment)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setComment(comment);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editHdd(int row, String hdd)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer computer = session.get(Computer.class, row);
		computer.setHdd(hdd);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, Computer computer)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Computer oldComputer = session.get(Computer.class, row);
		oldComputer.setMake(computer.getMake());
		oldComputer.setModel(computer.getModel());
		oldComputer.setDescription(computer.getDescription());
		oldComputer.setCpu(computer.getCpu());
		oldComputer.setRam(computer.getRam());
		oldComputer.setLocation(computer.getLocation());
		oldComputer.setFunctional(computer.getFunctional());
		oldComputer.setServiceTag(computer.getServiceTag());
		oldComputer.setMac(computer.getMac());
		oldComputer.setComment(computer.getComment());
		oldComputer.setHdd(computer.getHdd());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Computer computer = session.get(Computer.class, row);
			session.delete(computer);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e){}
		return success;
	}
	
	public List<Computer> getComputers()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Computer> computers = session.createQuery("from Computer").getResultList();
		session.close();
		return computers;
	}
}
