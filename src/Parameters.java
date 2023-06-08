import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

public class Parameters {

	SoftAssert myAssert = new SoftAssert();
	Random myRandom = new Random();
	WebDriver driver = new EdgeDriver();
	static String [] URLS ={"https://www.almosafer.com/ar","https://www.almosafer.com/en"};
	
	static String [] citiesInEnglish ={"Riyadh","Dubai","Jeddah"};
	static String [] citiesInArabic ={"Amman" , "Jeddah"};
	static String DefaultCurrency = "SAR";
	static String ContactNumber = "+966554400000";
}
