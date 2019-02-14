package com.ericsson.training.problem04;

import java.util.Comparator;

import com.ericsson.training.problem04.Company;


public class EmpIDComparator implements Comparator<Company> {
	public int compare(Company company1, Company company2) {
		if (company1.getEmployeeID() == company2.getEmployeeID())
			return 0;
		else if (company1.getEmployeeID() > company2.getEmployeeID())
			return 1;
		else
			return -1;

	}
}
