package stepDefinition;

import java.time.Duration;
import java.util.ResourceBundle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage 
{
	WebDriver driver;
	ResourceBundle rb;//Reading data from property file
	String browser;// Store the browser name
	
	@Before
	public void setup()
	{
		rb = ResourceBundle.getBundle("CommanData");
		String br = rb.getString("browser");

		if(br.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		} 
		else if (br.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		} 
		else if(br.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		} 
		else
		{
			System.out.println("Invalid browser launched");
		}
	}
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@Given("user to launch the browser")
	public void user_to_launch_the_browser()
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Given("launch the application {string}")
	public void launch_the_application(String url)
	{
	    driver.get(url);
	}

	@When("user enters the valid username {string}")
	public void user_enters_the_valid_username(String username)
	{
	    driver.findElement(By.id("username")).sendKeys(username);
	}
	@When("user enters the valida password {string}")
	public void user_enters_the_valida_password(String password)
	{
		 driver.findElement(By.name("pwd")).sendKeys(password);
	}

	@When("click on Submit button")
	public void click_on_submit_button()
	{
	    driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}

	@Then("navigate to application home page when user clicks on Submit button")
	public void navigate_to_application_home_page_when_user_clicks_on_submit_button()
	{
	    System.out.println(driver.getTitle());
	}

	@Then("user to click on LogOut button to signout from the application")
	public void user_to_click_on_log_out_button_to_signout_from_the_application()
	{
	    driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}
}
