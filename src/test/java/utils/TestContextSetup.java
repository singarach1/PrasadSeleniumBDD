package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtills genericUtills;
	
	
	public TestContextSetup() throws IOException {
		testBase = new TestBase(); 
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtills = new GenericUtills(testBase.WebDriverManager());
	}

}
