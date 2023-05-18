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
	
	
	@Test()
	public void randomWebSiteLanguage() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int random = myRandom.nextInt(URLS.length);
		driver.get(URLS[random]);
		String url = driver.getCurrentUrl();
		if(url.equals(URLS[1])) {
			
			System.out.println("en => from riyadh to dubai");
			
					WebElement oneWay = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[1]/div[1]/div[1]"));
					oneWay.click();
					
					WebElement countryFrom = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
					Thread.sleep(2000);
					countryFrom.sendKeys(citiesInEnglish[0] + Keys.ARROW_DOWN+ Keys.ENTER );
					
					WebElement countryTo = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input"));
					Thread.sleep(2000);
					countryTo.sendKeys(citiesInEnglish[1]+  Keys.ARROW_DOWN+ Keys.ENTER);
			
					Thread.sleep(5000);
					WebElement searchButton = driver.findElement(By.cssSelector("section.sc-kvkilB.guCDGw:nth-child(3) div.sc-kAKrxA.iyOiEz:nth-child(4) div.sc-jKJlTe.cjrpqw.container div.sc-lhLRcH.fKjKUN div.tab-content div.fade.tab-pane.active.show:nth-child(1) div.sc-ekkqgF.gaGyIe div.sc-cLQEGU.laMIkr.sc-iBmynh.sc-dTLGrV.jRAOlW.row:nth-child(2) div.sc-dxgOiQ.hTjMfW.sc-fKGOjr.cHRnSh.col-lg-5:nth-child(2) div.sc-cLQEGU.laMIkr.sc-iBmynh.hJobBs.row div.sc-dxgOiQ.hTjMfW.sc-fKGOjr.cHRnSh.col-lg-4.col-md-3:nth-child(2) div.sc-fHSTwm.llJaQY.d-none.d-md-block > button.sc-jTzLTM.hQpNle.sc-cNnxps.gdptwU.btn.btn-primary"));
					searchButton.click();
					
					
					
		}else if(url.equals(URLS[0])) {
			
			System.out.println("ar => from amman to jeddah");
			WebElement oneWay = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[1]/div[1]/div[1]"));
			oneWay.click();
			
			WebElement countryFrom = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[1]/div/div/div/input"));
			Thread.sleep(2000);
			countryFrom.sendKeys(citiesInArabic[0] + Keys.ARROW_DOWN+ Keys.ENTER);
			
			WebElement countryTo = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div[4]/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div[3]/div[1]/div/div/input"));
			Thread.sleep(2000);
			countryTo.sendKeys(citiesInArabic[1]+ Keys.ARROW_DOWN+ Keys.ENTER);
			
			Thread.sleep(5000);
			WebElement searchButton = driver.findElement(By.cssSelector("section.sc-kvkilB.loUbdP:nth-child(3) div.sc-kAKrxA.iyOiEz:nth-child(4) div.sc-jKJlTe.cjrpqw.container div.sc-lhLRcH.fKjKUN div.tab-content div.fade.tab-pane.active.show:nth-child(1) div.sc-ekkqgF.gaGyIe div.sc-cLQEGU.laMIkr.sc-iBmynh.sc-dTLGrV.jRAOlW.row:nth-child(2) div.sc-dxgOiQ.hTjMfW.sc-fKGOjr.cHRnSh.col-lg-5:nth-child(2) div.sc-cLQEGU.laMIkr.sc-iBmynh.hJobBs.row div.sc-dxgOiQ.hTjMfW.sc-fKGOjr.cHRnSh.col-lg-4.col-md-3:nth-child(2) div.sc-fHSTwm.llJaQY.d-none.d-md-block > button.sc-jTzLTM.eJkYKb.sc-cNnxps.gdptwU.btn.btn-primary"));
			searchButton.click();
			
			
		}else{

			myAssert.assertEquals(
					url.equals(URLS[0]) || url.equals(URLS[1]),
					true, "this is to test the website url ");

		}
		
	}

	@AfterTest
	public void afterTest(){
		myAssert.assertAll();
		
		
	}
	
	
	
}
