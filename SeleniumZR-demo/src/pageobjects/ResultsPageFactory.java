package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import utilities.WaitTypes;
import utilities.GenericMethods;


public class ResultsPageFactory {
	WebDriver driver;
	GenericMethods gm;
	String locSearchButton ="//input[@id='location1']//parent::div//following-sibling::div/input";
	

	@FindBy(id="search1")
	WebElement searchBox;
	
	@FindBy(id="location1")
	WebElement locationBox;
	
	@FindBy(xpath="//input[@id='location1']//parent::div//following-sibling::div/input")
	WebElement searchButton;
	
	public ResultsPageFactory (WebDriver driver) {
		System.out.println("home page constructor");
		this.driver = driver;
		PageFactory.initElements(driver, this);
		gm = new GenericMethods(driver);
	}
	
	/* 
	 * Search Box
	 */
	public void searchBox_sendKeys (String searchString) {
		System.out.println("home page send search");
		searchBox.sendKeys(searchString);
	}
	
	public void searchBox_clear () {
		System.out.println("home page clear Search");
		searchBox.clear();
	}
	
	/* 
	 * Location Box
	 */
	public void location_sendKeys (String locationString) {
		System.out.println("home page send location");
		locationBox.sendKeys(locationString);
	}
	
	public void location_clear () {
		System.out.println("home page clear location");
		locationBox.clear();
	}
	
	/* 
	 * Search button
	 */
	public void search_click() {
		System.out.println("home page click search button");
		searchButton.click();
	}
	/*
	 * explicit wait for page load
	 */
	public void waitForSearchButton (int timeout) {
		gm.waitForElement(By.xpath(locSearchButton), timeout);
	}
}