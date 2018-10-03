package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ITClub")
public class ITClub {
	
	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Quantity")
	private String quantity;
	
	@Column(name="Comment")
	private String comment;
	
	public ITClub() {} //zero-argument constructor for Hibernate
	
	public ITClub (String name, String description, String quantity, String comment)
	{
		this.name = name;
		this.description = description;
		this.quantity = quantity;
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
	
	public void setComment(String comment) {
		this.comment = comment;
	}

}
