package database;

import java.util.List;
import org.hibernate.Session;

public class SoftwareTable extends DatabaseAccess{
	
	private Session session;
	
	public SoftwareTable() throws Exception 
	{
		super();
	}
	
	public boolean addSoftware(Software software)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			session.save(software);
			session.getTransaction().commit();
			session.close();
		} catch (Exception e) {}
		return success;
	}
	
	public boolean addSoftwares(List<Software> softwares)
	{
		boolean success = false;
		try {
			for (Software software : softwares)
			{
				addSoftware(software);
			}
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public void editName(int row, String name)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Software software = session.get(Software.class, row);
		software.setName(name);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editQuantity(int row, String quantity)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Software software = session.get(Software.class, row);
		software.setQuantity(quantity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editDescription(int row, String description)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Software software = session.get(Software.class, row);
		software.setDescription(description);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editKeysAvailable(int row, String keysAvailable)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Software software = session.get(Software.class, row);
		software.setKeysAvailable(keysAvailable);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, Software software)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Software oldSoftware = session.get(Software.class, row);
		oldSoftware.setName(software.getName());
		oldSoftware.setQuantity(software.getQuantity());
		oldSoftware.setDescription(software.getDescription());
		oldSoftware.setKeysAvailable(software.getKeysAvailable());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Software software = session.get(Software.class, row);
			session.delete(software);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e){}
		return success;
	}
	
	public List<Software> getSoftware()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Software> software = session.createQuery("from Software").getResultList();
		session.close();
		return software;
	}
}
