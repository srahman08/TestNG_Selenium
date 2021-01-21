package billingTechFios;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestingDropDown {
	
	WebDriver driver;
	@Before
	public void deposit() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.techfios.com/billing/?ng=admin/");
	}
	@Test
	public void CutomerAddSearch() throws InterruptedException	{
	WebElement USERNAME = driver.findElement(By.xpath("//input[@id='username']"));
	WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']")); 
	WebElement SUBMIT = driver.findElement(By.xpath("//button[@type='submit']"));  
	USERNAME.sendKeys("demo@techfios.com");
	PASSWORD.sendKeys("abc123");
	SUBMIT.click();
	Thread.sleep(3000);
	
	System.out.println(driver.getTitle());
	System.out.println(driver.getWindowHandle());

//	driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
//	Thread.sleep(2000);
//	driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/add/']")).click();;
//	Thread.sleep(2000);
//	
	 //Select sel = new Select(driver.findElement(By.xpath("//select[@id='cid']")));
	 //sel.selectByVisibleText("Techfios");

	//driver.findElement(By.xpath("//option[contains(text(),'Techfios')]")).click();
	
//Actions actions = new Actions(driver);
//	actions.moveToElement(driver.findElement(By.xpath("//select[@id='cid']"))).build().perform();
//	driver.findElement(By.xpath("//option[contains(text(),'Techfios')]")).click();

//	Select sel = new Select(DROP_DOWN_BUTTOM);
//	sel.selectByVisibleText("String");
	
	//Select sel = new Select(DROP_DOWN_BUTTOM);
	//List<WebElement> options = sel.getOptions();
	// arraylist here-->>>
	
	
//	
	
}
}