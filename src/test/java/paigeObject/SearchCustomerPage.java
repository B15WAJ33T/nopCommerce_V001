package paigeObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
	
    public WebDriver ldriver;
    public WaitHelper wait;
    public String email= "wemPEYaEJV@gmail.com";

    public SearchCustomerPage(WebDriver rdriver) 
   {
    	
	    ldriver = rdriver;
     	PageFactory.initElements(rdriver, this);
     	wait = new WaitHelper(ldriver);
   }
    
    @FindBy(how = How.ID, using = "SearchEmail" )
    @CacheLookup 
    WebElement txtEmail;
    
    @FindBy(how= How.ID, using = "SearchFirstName")
    @CacheLookup 
    WebElement txtFirstName;
    
    @FindBy(how= How.ID, using = "SearchLastName")
    @CacheLookup 
    WebElement txtLastName;
    
    @FindBy(how= How.ID, using = "SearchCompany")
    @CacheLookup 
    WebElement txtCompany;
    
    @FindBy(how= How.ID, using = "SearchIpAddress")
    @CacheLookup 
    WebElement txtIpAddress;
    
    @FindBy(how= How.XPATH, using = "//div[@role='listbox']")
    @CacheLookup 
    WebElement txtCompanyRole;
    
    @FindBy(how= How.XPATH, using = "//li[normalize-space()='Administrators']")
    @CacheLookup 
    WebElement txtRoleAdministrators;
    
    @FindBy(how= How.XPATH, using = "//li[normalize-space()='Dealer BIH']")
    @CacheLookup 
    WebElement txtRoleDealer;
    
    @FindBy(how= How.XPATH, using = "//li[normalize-space()='Forum Moderators']")
    @CacheLookup 
    WebElement txtRoleForumModerators;
    
    @FindBy(how= How.XPATH, using = "//li[normalize-space()='Guests']")
    @CacheLookup 
    WebElement txtRoleGuests;
    
    @FindBy(how= How.XPATH, using = "//li[normalize-space()='Registered']")
    @CacheLookup 
    WebElement txtRoleRegistered;
    
    @FindBy(how= How.XPATH, using = "//li[normalize-space()='Robot']")
    @CacheLookup 
    WebElement txtRoleRobot;
    
    @FindBy(how= How.XPATH, using = "//li[contains(text(),'Vendors')]")
    @CacheLookup 
    WebElement txtRoleVendors;
    
    @FindBy(how= How.ID, using = "SearchMonthOfBirth")
    @CacheLookup 
    WebElement txtDOBMonth;
    
    @FindBy(how= How.ID, using = "SearchDayOfBirth")
    @CacheLookup 
    WebElement txtDOBDay;
    
    @FindBy(how= How.ID, using = "search-customers")
    @CacheLookup 
    WebElement txtSearchBtn; 
    
    @FindBy(how= How.XPATH, using = "//table[@role='grid']]")
    @CacheLookup 
    WebElement txtSearchResult;
    
    @FindBy(how= How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup 
    WebElement txtSearchTable;
    
    @FindBy(how= How.XPATH, using = "//table[@id='customers-grid']//table/tr")
    @CacheLookup 
    List<WebElement> tableRow;
    
    @FindBy(how= How.XPATH, using = "//table[@id='customers-grid']//table/tr/td")
    @CacheLookup 
   List<WebElement> tableColumn;
    
    
    //Action methods for the above WebElments
    
    public void setEmail()
    {
    	txtEmail.sendKeys(email);
    }
    
    public void setFirstName(String firstName)
    {
    	txtFirstName.sendKeys(firstName);
    }
    
    public void setLastName(String lastName)
    {
    	txtLastName.sendKeys(lastName);
    }
    
    public void setCompany(String company)
    {
    	txtCompany.sendKeys(company);
    }
    
    public void setIPAdress(String ipAddress)
    {
    	txtIpAddress.sendKeys(ipAddress);
    }
    
    public void setCustomerRole(String role) throws InterruptedException
    {
    	txtCompanyRole.click();
    	
    	Thread.sleep(3000);
    	
    	if(role.equals("Administrators"))
    	{
    		txtRoleAdministrators.click();
    	}
    	else if(role.equals("Dealer BIH"))
    	{
    		txtRoleDealer.click();
    	}
    	else if(role.equals("Forum Moderators"))
    	{
    		txtRoleForumModerators.click();
    	}
    	else if(role.equals("Guests"))
    	{
    		txtRoleGuests.click();
    	}
    	else if (role.equals("Registered"))
    	{
    		txtRoleRegistered.click();
    	}
    	else if (role.equals("Robot"))
    	{
    		txtRoleRobot.click();
    	}
    	else if(role.equals("Vendors"))
    	{
    		txtRoleVendors.click();
    	}
    }
    
    public void setDOBMonth (String month)
    {
    	Select drp = new Select(txtDOBMonth);
    	drp.selectByVisibleText(month);
    }
    
    public void setDOBDay(String day)
    {
    	Select drp = new Select(txtDOBDay);
    	drp.selectByVisibleText(day);
    }
    
    public void clickSearch() throws InterruptedException
    { 
    	txtSearchBtn.click();
    	Thread.sleep(5000);
    }
    
    public int rowNumber()
    {
    	return(tableRow.size());
    }
    
    public int columnNumber ()
    {
    	return(tableColumn.size());
    }
    
    public boolean SearchCustomerByEmail(String email)
    {
        boolean flag = false;
    	
    	for(int i=1; i<=rowNumber(); i++)
    	{
    		String emailID = ldriver.findElement(By.xpath("//tbody/tr["+i+"]/td[2]")).getText();
    		System.out.println(emailID);
    		
    		if (emailID.equals(email))
    		{
    			flag =true;
    		}
    	}
    	return flag;
    }

}
