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

import dev.failsafe.internal.util.Assert;

public class TestCase3 extends Parameters {

	
	@BeforeTest
	public void beforeTest(){
		driver.manage().window().maximize();	
		driver.get(URLS[1]);	
	}
	
	@Test()
	public void selectCountriesRandomly() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement countryFrom = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
		int random = myRandom.nextInt(citiesInEnglish.length);		
		countryFrom.sendKeys(citiesInEnglish[random]+Keys.ENTER  );
		Thread.sleep(3000);
		
		WebElement countryTo = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input"));
		countryTo.sendKeys("Amman" +Keys.ENTER );
		Thread.sleep(3000);
		//get the actual country for assertion
		String actualCountry = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input")).getAttribute("value");
		int commaIndex = actualCountry.indexOf(",");
	    String actualCountryFrom = actualCountry.substring(0, commaIndex);

	    //enter the date 
		WebElement dateFrom = driver.findElement(By.className("ghIalB"));
		dateFrom.click();
		Thread.sleep(3000);
				
		//Date 
		LocalDate currentDate = LocalDate.now();
		// Add two day to the current date
		LocalDate updatedDateFrom = currentDate.plusDays(2);	
		// Add six day to the current date
		LocalDate updatedDateTo = currentDate.plusDays(6);		

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
		// Format the LocalDate object as a string with the specified format
		String formattedDateFrom = updatedDateFrom.format(formatter);
		String formattedDateTo = updatedDateTo.format(formatter);
			
		List<WebElement> dateDiv = driver.findElements(By.className("DayPicker-Day"));
		//selected date
		for(int i =0 ;i < dateDiv.size();i++) {
			String disabledDate = dateDiv.get(i).getAttribute("aria-disabled");
			String dateValue = dateDiv.get(i).getAttribute("aria-label");
			System.out.println(dateDiv.get(i).getAttribute("aria-disabled"));
			System.out.println(dateDiv.get(i).getAttribute("aria-label"));

			if(disabledDate.contains("false") && dateValue.contains(formattedDateFrom)) {
					System.out.println(disabledDate);
					System.out.println(dateValue);
					Thread.sleep(5000);
					//to solve Stale Element Reference Exception
					 try{
						dateDiv.get(i).click();
					    }
					  catch(Exception e){
						  	System.out.println(e.getMessage());				
					  	}		 
				}
					
			if(disabledDate.contains("false") && dateValue.contains(formattedDateTo)) {
				System.out.println(disabledDate);
				System.out.println(dateValue);
				Thread.sleep(5000);
				//to solve Stale Element Reference Exception
				 try{
					dateDiv.get(i).click();
				     break;
				    }
				  catch(Exception e){
					  	System.out.println(e.getMessage());				
				  	}				
			} 
		}
		
	Thread.sleep(3000);
	WebElement searchButton = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/section[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]"));
	searchButton.click();
	Thread.sleep(3000);
//	make soft assertion 
	String expectedCountryFrom = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div/div/div[2]")).getText();
	myAssert.assertEquals(actualCountryFrom, expectedCountryFrom);

	Thread.sleep(3000);
	String actualCountryToo = "Amman";
	String expectedCountryToo = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]")).getText();
	myAssert.assertEquals(actualCountryToo, expectedCountryToo);
	}
	
	@AfterTest
	public void afterTest(){
		myAssert.assertAll();
		driver.quit();		
	}	
}
