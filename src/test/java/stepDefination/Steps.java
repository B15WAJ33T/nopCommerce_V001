package stepDefination;

import io.cucumber.java.Before;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import paigeObject.AddCustomerPage;
import paigeObject.LoginPage;
import paigeObject.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Steps extends BaseClass{

    @Before
	public void setup() throws IOException {

		logger = Logger.getLogger("mopCommerce_V001_Cucumber");
		PropertyConfigurator.configure("log4j.properties");

		prop = new Properties();
		FileInputStream configFile = new FileInputStream("config.properties");
		prop.load(configFile);

		String browserValue = prop.getProperty("browser");
		if(browserValue.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if (browserValue.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if (browserValue.equals("edge")){
			System.setProperty("webdriver.edge.driver", prop.getProperty("edgepath"));
			driver = new EdgeDriver();
		}
		logger.info("*******    Launching Browser     *******");
	}

	@Given("User launch the browser")
	public void user_launch_the_browser() {

	    lp = new LoginPage(driver);
	    acp = new AddCustomerPage(driver);
	    scp = new SearchCustomerPage(driver);
	    
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		logger.info("*******      Opening URL      *******");
		driver.get(url);
	}

	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		logger.info("*******      Setting email id & passsword      *******");
		lp.setEmail(email);
	   lp.setPassword(pwd);
	}

	@When("Click on login")
	public void click_on_login() {
		logger.info("*******     Logging in the account       *******");
		lp.clickLogin();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		logger.info("*******     Confirming the page title       *******");
		String actitle = driver.getTitle();
		if (actitle.equals(title))
		{
			Assert.assertEquals(title, actitle);
		}
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {

		logger.info("*******      Logging out      *******");
		lp.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("*******      Closing the browser      *******");
		driver.quit();
	}
	
	//add customer step definations


    @Then("User can see the dashboard {string}")
    public void user_can_see_the_dashboard(String title) {
		logger.info("*******      Confirming the dashboard      *******");
		Assert.assertEquals(title, driver.getTitle());
    }
    @When("User click on Customers menu")
    public void user_click_on_customers_menu() {
		logger.info("*******      Clicking the Customer menu      *******");
		acp.clickCustomerMenu();
    }
    @When("Click on Customers menu item")
    public void click_on_customers_menu_item() {
		logger.info("*******      Clicking the Customer menu item      *******");
		acp.clickCustomerOpt();
    }
    @When("Click on Add New button")
    public void click_on_add_new_button() throws InterruptedException {
		logger.info("*******     Clicking add new customer button      *******");
		acp.addCustomer();
    }
    @Then("User can view Add a new customer page {string}")
    public void user_can_view_add_a_new_customer_page(String addTitle) {
		logger.info("*******      Confirming the add new customer page      *******");
		Assert.assertEquals(addTitle, driver.getTitle());
    }
    @When("User enters customer info")
    public void user_enters_customer_info() throws InterruptedException {
		logger.info("*******      Providing the customer info      *******");
		String Email = randomString()+"@gmail.com";
        acp.setEmail(Email);
        acp.setPassword("user1234");
        acp.setFirstName("Momota");
        acp.setLastName("Singh");
        acp.setGender("Female");
        acp.setDOB("6/06/1996");
        acp.setCompanyName("A2Z Technology");
        acp.setTaxExempt();
        acp.setNewsLetter("Test store 2");
        acp.setRole("Vendors");
        acp.setManagerOfVendor("Vendor 1");
        acp.setActive();
        acp.setAdminComment("This is Add Customer testing in BDD......");
    }
    @When("Click on Save button")
    public void click_on_save_button() {
		logger.info("*******      Clicking the Save button      *******");
		acp.clickSave();
    }
    @Then("User can view confermation message {string}")
    public void user_can_view_confermation_message(String conformation) {
		logger.info("*******      Confirming the Save confirmation message       *******");
		driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully.");
    }
    
 // search by email step defination
    
    
    @When("Enter customer Email")
	public void enter_customer_email() {
		logger.info("*******      Entering the customer email to search      *******");
		scp.setEmail();
	}
    
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("*******      Clicking the Search button      *******");
		scp.clickSearch();
	}
	@Then("User should find email in the search table")
	public void user_should_find_email_in_the_search_table() {
		logger.info("*******      Confirming if the customer email s present in the search table     *******");
		boolean status = scp.SearchCustomerByEmail("wemPEYaEJV@gmail.com");
	    Assert.assertEquals(true, status);
	}
    
    
 
	
}




