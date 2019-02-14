package com.ericsson.training.problem02;

import java.util.ArrayList;
import java.util.List;

import com.ericsson.training.common.ConstantFile;

import junit.framework.TestCase;

public class JaxbTestCase extends TestCase {
	JaxbExample jaxbObject=new JaxbExample();
	
	public void testCopyJAXB() {
		String InputFile =ConstantFile.XML_FILE ;
		String OutputFile=ConstantFile.XML_COPY_FILE;
		String expectedOutput="[1 Mr abc SDU 7.0, 2 Mr xyz SDU 8.0]";
		String actualOutput=jaxbObject.copyJaxb(InputFile, OutputFile);
		assertEquals(expectedOutput,actualOutput);
		
	}
	public void testReadJAXB() {
		List<Company> expectedOutput = new ArrayList<Company>();
		expectedOutput.add(new Company(1, 7.0f, ConstantFile.FIRST_NAME, ConstantFile.DEPARTMENT_NAME01));
		expectedOutput.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME, ConstantFile.DEPARTMENT_NAME01));
		expectedOutput.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		String actualOutput=jaxbObject.readJAXB(ConstantFile.XML_FILE);
		assertEquals(expectedOutput.toString(),actualOutput);
		
	}


}
