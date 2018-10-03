package database;

import org.hibernate.Session;
import java.util.List;

public class ClientTable extends DatabaseAccess {
	
	private Session session;
	
	public ClientTable() throws Exception
	{
		super();
	}
	
	public boolean addClient(Client client)
	{
		session = sf.getCurrentSession();
		boolean success = false;
		try {
			session.beginTransaction();
			session.save(client);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public boolean addClients(List<Client> clients)
	{
		boolean success = false;
		try {
			for(Client client : clients)
			{
				addClient(client);
			}
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public void editName(int row, String name)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setName(name);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editDate(int row, String date)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setDate(date);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editComputer(int row, String computer)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setComputer(computer);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editDiagnosis(int row, String diagnosis)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setDiagnosis(diagnosis);
		session.getTransaction().commit();
		session.close();
	}

	public void editProcedure(int row, String procedure)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setProcedure(procedure);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editFunctional(int row, String functional)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setFunctional(functional);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editComment(int row, String comment)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setComment(comment);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editPassword(int row, String password)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setPassword(password);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editPhoneNumber(int row, String phoneNumber)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setPhoneNumber(phoneNumber);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editLeadTech(int row, String leadTech)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setLeadTech(leadTech);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editNotes(int row, String notes)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client client = session.get(Client.class, row);
		client.setNotes(notes);
		session.getTransaction().commit();
		session.close();
	}
	
	public void editRow(int row, Client client)
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		Client oldClient = session.get(Client.class, row);
		oldClient.setName(client.getName());
		oldClient.setDate(client.getDate());
		oldClient.setComputer(client.getComputer());
		oldClient.setDiagnosis(client.getDiagnosis());
		oldClient.setProcedure(client.getProcedure());
		oldClient.setFunctional(client.getFunctional());
		oldClient.setComment(client.getComment());
		oldClient.setPassword(client.getPassword());
		oldClient.setPhoneNumber(client.getPhoneNumber());
		oldClient.setLeadTech(client.getLeadTech());
		oldClient.setNotes(client.getNotes());
		session.getTransaction().commit();
		session.close();
	}
	
	public boolean deleteRow(int row)
	{
		boolean success = false;
		try {
			session = sf.getCurrentSession();
			session.beginTransaction();
			Client client = session.get(Client.class, row);
			session.delete(client);
			session.getTransaction().commit();
			session.close();
			success = true;
		} catch (Exception e) {}
		return success;
	}
	
	public List<Client> getClients()
	{
		session = sf.getCurrentSession();
		session.beginTransaction();
		List<Client> clients = session.createQuery("from Client").getResultList();
		session.close();
		return clients;
	}
	
}
