package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Software")
public class Software {

	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Quantity")
	private String quantity;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="KeysAvailable")
	private String keysAvailable;
	
	public Software() {} //zero-argument constructor for Hibernate
	
	public Software(String name, String quantity, String description, String keysAvailable)
	{
		this.name = name;
		this.quantity = quantity;
		this.description = description;
		this.keysAvailable = keysAvailable;
	}
	
	//getter
	
	public int getLineNumber() {
		return this.lineNumber;
	}

	public String getName() {
		return this.name;
	}
	
	public String getQuantity() {
		return this.quantity;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getKeysAvailable() {
		return this.keysAvailable;
	}
	
	//setter
	
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setKeysAvailable(String keysAvailable) {
		this.keysAvailable = keysAvailable;
	}
}
