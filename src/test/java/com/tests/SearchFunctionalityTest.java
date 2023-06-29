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

        // Perform the search
		searchFunctionality.searchResult("OpenAI");
		searchFunctionality.clickOnFirstResult();
		//searchFunctionality.clickOnFirstResult();

        // Verify the search results
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("openai"), "Search results page title does not contain 'OpenAI'");
	}
	
}
