package com.ericsson.training.problem04;

import java.util.Comparator;


public class DepartmentComparator implements Comparator<Company> {
	
	public int compare(Company object1,Company object2) {
		
		return object1.getDepartment().compareTo(object2.getDepartment());
	}

}
