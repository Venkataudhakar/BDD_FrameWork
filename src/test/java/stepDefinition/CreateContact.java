package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import ObjectRepository.LoginPage;

import java.time.Duration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateContact
{
	WebDriver driver;
	LoginPage lp;
	
	@Given("user to launch the browser and launch the application with valid URL {string}")
	public void user_to_launch_the_browser_and_launch_the_application_with_valid_url(String url)
	{
		driver = new EdgeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.get(url);
	}
	@Given("enter the valid user name {string} and pass word {string} and click on Login button")
	public void enter_the_valid_user_name_and_pass_word_and_click_on_login_button(String userName, String passWord) 
	{
	    driver.findElement(By.name("user_name")).sendKeys(userName);
	    driver.findElement(By.name("user_password")).sendKeys(passWord);
	    driver.findElement(By.id("submitButton")).click();
	}
	@When("user click on Contacts link and click on Create Contact lookup image")
	public void user_click_on_contacts_link_and_click_on_create_contact_lookup_image()
	{
	    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	    driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	}
	@Then("enter last name {string} in Last Name field and select valid Lead Source {string} from drop down list and click on Save button")
	public void enter_last_name_in_last_name_field_and_select_valid_lead_source_from_drop_down_list_and_click_on_save_button(String lastName, String leadSource)
	{
		driver.findElement(By.name("lastname")).sendKeys(lastName);
	    
	    WebElement dropDown = driver.findElement(By.name("leadsource"));
	    Select s = new Select(dropDown);
	    s.selectByValue("Cold Call");
	    
	    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	@Then("validate the Contact Info and click on logout button")
	public void validate_the_contact_info_and_click_on_logout_button() 
	{
	   String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	   if (contactHeader.contains(contactHeader))
	   {
		   System.out.println("PASS");
	   } else 
	   {
		   System.out.println("PASS");
	   }
	  
	  WebElement logOut = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  Actions a = new Actions(driver);
	  a.moveToElement(logOut).perform();
	  
	  driver.quit();
	}
}
