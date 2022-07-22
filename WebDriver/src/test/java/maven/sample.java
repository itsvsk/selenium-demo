package maven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sample {
WebDriver driver;
	
	@BeforeTest
	  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver","D://chromedriver_win32//chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		System.out.println(title +"  "+url);
		
		Assert.assertEquals(title, "OrangeHRM");
		Assert.assertEquals(url, "https://opensource-demo.orangehrmlive.com/");
		
	  }

  @Test
  public void f() throws InterruptedException {
	  	driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		//Assert.assertEquals("admin123", "admin123");
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("welcome")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='welcome-menu']/ul/li[3]/a")).click(); 
  }
  
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
