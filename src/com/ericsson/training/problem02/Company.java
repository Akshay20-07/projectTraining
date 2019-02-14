package com.ericsson.training.problem02;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlType(propOrder = {"employeeID","department","workHour","name"})
@XmlRootElement(name = "Company")
public class Company {
	private int employeeID;
	private float workHour;
	private String name;
	private String department;

	Company() {
		this.employeeID=0;
		this.workHour=0.0f;
		this.name = null;
		this.department=null;
	}

	public Company(int employeeID, float workHour, String name, String department) {
		this.employeeID=employeeID;
		this.workHour=workHour;
		this.name = name;
		this.department=department;
	}

	@XmlAttribute(name = "empId")
	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	@XmlElement(name = "empName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    @XmlElement(name = "empDeptt")
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	@XmlElement(name = "workHrs")
	public float getWorkHour() {
		return workHour;
	}

	public void setWorkHour(float workHour) {
		this.workHour = workHour;
	}
	public String toString() {
		return ( employeeID +" "+ name + " "+department+" "+ workHour);
		
	}


	
}
