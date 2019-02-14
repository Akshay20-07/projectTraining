package com.ericsson.training.problem04;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder = { "employeeID", "workHour", "employeeName", "department" })
@XmlRootElement(name = "Company")
public class Company {
	private int employeeID;
	private float workHour;
	private String employeeName;
	private String department;

	Company() {
		this.employeeID = 0;
		this.workHour = 0.0f;
		this.employeeName = null;
		this.department = null;
	}

	Company(int empid, float workhr, String name, String deptt) {
		this.employeeID = empid;
		this.workHour = workhr;
		this.employeeName = name;
		this.department = deptt;
	}

	@XmlAttribute(name = "employeeID")
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int empid) {
		this.employeeID = empid;
	}

	@XmlElement(name = "employeeName")
	public String getName() {
		return employeeName;
	}

	public void setName(String name) {
		this.employeeName = name;
	}

	@XmlElement(name = "workHour")
	public float getWorkHour() {
		return workHour;
	}

	public void setWorkHour(float workhr) {
		this.workHour = workhr;
	}

	@XmlElement(name = "department")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String deptt) {
		this.department = deptt;
	}
	public String toString() {
		return ( employeeID +" "+ employeeName + " "+department+" "+ workHour);
		
	}
}
