package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Clients")
public class Client {
	
	@Id
	@Column (name="LineNumber")
	private int lineNumber;
	
	@Column (name="name")
	private String name;
	
	@Column (name="date")
	private String date;
	
	@Column (name="Computer")
	private String computer;
	
	@Column (name="Diagnosis")
	private String diagnosis;
	
	@Column (name="Procedure")
	private String procedure;
	
	@Column (name="Functional")
	private String functional;
	
	@Column (name="Comment")
	private String comment;
	
	@Column (name="Password")
	private String password;
	
	@Column (name="PhoneNumber")
	private String phoneNumber;
	
	@Column (name="LeadTech")
	private String leadTech;
	
	@Column (name="Notes")
	private String notes;
	
	public Client() {} //zero-argument constructor for Hibernate
	
	public Client (String name, String date, String computer, String diagnosis, 
			String procedure, String functional, String comment, String password, 
			String phoneNumber, String leadTech, String notes)
	{
		this.name = name;
		this.date = date;
		this.computer = computer;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.functional = functional;
		this.comment = comment;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.leadTech = leadTech;
		this.notes = notes;
	}
	
	public int getLineNumber() {
		return this.lineNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDate() {
		return this.date;
	}
	
	public String getComputer() {
		return this.computer;
	}
	
	public String getDiagnosis() {
		return this.diagnosis;
	}
	
	public String getProcedure() {
		return this.procedure;
	}
	
	public String getFunctional() {
		return this.functional;
	}
	
	public String getComment() {
		return this.comment;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getLeadTech() {
		return this.leadTech;
	}
	
	public String getNotes() {
		return this.notes;
	}
	
	//setters
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public void setComputer(String computer) {
		this.computer = computer;
	}
	
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	
	public void setFunctional(String functional) {
		this.functional = functional;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void setLeadTech(String leadTech) {
		this.leadTech = leadTech;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Client [lineNumber=" + lineNumber + ", name=" + name + ", date=" + date + ", computer=" + computer
				+ ", diagnosis=" + diagnosis + ", procedure=" + procedure + ", functional=" + functional + ", comment="
				+ comment + ", password=" + password + ", phoneNumber=" + phoneNumber + ", leadTech=" + leadTech
				+ ", notes=" + notes + "]";
	}
	
	
}
