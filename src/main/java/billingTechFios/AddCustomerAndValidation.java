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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerAndValidation {
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/add/']")).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='account']")).sendKeys("Shamim Rahman");
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//select[@id='cid']"))).build().perform();
		driver.findElement(By.xpath("//option[contains(text(),'Techfios')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("srahman08@gmail.com");
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("347-592-5234");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("2741 E Belt Line Rd #105");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Carrollton");
		driver.findElement(By.xpath("//input[@id='state']")).sendKeys("Texas");
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("75006");
		actions.moveToElement(driver.findElement(By.xpath("//select[@name='group']"))).build().perform();
		driver.findElement(By.xpath("//option[contains(text(),'AUG 2020')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/list/']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@placeholder='Search...']"))));
		driver.findElement(By.xpath("//input[@placeholder='Search...']")).sendKeys("Shamim Rahman");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Welcome Techfios')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
		Thread.sleep(2000);
		driver.close();
		}
		@Test
		public void ValidateContact() throws InterruptedException {
		WebElement USERNAME = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement PASSWORD = driver.findElement(By.xpath("//input[@id='password']")); 
		WebElement SUBMIT = driver.findElement(By.xpath("//button[@type='submit']"));  
		USERNAME.sendKeys("demo@techfios.com");
		PASSWORD.sendKeys("abc123");
		SUBMIT.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='https://techfios.com/billing/?ng=contacts/list/']")).click();
		Thread.sleep(2000);
		
//		WebElement contact = driver.findElement(By.xpath("//h2[contains(text(),'Contacts')]"));
//		Assert.assertEquals("You got it wrong", "Contacts", contact.getText());

		boolean pageTitleDisplayStatus;
		try 
		{
			WebElement dashboardTtile = driver.findElement(By.xpath("//h2[contains(text(),'Contacts1')]"));
			pageTitleDisplayStatus = true;
			
		} catch (Exception e) {
			pageTitleDisplayStatus = false;
			e.printStackTrace();
		}
		
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Welcome Techfios')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[contains(text(),'Logout')])[2]")).click();
		Thread.sleep(2000);
		}
		
		
		public void gitPushTest() {
			
			System.out.println("01182021 git push test");
		}
		
		public void testingSecondPush() {
			
			System.out.println("10 AM git push test");
		}
		
		
		
		@After
		public void tearDown() {
	 	driver.quit();
		}	
		}