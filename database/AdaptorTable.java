package database;


import java.util.List;
import org.hibernate.Session;

public class AdaptorTable extends DatabaseAccess{
	
	private Session session;
	
	public AdaptorTable() throws Exception {
		super();
	}
	
	public boolean addAdaptor(Adaptor adaptor)
	{
		boolean success = false;
		session = sf.getCurrentSession();
		try {
			session.beginTransaction();
			session.save(adaptor);
			session.beginTransaction().commit();
			session.close();
			success = true;
			
		} catch (Exception e) {}
		
		return success;
	}
	
	public boolean addAdaptors(List<Adaptor> adaptors)
	{
		boolean success = false;
		try {
			for (Adaptor adaptor : adaptors)
			{
				addAdaptor(adaptor);
			}
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public void editName(int row, String name)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Adaptor adaptor = session.get(Adaptor.class, row);
		adaptor.setName(name);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editQuantity(int row, String quantity)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Adaptor adaptor = session.get(Adaptor.class, row);
		adaptor.setQuantity(quantity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editLocation(int row, String location)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Adaptor adaptor = session.get(Adaptor.class, row);
		adaptor.setLocation(location);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editComment(int row, String comment)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Adaptor adaptor = session.get(Adaptor.class, row);
		adaptor.setComment(comment);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, Adaptor adaptor)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Adaptor oldAdaptor = session.get(Adaptor.class, row);
		oldAdaptor.setName(adaptor.getName());
		oldAdaptor.setQuantity(adaptor.getQuantity());
		oldAdaptor.setLocation(adaptor.getLocation());
		oldAdaptor.setComment(adaptor.getComment());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Adaptor adaptor = session.get(Adaptor.class, row);
			session.delete(adaptor);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public List<Adaptor> getAdaptors()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Adaptor> adaptors = session.createQuery("from Adaptor").getResultList();
		session.close();
		return adaptors;
		
	}

}
