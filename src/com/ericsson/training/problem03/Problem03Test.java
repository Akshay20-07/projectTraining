package com.ericsson.training.problem03;




import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ericsson.training.common.ConstantFile;
import com.ericsson.training.problem02.Company;

import junit.framework.TestCase;

public class Problem03Test extends TestCase {
	CollectionObject collection=new CollectionObject();
	
	//to Test CollectionList
	@Test
	public void testCollectionList() {
		List<Company> expectedList = new ArrayList<Company>();
		expectedList.add(new Company(1, 7.0f, ConstantFile.FIRST_NAME, ConstantFile.DEPARTMENT_NAME01));
		expectedList.add(new Company(2, 8.0f, ConstantFile.SECOND_NAME, ConstantFile.DEPARTMENT_NAME01));
		expectedList.add(new Company(3, 9.0f, ConstantFile.THIRD_NAME, ConstantFile.DEPARTMENT_NAME02));
		

		String actualList=collection.collectionList(ConstantFile.XML_FILE);
		
		assertEquals(expectedList.toString(),actualList) ;		
	}

}
