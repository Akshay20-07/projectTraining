package com.ericsson.training.problem02;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

		
		@XmlRootElement
		public class Employee{
			private List<Company> company;
			
			Employee()
			{
				this.company=null;
			}
			public Employee(List<Company> company)
			{   
				this.company=company;
			}

			@XmlElement(name="Company")
			public List<Company> getCompany() {
				return company;
			}

			public void setCompany(List<Company> company) {
				this.company = company;
			}
			

	}


