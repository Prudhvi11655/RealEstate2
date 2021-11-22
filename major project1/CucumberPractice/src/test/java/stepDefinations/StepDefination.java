//install tidy gherkin plugin in chrome
//Run feature file- Ru as feature file
//configure convert to cucumber project
//cucumbr option and stepdefanition should have same parent


package stepDefinations;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Resources.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import pageObjects.Comments;
import pageObjects.SigninPage;
import pageObjects.SignupPage;

public class StepDefination extends Base {

	//create new instance of webdriver
	public WebDriver driver;

	//initialize browser with chrome
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Throwable {
		driver=initializeDriver();
	}

	//navigate to site
	@And("^Navigate to  \"([^\"]*)\" site$")
	public void navigate_to_something_site(String url) throws Throwable {

		//get url
		driver.get(url);  
		//maximize the window
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait

		//scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");

	}

	//method for registration
	@And("^Click on Regiter link in home page to land on Secure signup Page$")
	public void click_on_regiter_link_in_home_page_to_land_on_secure_signup_page() throws Throwable {
		SignupPage lpp=new SignupPage(driver);
		lpp.getregister().click();
	}

	//enter email firstname lastname
	@When("^entered (.+) and (.+) and (.+)$")
	public void entered_and_and(String email, String firstname, String lastname) throws Throwable {
		
		//creating object for signuppage class
		SignupPage lp=new SignupPage(driver);
		
		//entering required details
		lp.getemail().sendKeys(email);           
		lp.getfirstname().sendKeys(firstname);
		lp.getlastname().sendKeys(lastname);

	}

	//submit details
	@Then("^click on Register button$")
	public void click_on_register_button() throws Throwable {
		
		//creating object for singuppage 
		SignupPage lp=new SignupPage(driver);
		lp.getregisterbtn().click();

		//scroll up
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");	

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
	}

	//getting text
	@And("^getting text$")
	public void getting_text() throws Throwable {
		WebElement msg=driver.findElement(By.xpath("//div[@class='notification success closeable']"));
		
		//calling gettext method
		String text=msg.getText();
		System.out.println(text);

		//expected text
		String expectedText = "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";

		//use assertEquals method
		Assert.assertEquals(text,expectedText);
		System.out.println("I didn't get mail"); //DEFECT ID: LP01- Defect in Sign Up Functionality  
		

		//close window
		driver.close();
	}

	//method for login
	@Given("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
		
		//creating object for signinpage
		SigninPage lp=new SigninPage(driver);
		lp.getLoginbtn().click();
	}

	// method for entering details
	@When("^I entered (.+) and (.+) logs in$")
	public void i_entered_and_logs_in(String username, String password) throws Throwable {

		//craeting object  for signinpage
		SigninPage lp=new SigninPage(driver);
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);	
	}

	//method for signin button
	@Then("^Click on signin button$")
	public void click_on_signin_button() throws Throwable {

		//creating object for signinpage
		SigninPage ll=new SigninPage(driver);		
		ll.getSignin().click();		

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
	}

	//close browser
	@And("^close browser$")
	public void close_browser() throws Throwable {
		driver.close();
	}

	//method for opening dashboard
	@Given("^user get the Dashboard$")
	public void user_get_the_dashboard() throws Throwable {
		System.out.println("dashboard open");

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
	}

	//method for comments icon
	@When("^user click on  the Comments icon$")
	public void user_click_on_the_comments_icon() throws Throwable {
		driver.findElement(By.xpath("//div[@class='wp-menu-image dashicons-before dashicons-admin-comments']")).click();

	}
	
	//methods for allcomments,pending,sapm,approved,trash
	@Then("^user get few options$")
	public void user_get_few_options() throws Throwable {

		//loop for clicking options
		for(int i=1;i<=5;i++) {
			driver.findElement(By.xpath("//*[@id='wpbody-content']//div[3]//ul//li["+ i +"]//a")).click();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
		}
	}
    //method for eac option available
	@And("^each option should be available$")
	public void each_option_should_be_available() throws Throwable {
      System.out.println("each option available");
	}


	//method for searchbrox
	@Then("^click on search box$")
	public void click_on_search_box() throws Throwable {

		//creating object for comments
		Comments srch=new Comments(driver);
		srch.getsearch().click();		
	}

	//method for user id
	@And("^enter (.+)$")
	public void enter(String userId) throws Throwable {

		//creating object for comment
		Comments src=new Comments(driver);
		src.getsearch().sendKeys(userId);
	}

	//method for search comment
	@And("^click on search comment$")
	public void click_on_search_comment() throws Throwable {

		// creating object for comment
		Comments sbtn=new Comments(driver);
		sbtn.getsearchbtn().click();
	}

	//method for shows user comment
	@And("^shows user comment$")
	public void shows_user_comment() throws Throwable {		
		System.out.println("Then shows user comment");

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
	} 
    //method for dropdown button
	@And("^click on dropdown button$")
	public void click_on_dropdown_button() throws Throwable {

		//method for find dropdown element
		WebElement testDropDown = driver.findElement(By.cssSelector("[id='filter-by-comment-type']"));

		//creating object for select class
		Select dropdown = new Select(testDropDown);  

		//As this is static dropdown, order will not change
		//find COMMENTS option  using index method
		dropdown.selectByIndex(1); 

		System.out.println(testDropDown.getText());	
		//find COMMENTS option  using value method
		dropdown.selectByValue("pings");
	}
	//method for select option
	@Then("^select option$")
	public void select_option() throws Throwable {

		System.out.println("select comment option");		
	}

	//method for filter
	@And("^click on filter$")
	public void click_on_filter() throws Throwable {

		//creating object for comment
		Comments fltr=new Comments(driver);
		fltr.getfilter().click();
	}
	
    //method for reply option
    @When("^user hover to reply option$")
    public void user_hover_to_reply_option() throws Throwable {    	
    	WebElement Rpl=driver.findElement(By.xpath("//p[text()='no']"));
    	
    	//using action to hovering mouse to the option
    	Actions as=new Actions(driver);
		as.moveToElement(Rpl).click(Rpl).build().perform();
        
    	//creating webelement for reply
    	WebElement Reply=driver.findElement(By.xpath("//a[text()='Reply']"));
    	//using action to click on reply 
		Actions ac=new Actions(driver);
		ac.moveToElement(Reply).click(Reply).build().perform();
        
    }
    //method for click on reply button
    @And("^click on reply button$")
    public void click_on_reply_button() throws Throwable {
        Comments txt=new Comments(driver);
        txt.gettxt().sendKeys("hii");
    }
     
    //method for text in comment box
    @Then("^user enter any text in the comment box$")
    public void user_enter_any_text_in_the_comment_box() throws Throwable {
        System.out.println("hii");
    }
    
    //method for send button
    @And("^click on send$")
    public void click_on_send() throws Throwable {
       Comments sd=new Comments(driver);
       sd.getsend().click();
       
       //method for refresh window
       driver.navigate().refresh();
       
       driver.close(); //close browser
    }

}


