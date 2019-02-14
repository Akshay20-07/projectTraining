package com.ericsson.training.problem03;

import java.io.File;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.ericsson.training.common.*;
import com.ericsson.training.problem02.Company;
import com.ericsson.training.problem02.Employee;

public class CollectionObject {
	static Logger logger = Logger.getLogger(CollectionObject.class.getName());

	public static void main(String[] args) throws Exception {
		FileHandler fileHandle = new FileHandler(ConstantFile.COLLECTION_LOG_FILE);
		logger.addHandler(fileHandle);
		fileHandle.setFormatter(new SimpleFormatter());
		logger.setUseParentHandlers(true);
		CollectionObject collection = new CollectionObject();
		collection.collectionList(ConstantFile.XML_FILE);

	}

	public String collectionList(String fileName) {
		File fileInput = new File(fileName);
		List<Company> companyList =null;
		JAXBContext contextObj;
		try {
			contextObj = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshObj = contextObj.createUnmarshaller();
			Employee employee = (Employee) unmarshObj.unmarshal(fileInput);
			companyList = employee.getCompany();
			for (Company obj : companyList) {
				logger.info(obj.getEmployeeID() + " " + obj.getDepartment() + " " + obj.getName() + " "
						+ obj.getWorkHour());
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		System.out.println(companyList);
		return companyList.toString();
	}
}
