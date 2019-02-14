package com.ericsson.training.problem04;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import com.ericsson.training.common.ConstantFile;

public class Problem04Test extends TestCase {
	ComparatorExample comparatorObject=new ComparatorExample();

	//Test to check sortByDepartment
	@Test
	public void testsortByDepartment() {	
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(new Company(1, 8.5f, ConstantFile.FIRST_NAME,ConstantFile.DEPARTMENT_NAME01));
		companyList.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME,ConstantFile.DEPARTMENT_NAME03));
		companyList.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		
		String expectedOutput=ConstantFile.SORT_BY_DEPARTMENT;
		 List<Company> actualOutput=comparatorObject.sortByDepartment(companyList); 
		
		assertEquals(expectedOutput,actualOutput.toString());
	}
	//Test to check sortByEmployeeId
	public void testsortByEmpID(){	
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(new Company(1, 8.5f, ConstantFile.FIRST_NAME,ConstantFile.DEPARTMENT_NAME01));
		companyList.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME,ConstantFile.DEPARTMENT_NAME03));
		companyList.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		
		String expectedOutput=ConstantFile.SORT_BY_EMPLOYEEID;
		 List<Company> actualOutput=comparatorObject.sortByEmpID(companyList); 
		
		assertEquals(expectedOutput,actualOutput.toString());
	}
	//Test to check sortByWorkhour
	public void testsortByWorkHour() {	
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(new Company(1, 8.5f, ConstantFile.FIRST_NAME,ConstantFile.DEPARTMENT_NAME01));
		companyList.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME,ConstantFile.DEPARTMENT_NAME03));
		companyList.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		
		String expectedOutput=ConstantFile.SORT_BY_WORKHOUR;
		 List<Company> actualOutput=comparatorObject.sortByWorkHour(companyList); 
		
		assertEquals(expectedOutput,actualOutput.toString());
	}
	//Test to check sortByName
	public void testsortByName(){	
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(new Company(1, 8.5f, ConstantFile.FIRST_NAME,ConstantFile.DEPARTMENT_NAME01));
		companyList.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME,ConstantFile.DEPARTMENT_NAME03));
		companyList.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		
		String expectedOutput=ConstantFile.SORT_BY_EMPLOYEE_NAME;
		 List<Company> actualOutput=comparatorObject.sortByName(companyList); 
		
		assertEquals(expectedOutput,actualOutput.toString());
	}
}
