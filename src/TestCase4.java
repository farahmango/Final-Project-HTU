import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase4 extends Parameters {

	
	@BeforeTest
	public void beforeTest(){
		driver.manage().window().maximize();
	}
	
	@Test()
	public void randomWebSiteLanguage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		int random = myRandom.nextInt(URLS.length);
		driver.get(URLS[random]);
		String url = driver.getCurrentUrl();
		
		if(url.equals(URLS[1])) {
			System.out.println("english website => from riyadh to dubai");
			
					WebElement oneWay = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[1]/div[1]/div[1]"));
					oneWay.click();
					
					WebElement countryFrom = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
					Thread.sleep(2000);
					countryFrom.sendKeys(citiesInEnglish[0]+Keys.ENTER);
					Thread.sleep(5000);
					
					WebElement countryTo = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input"));
					Thread.sleep(2000);
					countryTo.sendKeys(citiesInEnglish[1]+Keys.ENTER);

					Thread.sleep(3000);
					WebElement searchButton = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/button"));
					searchButton.click();
					
					String actualCountryFrom = "Riyadh";
					String actualCountryTo = "Dubai";
					Thread.sleep(5000);
					String expectedCountryFrom = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div/div[2]")).getText();
					String expectedCountryTo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]")).getText();
					myAssert.assertEquals(actualCountryFrom, expectedCountryFrom);
					myAssert.assertEquals(actualCountryTo, expectedCountryTo);
					
		}else if(url.equals(URLS[0])) {
			System.out.println("arabic website => from amman to jeddah");
			WebElement oneWay = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[1]/div[1]/div[1]"));
			oneWay.click();
			
			WebElement countryFrom = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
			Thread.sleep(3000);
			countryFrom.sendKeys(citiesInArabic[0]+Keys.ENTER );
			Thread.sleep(5000);

			WebElement countryTo = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input"));
			Thread.sleep(3000);
			countryTo.sendKeys(citiesInArabic[1]+Keys.ENTER);
			
			Thread.sleep(3000);
			WebElement searchButton = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[2]/div/div[2]/div/button"));
			searchButton.click();	
			
			String actualCountryFrom = "عمان";
			String actualCountryTo = "جدة";
			Thread.sleep(5000);
			String expectedCountryFrom = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div/div[2]")).getText();
			String expectedCountryTo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]")).getText();
			myAssert.assertEquals(actualCountryFrom, expectedCountryFrom);
			myAssert.assertEquals(actualCountryTo, expectedCountryTo);
		}else{
			myAssert.assertEquals(
					url.equals(URLS[0]) || url.equals(URLS[1]),
					true, "this is to test the website url ");

		}		
	}

	@AfterTest
	public void afterTest(){
		myAssert.assertAll();
		driver.quit();

	}
	
	
	
}
