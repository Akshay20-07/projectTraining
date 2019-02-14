package com.ericsson.training.problem04;

import java.util.Comparator;



public class NameComparator implements Comparator<Company>{
	public int compare(Company company1,Company company2) {

		return company1.getName().compareTo(company2.getName());
	}

}
