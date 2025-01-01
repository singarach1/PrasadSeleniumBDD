package stepDefinition;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortname) throws InterruptedException {

		switchToOffersPage();
//		OffersPage offersPage = new OffersPage(testContextSetup.driver);
//		testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
		OffersPage offersPage = testContextSetup.pageObjectManager.OffersPage();

		offersPage.searchItem(shortname);
		Thread.sleep(2000);
//		testContextSetup.offerPageProductname = testContextSetup.driver.findElement(By.xpath("//tr/td[1]")).getText();
		testContextSetup.offerPageProductName = offersPage.getProductName();

	}

	public void switchToOffersPage() {

//		pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();

		landingPage.selectTopDealsPage();
//		testContextSetup.driver.findElement(By.xpath("//a[starts-with(text(),'Top Deals')]")).click();
		testContextSetup.genericUtills.SwitchWindowToChild();

	}

	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page() {
		Assert.assertEquals(testContextSetup.offerPageProductName, testContextSetup.landingPageProductName);
		
//		System.out.println(testContextSetup.offerPageProductname);

//		driver.quit();
	}
}
