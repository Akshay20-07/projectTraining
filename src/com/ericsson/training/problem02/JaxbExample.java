package com.ericsson.training.problem02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ericsson.training.common.ConstantFile;

public class JaxbExample {
	static Logger logger = Logger.getLogger(JaxbExample.class.getName());
	public static FileHandler fileHandle;

	public static void main(String[] args) {

		JaxbExample jaxbObject = new JaxbExample();
		List<Company> list = new ArrayList<Company>();
		list.add(new Company(1, 7.0f, ConstantFile.FIRST_NAME, ConstantFile.DEPARTMENT_NAME01));
		list.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME, ConstantFile.DEPARTMENT_NAME01));
		list.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		Employee employee = new Employee(list);
		try {
			fileHandle = new FileHandler(ConstantFile.JAXB_LOG_FILE);
			logger.addHandler(fileHandle);
			fileHandle.setFormatter(new SimpleFormatter());
			logger.setUseParentHandlers(true);
			jaxbObject.createJAXB(employee, ConstantFile.CREATE_XML_FILE);
			jaxbObject.copyJaxb(ConstantFile.XML_FILE, ConstantFile.XML_COPY_FILE);
			jaxbObject.readJAXB(ConstantFile.XML_FILE);
		} catch (Exception e) {
			logger.warning(e.getMessage());
		}
	}

	public void createJAXB(Employee employee, String fileName) {
		try {
			JAXBContext contextObj = JAXBContext.newInstance(Employee.class);
			Marshaller marshallerObj = contextObj.createMarshaller();
			marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshallerObj.marshal(employee, new FileOutputStream(fileName));
			logger.info(fileName + " got marshalled");
		} catch (JAXBException | IllegalArgumentException | FileNotFoundException e) {
			logger.warning(e.getMessage());
		}
	}

	public String  readJAXB(String fileName) {
		File fileInput = new File(fileName);
		List<Company> companyList=null;
		try {
			JAXBContext contextObj = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshObj = contextObj.createUnmarshaller();
			Employee employee = (Employee) unmarshObj.unmarshal(fileInput);
			companyList = employee.getCompany();
			logger.info("Details of employee");
			// System.out.println("Details of employee");
			for (Company object : companyList) {
				logger.info(object.getEmployeeID() + ConstantFile.CARRIAGE_RETURN + object.getWorkHour()
						+ ConstantFile.CARRIAGE_RETURN + object.getName() + ConstantFile.CARRIAGE_RETURN
						+ object.getDepartment());
				/*System.out.println(object.getEmployeeID() + ConstantFile.CARRIAGE_RETURN + object.getWorkHour()
						+ ConstantFile.CARRIAGE_RETURN + object.getName() + ConstantFile.CARRIAGE_RETURN
						+ object.getDepartment());*/
			}
		} catch (JAXBException | IllegalArgumentException e) {
			logger.warning(e.getMessage());
		}
		return companyList.toString();

	}

	public String copyJaxb(String inputFile, String copiedFile) {
		File fin = new File(inputFile);
		List<Company> dupCompany = new ArrayList<Company>();
		try {
			JAXBContext contextObj = JAXBContext.newInstance(Employee.class);
			Unmarshaller unmarshObj = contextObj.createUnmarshaller();
			Employee employee = (Employee) unmarshObj.unmarshal(fin);
			List<Company> company = employee.getCompany();
			dupCompany = new ArrayList<Company>();
			Company dupObject = null;
			for (Company obj : company) {
				if (obj.getDepartment().equalsIgnoreCase(ConstantFile.DEPARTMENT_NAME01)) {
					dupObject = obj;
					dupCompany.add(dupObject);
				}

			}
			Employee dupEmployee = new Employee(dupCompany);
			String fileName = copiedFile;
			createJAXB(dupEmployee, fileName);
		} catch (JAXBException | IllegalArgumentException e) {
			logger.warning(e.getMessage());
		}
		return dupCompany.toString();
	}
}
