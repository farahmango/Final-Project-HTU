import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase5 extends Parameters {

	@BeforeTest
	public  void beforeTest() {
		driver.manage().window().maximize();			
	} 	
	
	@Test(priority = 1)
	public void englishWebsiteTitleTest() {
	        
			driver.get(URLS[1]);
	        String ActualTitle = driver.getTitle();
	        String ExpectedTitle = "Almosafer: Flights, Hotels, Activities & Airlines Ticket Booking";
	        myAssert.assertEquals(ActualTitle, ExpectedTitle);

	}
	@Test(priority = 2)
	public void arabicWebsiteTitleTest() {
		
		driver.get(URLS[0]);
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "المسافر: رحلات، فنادق، أنشطة ممتعة و تذاكر طيران";
        myAssert.assertEquals(ActualTitle, ExpectedTitle);
	}
	@AfterTest
	public void afterTest() {
		myAssert.assertAll();
		driver.quit();	
	}	
}
