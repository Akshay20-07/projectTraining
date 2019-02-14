package com.ericsson.training.problem01;

import java.util.Properties;

import org.junit.jupiter.api.Test;

import com.ericsson.training.common.ConstantFile;

import junit.framework.TestCase;



public class Problem01Test extends TestCase {
	PropertyFile propertyObject = new PropertyFile();

	/**
	 * To test readProperty(testFileName) using assertEquals
	 *
	 */
	@Test
	public void testReadProperty() {
		Properties expectedInformation = new Properties();
		expectedInformation.setProperty(ConstantFile.MAIL_ID_LOWERCASE,ConstantFile.MAIL);
		String testFileName = ConstantFile.READ_PROPERTY_TEST;
		
		Properties resultedInformation = propertyObject.readProperty(testFileName);
		assertEquals("You are doing it Wrong",expectedInformation, resultedInformation);
	}
	/**
	 * To test the copyProperty(File) using assertTrue and assertFalse
	 */
	@Test
	public void testCopyProperty() {
		Properties expectedInformation = new Properties();
		expectedInformation.setProperty(ConstantFile.MAIL_ID_UPPERCASE,ConstantFile.MAIL);
		String File=ConstantFile.COPY_PROPERTY_TEST;
		Properties resultedInformation = propertyObject.copyProperty(File);
		assertTrue("There is an issue",expectedInformation.equals(resultedInformation));
		assertFalse("Not Working fine",!expectedInformation.equals(resultedInformation));
	}
}
