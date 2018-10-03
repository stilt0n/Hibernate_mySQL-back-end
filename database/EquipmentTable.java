package database;

import java.util.List;
import org.hibernate.Session;

public class EquipmentTable extends DatabaseAccess {

	Session session;
	
	public EquipmentTable() throws Exception
	{
		super();
	}
	
	public boolean addEquipment(Equipment equipment)
	{
		session = sf.getCurrentSession();
		boolean success = false;
		try {
			session.beginTransaction();
			session.save(equipment);
			session.getTransaction().commit();
			session.close();
			success = true;
		}
		catch (Exception e) {}
		return success;
	}
	
	public boolean addEquipments(List<Equipment> equipments)
	{
		boolean success = false;
		try {
			for (Equipment equipment : equipments)
			{
				addEquipment(equipment);
			}
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public void editName(int row, String name)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Equipment equipment = session.get(Equipment.class, row);
		equipment.setName(name);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editDescription(int row, String description)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Equipment equipment = session.get(Equipment.class, row);
		equipment.setDescription(description);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editQuantity(int row, String quantity)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Equipment equipment = session.get(Equipment.class, row);
		equipment.setQuantity(quantity);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editLocation(int row, String location)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Equipment equipment = session.get(Equipment.class, row);
		equipment.setLocation(location);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editComment(int row, String comment)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Equipment equipment = session.get(Equipment.class, row);
		equipment.setComment(comment);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, Equipment equipment)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Equipment oldEquipment = session.get(Equipment.class, row);
		oldEquipment.setName(equipment.getName());
		oldEquipment.setDescription(equipment.getDescription());
		oldEquipment.setQuantity(equipment.getQuantity());
		oldEquipment.setLocation(equipment.getLocation());
		oldEquipment.setComment(equipment.getComment());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Equipment equipment = session.get(Equipment.class, row);
			session.delete(equipment);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e){}
		return success;
	}
	
	public List<Equipment> getEquipment()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Equipment> equipment = session.createQuery("from Equipment").getResultList();
		session.close();
		return equipment;
	}
}
