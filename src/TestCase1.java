import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 extends Parameters {

	@BeforeTest
	public  void beforeTest() {
		driver.manage().window().maximize();
		driver.get("https://www.almosafer.com/");
	} 

	@Test
	public void  checkTheDefualtLanguage() {
		String actualURL = driver.getCurrentUrl();
		System.out.println(actualURL);
		String expectedURL ="https://www.almosafer.com/en";
		myAssert.assertEquals(actualURL,expectedURL );
			
		} 

	@AfterTest
	public void afterTest() {
		myAssert.assertAll();
		driver.quit();
		
	}
}
