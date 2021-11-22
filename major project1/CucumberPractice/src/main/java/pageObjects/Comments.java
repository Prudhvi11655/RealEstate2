package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Comments {

	public WebDriver driver;
	
	//assigning elements path to a identifier
	
	By search=By.cssSelector("[id='comment-search-input']");
	By searchbtn=By.cssSelector("[id='search-submit']");
	
	By filter=By.cssSelector("[id='post-query-submit']");
	
	By reply=By.xpath("//a[@data-comment-id='2350'][@class='vim-r comment-inline']");
	
	By txt=By.xpath("//textarea[@class='wp-editor-area']");
	
	By send=By.cssSelector("[id='replybtn']");
	
public Comments(WebDriver driver) {
		
		this.driver=driver;
		
	}
    //creating methods for elements
    
    public WebElement getsearch()
    {
    	return driver.findElement(search);
    }

    public WebElement getsearchbtn()
    {
    	return driver.findElement(searchbtn);
    }

    public WebElement getfilter()
    {
    	return driver.findElement(filter);
    	
    }
   
    public WebElement getreply()
    {
    	return driver.findElement(reply);
    	
    }
	
    public WebElement gettxt()
    {
    	return driver.findElement(txt);
    	
    }
    
    public WebElement getsend()
    {
    	return driver.findElement(send);
    	
    }
}
