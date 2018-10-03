package database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Computers")
public class Computer {

	@Id
	@Column(name="LineNumber")
	private int lineNumber;
	
	@Column(name="Make")
	private String make;
	
	@Column(name="Model")
	private String model;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="CPU")
	private String cpu;
	
	@Column(name="RAM")
	private String ram;
	
	@Column(name="Location")
	private String location;
	
	@Column(name="Functional")
	private String functional;
	
	@Column(name="ServiceTag")
	private String serviceTag;
	
	@Column(name="MAC")
	private String mac;
	
	@Column(name="Comment")
	private String comment;
	
	@Column(name="HDD")
	private String hdd;
	
	public Computer() {} //zero-argument constructor for Hibernate
	
	public Computer (String make, String model, String description, String cpu,
			String ram, String location, String functional, String serviceTag,
			String mac, String comment, String hdd) {
		this.make = make;
		this.model = model;
		this.description = description;
		this.cpu = cpu;
		this.ram = ram;
		this.location = location;
		this.functional = functional;
		this.serviceTag = serviceTag;
		this.mac = mac;
		this.comment = comment;
		this.hdd = hdd;
		}
	
	public int getLineNumber()
	{
		return this.lineNumber;
	}
	public String getMake()
	{
		return this.make;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String getCpu()
	{
		return this.cpu;
	}
	
	public String getRam()
	{
		return this.ram;
	}
	
	public String getLocation()
	{
		return this.location;
	}
	
	public String getFunctional()
	{
		return this.functional;
	}
	
	public String getServiceTag()
	{
		return this.serviceTag;
	}
	
	public String getMac()
	{
		return this.mac;
	}
	
	public String getComment()
	{
		return this.comment;
	}
	
	public String getHdd()
	{
		return this.hdd;
	}
	
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public void setFunctional(String functional) {
		this.functional = functional;
	}
	
	public void setServiceTag(String serviceTag) {
		this.serviceTag = serviceTag;
	}
	
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
}
