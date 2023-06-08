import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase2 extends Parameters{
	
	@BeforeTest
	public  void beforeTest() {
		driver.manage().window().maximize();
		driver.get(URLS[1]);
	} 

	@Test
	public void checkTheDefualtCurrency() throws InterruptedException {
		Thread.sleep(5000);
		WebElement sarCurrency = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]"));
		String actualvalue= sarCurrency.getText();
		String expectedvalue= "SAR";
		myAssert.assertEquals(actualvalue,expectedvalue);
			
		} 
	
	@AfterTest
	public void afterTest() {
		myAssert.assertAll();
		driver.quit();

	}
}