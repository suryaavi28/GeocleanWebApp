package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchFunctionality {
    private WebDriver driver;

    @FindBy(xpath = "//textarea[@id='sb_form_q']")
    private WebElement search;

    public SearchFunctionality(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null");
        }
        this.driver = driver;
    }

    public String titleOfPage() {
        if (driver == null) {
            throw new IllegalStateException("Driver is null");
        }
        String title = driver.getTitle();
        return title;
    }
    
    public void searchOption(String ad) {
    search.sendKeys(ad);
    }
}
