package database;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="students")
public class Student {

	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="StudentId")
	private String studentId;
	
	public Student() {} //zero-argument constructor for Hibernate
	
	public Student (String first, String last, String id)
	{
		this.firstName = first;
		this.lastName = last;
		this.studentId = id;
	}
	
	public String getFirst()
	{
		return this.firstName;
	}
	
	public String getLast()
	{
		return this.lastName;
	}
	
	public String getId()
	{
		return this.studentId;
	}
	
	public int getLineNumber()
	{
		return this.lineNumber;
	}
	public void setFirst(String first)
	{
		this.firstName = first;
	}
	
	public void setLast(String last)
	{
		this.lastName = last;
	}
	
	public void setId(String id)
	{
		this.studentId = id;
	}
	
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}

	@Override //for testing
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", studentId=" + studentId + "]";
	}
	
	
}
