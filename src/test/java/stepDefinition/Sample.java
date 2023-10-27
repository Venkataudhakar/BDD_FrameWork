package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;

public class Sample 
{
	WebDriver driver;
	
	@Given("launch the browser")
	public void launch_the_browser() 
	{
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@Given("launch the application URLs {string}")
	public void launch_the_application_ur_ls(String url)
	{
	    driver.get(url);
	    driver.quit();
	}
}
