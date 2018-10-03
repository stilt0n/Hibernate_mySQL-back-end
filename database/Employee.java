package database;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="First")
	private String first;
	
	@Column(name="Last")
	private String last;
	
	@Column(name="Position")
	private String position;
	
	@Column(name="Phone")
	private String phone;
	
	@Column(name="Email")
	private String email;
	
	public Employee() {} //Zero-argument constructor for Hibernate
	
	public Employee(String first, String last, String position, String phone, String email)
	{
		this.first = first;
		this.last = last;
		this.position = position;
		this.phone = phone;
		this.email = email;
	}
	
	//getter
	public int getLineNumber()
	{
		return this.lineNumber;
	}
	
	public String getFirst() {
		return this.first;
	}
	
	public String getLast() {
		return this.last;
	}
	
	public String getPosition() {
		return this.position;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	//setter
	
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	public void setLast(String last) {
		this.last = last;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
