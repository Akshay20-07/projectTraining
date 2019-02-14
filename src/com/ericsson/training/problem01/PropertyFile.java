package com.ericsson.training.problem01;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.logging.*;
//import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import com.ericsson.training.common.*;

/**
 * This class is used for reading a propertyFile and Copying a propertyFile
 * 
 * @author ezaksch
 * @see Properties,FileWriter,FileReader
 */
public class PropertyFile {

	private static final Logger logger = Logger.getLogger(PropertyFile.class.getName());
	private static FileHandler fileHandle;
	/**
	 * To call methods such as readProperty
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		PropertyFile readObj = new PropertyFile();

		try {
			fileHandle = new FileHandler(ConstantFile.PROPERTY_LOG_FILE);
			logger.setLevel(Level.FINE);
			logger.addHandler(fileHandle);
			SimpleFormatter formatter = new SimpleFormatter();
			fileHandle.setFormatter(formatter);
			logger.setUseParentHandlers(true);
			System.out.println(ConstantFile.INPUT_PROPERTY);
			readObj.readProperty(ConstantFile.INPUT_PROPERTY);
			readObj.copyProperty(ConstantFile.INPUT_PROPERTY);
		} catch (Exception e) {

			logger.warning(e.getMessage());
		}

	}

	public Properties readProperty(String fileName ) {
		Properties personInfo = new Properties();
		try {
			FileReader fileReadObj = new FileReader(fileName);
			personInfo.load(fileReadObj);
			Set<Object> xmlKeys = personInfo.keySet();
			logger.fine(xmlKeys.toString());
			// System.out.println(keys);
			for (Object k : xmlKeys) {
				String key = (String) k;
				logger.fine(key + ": " + personInfo.getProperty(key));
				 System.out.println(key + ": " + personInfo.getProperty(key));
			}
		} catch (IllegalArgumentException | IOException e) {
			logger.warning(e.getMessage());
		}
		logger.info("readProperty  compiled");
		return personInfo;
		
	}

	public Properties copyProperty(String fileName) {
		Properties personInformation = readProperty(fileName);
		Properties personCopiedInformation = new Properties();
		try {

			FileWriter fileWrite = new FileWriter(ConstantFile.OUTPUT_PROPERTY);
			
			Set<Object> keys = personInformation.keySet();
			logger.fine(keys.toString());
			// System.out.println(keys);
			for (Object k : keys) {
				String key = (String) k;
				logger.fine(key + ": " + personInformation.getProperty(key).toUpperCase());
				// System.out.println(key + ": " + personInfo.getProperty(key).toUpperCase());
				personCopiedInformation.setProperty(key.toUpperCase(), personInformation.getProperty(key));

			}
			logger.info("Information copied Successfully");
			personCopiedInformation.store(fileWrite, "employee data copied");
		} catch (IOException | IllegalArgumentException e) {
			logger.warning(e.getMessage());
		}
		logger.info("CopyProperty compiled");
		return personCopiedInformation;
	}
	

}
