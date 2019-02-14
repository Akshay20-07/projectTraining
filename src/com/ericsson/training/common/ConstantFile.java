package com.ericsson.training.common;

import java.sql.Date;

public class ConstantFile {
	private ConstantFile() {
		
	}
	// for ReadProperty
	public static final String INPUT_PROPERTY = "info.properties";
	public static final String OUTPUT_PROPERTY = "copy.properties";
	public static final String PROPERTY_LOG_FILE = "PropertiesLogFile.log";
	
	// for JaxbExample
	public static final String CREATE_XML_FILE = "jaxb.xml";
	public static final String XML_FILE = "jaxb.xml";
	public static final String XML_COPY_FILE = "jaxbcopy.xml";
	public static final String FIRST_NAME="Mr abc";
	public static final String SECOND_NAME="Mr xyz";
	public static final String THIRD_NAME="Mr red";
	public static final String DEPARTMENT_NAME01="SDU";
	public static final String DEPARTMENT_NAME02="ECE";
	public static final String DEPARTMENT_NAME03="VEON";
	public static final String JAXB_LOG_FILE = "JaxbLogFile.log";
	public static final String CARRIAGE_RETURN = "\r";
	
	// for DOMExample
	public static final String INPUT_FILEPATH = "q2.xml";
	public static final String OUTPUT_FILEPATH = "wrote.xml";
	public static final String ROOT_ELEMENT="Root Element:";
	public static final String AND= " And "; 
	public static final String CHECK_FILE = "q2.xml";
	public static final String MERGE_FILE = "wrote.xml";
	public static final String RESULT_FILE = "merge.xml";
	public static final String XML_LOG_FILE = "XmlBuildLog.log";
	public static final String PRICE_VALUE="37.00";
	public static final String LIBRARY="library";
	public static final String BOOK="book";
	public static final String CATEGORY="Category";
	public static final String NEWS="News";
	public static final String VOLUME="Vol";
	public static final String VOLUME_NO="2";
	public static final String TITLE="title";
	public static final String TODAY="all about today";
	public static final String AUTHOR="author";
	public static final String ROWLING="jk rowling";
	public static final String YEAR="year";
	public static final String YEAR_2K18="2018";
	public static final String PRICE="price";
	public static final String VALUE_45="45";
	
	
	// for ComparatorExample
	public static final String COMPARATOR_LOG_FILE = "ComparatorLog.log";
	
	// for Java DataBase Connection
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/";
	public static final String DATABASE = "organisation";
	public static final String USER_NAME = "root";
	public static final String PASSWORD = "root";
	public static final String JDBC_LOG_FILE = "JDBCLog.log";
	public static final String INSERTION_SQL = "INSERT into employee (grade,jobstage,sex,age,department,manager,address,doj) values(?,?,?,?,?,?,?,?)";
	public static final String SELECTION_SQL = "Select * from employee";
	public static final String UPDATE_SQL = "Update employee set jobstage=?,department=? where empid=?";
	public static final String DELETE_SQL = "Delete from employee where age=?";
	//for insertion in JDBC 
	public static final String GRADE="regular";
	public static final String JOBSTAGE="trained";
	public static final String SEX="M";
	public static final String DEPARTMENT= "charging";
	public static final String MANAGER= "manager";
	public static final String ADDRESS= "SPINFO";
	public static final Date Date_OF_JOINING=Date.valueOf("2017-12-04");
	//for updation
	public static final String SD="SD";
	public static final String ADAPTATION="adaptation";
	
	// for Collection
	public static final String COLLECTION_LOG_FILE = "CollectionLog.log";
	//for Problem01 Testcase
	public static final String READ_PROPERTY_TEST ="C:\\Users\\ezaksch\\eclipse-workspace\\GET_Training\\info1.properties";
	public static final String COPY_PROPERTY_TEST="C:\\Users\\ezaksch\\eclipse-workspace\\GET_Training\\copy1.properties";
	public static final String MAIL_ID_LOWERCASE="mailid";
	public static final String MAIL="akshay@gmail.com";
	public static final String MAIL_ID_UPPERCASE="MAILID";
	//for Problem04 TestCase
	public static final String SORT_BY_DEPARTMENT="[3 Mr red ECE 9.0, 1 Mr abc SDU 8.5, 2 Mr xyz VEON 8.0]";
	public static final String SORT_BY_EMPLOYEEID="[1 Mr abc SDU 8.5, 2 Mr xyz VEON 8.0, 3 Mr red ECE 9.0]";
	public static final String SORT_BY_EMPLOYEE_NAME="[1 Mr abc SDU 8.5, 3 Mr red ECE 9.0, 2 Mr xyz VEON 8.0]";
	public static final String SORT_BY_WORKHOUR="[2 Mr xyz VEON 8.0, 1 Mr abc SDU 8.5, 3 Mr red ECE 9.0]";
	//for Problem05 Testcase
	public static final String OUTPUT_STRING="employee #2 GET SD M 21 adaptation  manager SPINFO 2017-10-04 ";
	
}
