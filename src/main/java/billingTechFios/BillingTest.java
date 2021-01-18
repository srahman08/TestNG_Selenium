package billingTechFios;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingTest {
	WebDriver driver;
	@Before
	public void deposit() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		Thread.sleep(3000);
		}
	@Test
	public void CutomerSearch() throws InterruptedException	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/add/']")).click();;
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Shamim Rahman");

		
		
		
		driver.findElement(By.xpath("//*[@id=\"rform\"]/div[1]/div[1]/div[10]/div/span/span[1]/span/ul")).sendKeys("shamim");
		/*driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'List Customers')]")).click();
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		Assert.assertEquals("You got it wrong", "Contacts", contact.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("sdaf");*/
	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("scroll(0,500)");
//		Thread.sleep(4000);
		//js.executeScript("window.scrollBy(0,200)");
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	

		//driver.findElement(By.xpath("//option[contains(text(),'Techfios')]")).click();
		
		/*driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'List Customers')]")).click();
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2"));
		Assert.assertEquals("You got it wrong", "Contacts", contact.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("sdaf");*/
	
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
//		Thread.sleep(2000);
	}
	
	
	
//
//	 @After
//	 public void tearDown() {
//	 	driver.close();
//		
		 
		 
		
	}

	
	/* @Test 	public void login() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='fa fa-university']")).click();
		driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=accounts/add/']")).click();
		//Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='account']"))));
		
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("SHAMIM2");
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("personal");
		driver.findElement(By.xpath("//input[@id='balance']")).sendKeys("$5000.00");
		driver.findElement(By.xpath("//input[@id='account_number']")).sendKeys("123456789");
		driver.findElement(By.xpath("//input[@id='contact_person']")).sendKeys("shamim");
		driver.findElement(By.xpath("//input[@id='contact_phone']")).sendKeys("347-592-5234");
		driver.findElement(By.xpath("//input[@id='ib_url']")).sendKeys("https://www.chase.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();*/

		
	
