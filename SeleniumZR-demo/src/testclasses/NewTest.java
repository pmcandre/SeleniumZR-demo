package testclasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import java.util.Set;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import utilities.WaitTypes;
//import utilities.GenericMethods;
import pageobjects.HomePageFactory;
import pageobjects.SuggestedJobsPageFactory;
import pageobjects.ResultsPageFactory;

public class NewTest {
	private WebDriver driver;
	private String baseURL;
//	GenericMethods gm;
	String parentHandle;
	HomePageFactory homePage;
	SuggestedJobsPageFactory suggestedJobs;
	ResultsPageFactory resultsPage;
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
//		driver = new FirefoxDriver();
		driver = new ChromeDriver();
//		driver =  new InternetExplorerDriver();
//		driver =  new EdgeDriver();
		baseURL = "https://www.ziprecruiter.com";
		
		homePage = new HomePageFactory(driver);
		suggestedJobs = new SuggestedJobsPageFactory(driver);
		resultsPage = new ResultsPageFactory(driver);
		
		driver.manage().window().maximize();
		System.out.println("Maximize browser");
//		gm = new GenericMethods(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Set timeout");
	}
	
	@BeforeMethod
	public void methodSetup() {
		System.out.println("Before Method code");
		driver.get(baseURL);
		parentHandle = driver.getWindowHandle();
	}

	@Test
	public void Test1() {
		String pageTitle = driver.getTitle();
		System.out.println("The page title is: " + pageTitle);
		if (pageTitle.contains("Suggest")) {
			suggestedJobs.searchBox_clear();
			suggestedJobs.location_clear();
			suggestedJobs.searchBox_sendKeys("software Quality Engineer");
			suggestedJobs.location_sendKeys("Bolingbrook, IL");
			suggestedJobs.search_click();
		} else {
			homePage.searchBox_clear();
			homePage.location_clear();
			homePage.searchBox_sendKeys("software Quality Engineer");
			homePage.location_sendKeys("Bolingbrook, IL");
			homePage.search_click();
		}
		
		resultsPage.waitForSearchButton(15);
		System.out.println("Results Page Loaded");
		
	}
	
	
//	@AfterMethod
//	public void methodCleanUp() throws InterruptedException  {
//		System.out.println("After Method");
//		Thread.sleep(3000);
//		Set<String> handles = driver.getWindowHandles();
//		for (String handle: handles) {
//			System.out.println("Handle is: " + handle);
//			if (!handle.equals(parentHandle)) {
//				driver.switchTo().window(handle);
//				driver.close();
//			}
//		}
//		driver.switchTo().window(parentHandle);
//	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		System.out.println("After Class");
		Thread.sleep(3000);
		driver.quit();
	}
}

