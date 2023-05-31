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

public class TestCase3 extends Parameters {

	
	@BeforeTest
	public void beforeTest(){
		driver.manage().window().maximize();
		driver.get(URLS[1]);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				 try{
					 driver.switchTo().frame("wiz-iframe-intent");
						driver.findElement(By.xpath("//*[@id=\"contentDiv\"]/div/div/span")).click();
						driver.switchTo().defaultContent();
//						driver.findElement(By.xpath("//*[@id=\"moe-dontallow_button\"]")).click();
					    }
					  catch(Exception e){
//							driver.findElement(By.xpath("//*[@id=\"moe-dontallow_button\"]")).click();
					  	}				

	
	}
	
	@Test()
	public void selectCountriesRandomly() throws InterruptedException{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URLS[1]);
		WebElement countryFrom = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
		int random = myRandom.nextInt(citiesInEnglish.length);		
		
		countryFrom.sendKeys(citiesInEnglish[random]+ Keys.ARROW_DOWN+ Keys.ENTER  );
		Thread.sleep(3000);
		
		WebElement countryTo = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input"));
		countryTo.sendKeys("Amman" + Keys.ARROW_DOWN+ Keys.ENTER );
		Thread.sleep(5000);

		WebElement dateFrom = driver.findElement(By.className("ghIalB"));
		dateFrom.click();
		Thread.sleep(3000);
				
//		Date 
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

		for(int i =0 ;i < dateDiv.size();i++) {
			String disabledDate = dateDiv.get(i).getAttribute("aria-disabled");
			String dateValue = dateDiv.get(i).getAttribute("aria-label");
			System.out.println(dateDiv.get(i).getAttribute("aria-disabled"));
			System.out.println(dateDiv.get(i).getAttribute("aria-label"));

			if(disabledDate.contains("false") && dateValue.contains(formattedDateFrom)) {
					System.out.println(disabledDate);
					System.out.println(dateValue);
					Thread.sleep(5000);
//					to solve Stale Element Reference Exception
					 try{
						dateDiv.get(i).click();
					    }
					  catch(Exception e){
						  	System.out.println("messsage");				
					  	}		 
				}
					
			if(disabledDate.contains("false") && dateValue.contains(formattedDateTo)) {
				System.out.println(disabledDate);
				System.out.println(dateValue);
				Thread.sleep(5000);
//				to solve Stale Element Reference Exception
				 try{
					dateDiv.get(i).click();
				     break;
				    }
				  catch(Exception e){
					  	System.out.println("messsage");				
				  	}				
			} 
		}
		
	Thread.sleep(3000);

	WebElement searchButton = driver.findElement(By.cssSelector("section.sc-kvkilB.guCDGw:nth-child(3) div.sc-kAKrxA.iyOiEz:nth-child(4) div.sc-jKJlTe.cjrpqw.container div.sc-lhLRcH.fKjKUN div.tab-content div.fade.tab-pane.active.show:nth-child(1) div.sc-ekkqgF.gaGyIe div.sc-cLQEGU.laMIkr.sc-iBmynh.sc-dTLGrV.jRAOlW.row:nth-child(2) div.sc-dxgOiQ.hTjMfW.sc-fKGOjr.cHRnSh.col-lg-5:nth-child(2) div.sc-cLQEGU.laMIkr.sc-iBmynh.hJobBs.row div.sc-dxgOiQ.hTjMfW.sc-fKGOjr.cHRnSh.col-lg-4.col-md-3:nth-child(2) div.sc-fHSTwm.llJaQY.d-none.d-md-block > button.sc-jTzLTM.hQpNle.sc-cNnxps.gdptwU.btn.btn-primary"));
	searchButton.click();
		
	}
	@AfterTest
	public void afterTest(){
		myAssert.assertAll();
		
		
	}
	
	
	
}
