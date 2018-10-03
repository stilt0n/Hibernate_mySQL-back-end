package database;

import java.util.List;
import org.hibernate.Session;

public class ITClubTable extends DatabaseAccess {
	
	Session session;
	
	public ITClubTable() throws Exception
	{
		super();
	}
	
	public boolean addRow(ITClub itClub)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			session.save(itClub);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public boolean addRows(List<ITClub> itClubs)
	{
		boolean success = false;
		try {
			for (ITClub itClub : itClubs)
			{
				addRow(itClub);
			}
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public void editName(int row, String name) 
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		ITClub itClub = session.get(ITClub.class, row);
		itClub.setName(name);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editDescription(int row, String description) 
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		ITClub itClub = session.get(ITClub.class, row);
		itClub.setDescription(description);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editQuantity(int row, String quantity) 
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		ITClub itClub = session.get(ITClub.class, row);
		itClub.setQuantity(quantity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editComment(int row, String comment) 
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		ITClub itClub = session.get(ITClub.class, row);
		itClub.setComment(comment);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, ITClub itClub)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		ITClub oldItClub = session.get(ITClub.class, row);
		oldItClub.setName(itClub.getName());
		oldItClub.setDescription(itClub.getDescription());
		oldItClub.setQuantity(itClub.getQuantity());
		oldItClub.setComment(itClub.getComment());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			ITClub itClub = session.get(ITClub.class, row);
			session.delete(itClub);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public List<ITClub> getITClub()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<ITClub> itClub = session.createQuery("from ITClub").getResultList();
		session.close();
		return itClub;
	}
}
