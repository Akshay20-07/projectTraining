package com.ericsson.training.problem04;

import java.util.Comparator;



public class WorkHourComparator implements Comparator<Company>{
	public int compare(Company company1,Company company2) {

	if(company1.getWorkHour()==company2.getWorkHour())
		return 0;
	else if(company1.getWorkHour()>company2.getWorkHour())
		return 1;
	else
		return -1;

}
}
