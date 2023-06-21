package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.adc.ITests.ISearchFunctionalityTest;
import com.adc.base.TestBase;
import com.pages.SearchFunctionality;

public class SearchFunctionalityTest extends TestBase implements ISearchFunctionalityTest {
	
	SearchFunctionality searchFunctionality;

	@Test
	public void testSearchFeildFunctionality() {
		searchFunctionality = new SearchFunctionality(driver);

		String expectedTitle = "Bing";
		String actualTitle = searchFunctionality.titleOfPage();
		
		System.out.println("Title of the page: " + actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
	}
	
}
