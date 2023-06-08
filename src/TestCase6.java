import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase6 extends Parameters {

	
	@BeforeTest
	public  void beforeTest() {

		driver.manage().window().maximize();			
		driver.get(URLS[1]);
	} 
	
	@Test()
	public void hotelsBookTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Hotels_tab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		Hotels_tab.click();
		Thread.sleep(2000);
		WebElement Hotels_input = driver.findElement(By.className("AutoComplete__Input"));
		Select SelectRoomsButton = new Select(driver.findElement(By.className("tln3e3-1")));
		WebElement Searchbutton = driver.findElement(By.className("js-HotelSearchBox__SearchButton"));
		
		// Hotel info steps
		Hotels_input.sendKeys("Amman" + Keys.ARROW_DOWN + Keys.ENTER);
		SelectRoomsButton.selectByVisibleText("1 Room, 1 Adult, 0 Children");
		Searchbutton.click();
		// Select hotel
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,50)");
		WebElement SeeRoomsButton = driver.findElement(By.xpath("//*[@id=\"hotelCard-1447944\"]/div[3]/div/div[2]/button"));
		SeeRoomsButton.click();
		
		String currentTab = driver.getWindowHandle();
		for (String tab : driver.getWindowHandles()) {
		    if (!tab.equals(currentTab)) {
		        driver.switchTo().window(tab);
		        // Select a room
				WebElement RoomChoicesButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div/a[2]"));
				RoomChoicesButton.click();
				WebElement FreeCancellation = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/section[2]/section/div/div/div/div[2]/label"));
				FreeCancellation.click();
				WebElement BookNowButton = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/section[2]/section/section/div[1]/div[1]/div[2]/div[1]/div[4]/button"));
				BookNowButton.click();
				// Checkout Page
				WebElement FirstName = driver.findElement(By.name("contact.firstName"));
				WebElement LastName = driver.findElement(By.name("contact.lastName"));
				WebElement Email = driver.findElement(By.name("contact.email"));
				WebElement PhoneNumber = driver.findElement(By.name("contact.phoneNumber"));
				WebElement ContinueToPayment = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[5]/button"));
				// Enter guest details Steps
				FirstName.sendKeys("Osama");
				LastName.sendKeys("Alzoubi");
				Email.sendKeys("osamayahia878@gmail.com");
				PhoneNumber.sendKeys("7485259");
				ContinueToPayment.click();
				// Payment Page
				WebElement PayLater = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div/div[3]/div/div[1]/form/div/div/div[2]/div/div/div/button[3]"));
				PayLater.click();
		    }       
		}	

	}
	
	@AfterTest
	public void afterTest() {
		myAssert.assertAll();
		driver.quit();		
	}	
}
