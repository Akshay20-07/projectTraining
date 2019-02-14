package com.ericsson.training.problem04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.ericsson.training.common.ConstantFile;

public class ComparatorExample {
	static Logger logger = Logger.getLogger(ComparatorExample.class.getName());
	public static FileHandler fileHandle;

	public static void main(String[] args) {
		List<Company> companyList = new ArrayList<Company>();
		companyList.add(new Company(1, 8.5f, ConstantFile.FIRST_NAME,ConstantFile.DEPARTMENT_NAME01));
		companyList.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME,ConstantFile.DEPARTMENT_NAME03));
		companyList.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		
		ComparatorExample Object = new ComparatorExample();
		Object.sortByDepartment(companyList);
		Object.sortByEmpID(companyList);
		Object.sortByWorkHour(companyList);
		Object.sortByName(companyList);
		try {
			fileHandle = new FileHandler(ConstantFile.COMPARATOR_LOG_FILE);
			logger.addHandler(fileHandle);
			fileHandle.setLevel(Level.ALL);
			fileHandle.setFormatter(new SimpleFormatter());
			logger.setUseParentHandlers(true);
		} catch (IOException e) {
			logger.info(e.getMessage());
		}
	}

	@SuppressWarnings("resource")
	public void sortOrder() {
		Scanner scan = new Scanner(System.in);
		logger.info("Put in some numbers:");
		// System.out.println("Put in some numbers: ");
		String input = scan.nextLine();

		Scanner token = new Scanner(input);
		List<String> numberArray = new ArrayList<String>();
		while (token.hasNext()) {
			numberArray.add(token.next());

		}
		logger.info("Sorted Order of Input");
		//System.out.println("Sorted Order of Input");

		ListIterator<String> itr = numberArray.listIterator();
		Set<Integer> setInt = new TreeSet<Integer>();
		while (itr.hasNext()) {
			Integer ab = Integer.parseInt(itr.next());
			setInt.add(ab);

		}
		logger.info(setInt.toString());
		System.out.println(setInt);
		logger.info("sortOrder compiled");
	}

	public List<Company> sortByDepartment(List<Company> companyList) {
		logger.info("Sort by Department");
		// System.out.println("Sort by Department");
		Collections.sort(companyList, new DepartmentComparator());
		logger.info(companyList.toString());
		//System.out.println(companyList.toString());
		return companyList;


	}
	public List<Company> sortByEmpID(List<Company> companyList) {
		logger.info("Sort by Employee Id");
		// System.out.println("Sort by Employee Id");
		Collections.sort(companyList, new EmpIDComparator());
		logger.info(companyList.toString());
		//System.out.println(companyList.toString());
		return companyList;
	}
	public  List<Company> sortByWorkHour(List<Company> companyList) {
		logger.info("Sort by WorkHour");
		// System.out.println("Sort by WorkHour");
		Collections.sort(companyList, new WorkHourComparator());
		logger.info(companyList.toString());
		//System.out.println(companyList.toString());
		return companyList;
		
	}
	public List<Company> sortByName(List<Company> companyList) {
		logger.info("Sort by Employee Name");
		// System.out.println("Sort by Employee Name");
		Collections.sort(companyList, new NameComparator());
		logger.info(companyList.toString());
		//System.out.println(companyList.toString());
		return companyList;
	}
}
