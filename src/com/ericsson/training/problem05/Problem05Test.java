package com.ericsson.training.problem05;

import com.ericsson.training.common.ConstantFile;

import junit.framework.TestCase;

public class Problem05Test extends TestCase {
	JavaDataBaseConnection jdbcObject=new JavaDataBaseConnection();
	
	//Test to check Insertion
	public void testInsertRow() {
		int expectedOutput=1;
		int actualOutput=jdbcObject.insertRow(ConstantFile.INSERTION_SQL);
		assertEquals(expectedOutput,actualOutput);
	}
	//Test to Check Updation
	public void testUpdateRow() {
		int expectedOutput=1;
		int actualOutput=jdbcObject.updateRow(ConstantFile.UPDATE_SQL);
		assertEquals(expectedOutput,actualOutput);
	}
	//Test to check Deletion
	public void testDeleteRow() {
		int expectedOutput=1;
		int actualOutput=jdbcObject.deleteRow(ConstantFile.DELETE_SQL);
		assertEquals(expectedOutput,actualOutput);
	}
	//Test for Selection
	public void testSelectData() {
		String expectedOutput=ConstantFile.OUTPUT_STRING;
		String actualOutput=jdbcObject.selectData(ConstantFile.SELECTION_SQL);
		assertEquals(expectedOutput,actualOutput);
	}
}
