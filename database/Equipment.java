package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Equipment")
public class Equipment {

	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Quantity")
	private String quantity;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Comment")
	private String comment;
	
	public Equipment() {} //zero-argument constructor for Hibernate
	
	public Equipment (String name, String description, String quantity, String location, String comment)
	{
		this.name = name;
		this. description = description;
		this.quantity = quantity;
		this.location = location;
		this.comment = comment;
	}
	
	//getter
	public int getLineNumber() {
		return this.lineNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getQuantity() {
		return this.quantity;
	}
	
	public String getLocation() {
		return this.location;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	//setter
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
}
