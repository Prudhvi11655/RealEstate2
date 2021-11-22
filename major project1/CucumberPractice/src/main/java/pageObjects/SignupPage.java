package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {

	
	public WebDriver driver;
	//assigning elements path to a identifier
		
	By register=By.xpath("//a[text()='Register']");
	By email=By.cssSelector("[id='email']");
	By firstname=By.cssSelector("[id='first-name']");
	By lastname=By.cssSelector("[id='last-name']");
	By registerbtn=By.cssSelector("[value='Register']");
	

	public SignupPage(WebDriver driver) {
		
		this.driver=driver;
		
	}
    
	//creating methods for elements
     
    public WebElement getregister()
    {
    	return driver.findElement(register);
    }

	public WebElement getemail()
	{
		return driver.findElement(email);
	}
	

	public WebElement getfirstname()
	{
		return driver.findElement(firstname);
	}
	
	public WebElement getlastname()
	{
		return driver.findElement(lastname);
	}
	
	
	public WebElement getregisterbtn()
	{
		return driver.findElement(registerbtn);
	}
	
	
	
}
