package MyCatalogue.sid.cat.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Selenium;


public class SeleniumTest {
	
	  private WebDriver driver; 

	  private String baseUrl; 

	  private boolean acceptNextAlert = true; 
	  
	  private Selenium selenium;
	  
	  private StringBuffer verificationErrors = new StringBuffer();
	  
	  @Before
	  public void setUp() throws Exception { 

		    // On instancie notre driver, et on configure notre temps d'attente 

		    driver = new FirefoxDriver(); 

		    baseUrl = "http://localhost:8080/index.html"; 
		    
		    selenium = new WebDriverBackedSelenium(driver, baseUrl);

		  //  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		  }
	  
	  @Test
	  public void testSelenium() throws Exception {
		  
		  selenium.open("/index.html");
		  //driver.get(baseUrl);
		  
		  //driver.findElement(By.id(id))
		  
	  }
	  
	  @After
	    public void tearDown() throws Exception {
	        selenium.stop();
	    }

}
