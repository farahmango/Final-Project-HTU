import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 extends Parameters {

	
	@BeforeTest
	public  void beforeTest() {
		driver.manage().window().maximize();
		driver.get(URLS[1]);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				 try{
					 driver.switchTo().frame("wiz-iframe-intent");
						driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div/span")).click();
						driver.switchTo().defaultContent();
						driver.findElement(By.xpath("//*[@id=\"moe-dontallow_button\"]")).click();
					    }
					  catch(Exception e){
							driver.findElement(By.xpath("//*[@id=\"moe-dontallow_button\"]")).click();
					  	}				
					driver.get(URLS[1]);

	} 
	
	@Test
	public void  checkTheDefualtLanguage() {
//		String Language = driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
//		myAssret.assertEquals(Language,"العربية");
		String CurrentURL = driver.getCurrentUrl();
		myAssert.assertEquals(CurrentURL, "https://www.almosafer.com/en");
			
		} 

	
	@AfterTest
	public void afterTest() {
		myAssert.assertAll();
		
	}
}
