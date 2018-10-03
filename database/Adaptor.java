package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Adaptors")
public class Adaptor {
	
	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Quantity")
	private String quantity;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Comment")
	private String comment;
	
	public Adaptor() {} //zero argument constructor for hibernate
	
	public Adaptor(String name, String quantity, String location, String comment)
	{
		this.name = name;
		this.quantity = quantity;
		this.location = location;
		this.comment = comment;
	}
	
	//getters
	public int getLineNumber()
	{
		return lineNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getQuantity()
	{
		return this.quantity;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	public String getComment()
	{
		return this.comment;
	}
	
	//setters
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setQuantity(String quantity)
	{
		this.name = quantity;
	}
	
	public void setLocation(String location)
	{
		this.location = location;
	}
	
	public void setComment(String comment)
	{
		this.comment = comment;
	}
}
