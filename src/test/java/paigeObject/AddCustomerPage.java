package paigeObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	

	
public WebDriver ldriver;

public AddCustomerPage(WebDriver rdriver)
{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
}


	    @FindBy(xpath = "//a[@href='#']//p[contains(text(),'Customers')]")
	    @CacheLookup
	    WebElement customerMenu;

	    @FindBy(xpath = "//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")
	    @CacheLookup
	    WebElement customerOpt;

	    @FindBy(xpath = "//a[@class='btn btn-primary']")
	    @CacheLookup
	    WebElement addCustomerBtn;

	    @FindBy(name = "Email")
	    @CacheLookup
	    WebElement inputEmail;

	    @FindBy(name = "Password")
	    @CacheLookup
	    WebElement inputPassword;

	    @FindBy(name = "FirstName")
	    @CacheLookup
	    WebElement inputFirstName;

	    @FindBy(name = "LastName")
	    @CacheLookup
	    WebElement inputLastName;

	    @FindBy(id = "Gender_Male")
	    @CacheLookup
	    WebElement genderMale;

	    @FindBy(id = "Gender_Female")
	    @CacheLookup
	    WebElement genderFemale;

	    @FindBy(id = "DateOfBirth")
	    @CacheLookup
	    WebElement inputDOB;

	    @FindBy(id = "Company")
	    @CacheLookup
	    WebElement inputCompany;

	    @FindBy(id = "IsTaxExempt")
	    @CacheLookup
	    WebElement inputTaxExempt;

	    @FindBy(xpath = "//div[@class='input-group-append']//div[@role='listbox']")
	    @CacheLookup
	    WebElement inputNewsLetter;

	    @FindBy(xpath = "//li[normalize-space()='Your store name']")
	    @CacheLookup
	    WebElement inputNewsLetterYourStoreName;

	    @FindBy(xpath = "//li[normalize-space()='Test store 2']")
	    @CacheLookup
	    WebElement inputNewsLetterTestStore;

	    @FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']")
	    @CacheLookup
	    WebElement inputRole;

	    @FindBy(xpath = "//li[normalize-space()='Administrators']")
	    @CacheLookup
	    WebElement inputRoleAdministrator;

	    @FindBy(xpath = "//li[normalize-space()='Forum Moderators']")
	    @CacheLookup
	    WebElement inputRoleForumModerators;

	    @FindBy(xpath = "//li[normalize-space()='Guests']")
	    @CacheLookup
	    WebElement inputRoleGuests;

	    @FindBy(xpath = "//li[normalize-space()='Registered']")
	    @CacheLookup
	    WebElement inputRoleRegistered;

	    @FindBy(xpath = "//li[contains(text(),'Vendors')]")
	    @CacheLookup
	    WebElement inputRoleVendors;

	    @FindBy(xpath = "//select[@id='VendorId']")
	    @CacheLookup
	    WebElement inputManagerVendor;

	    @FindBy(id = "Active")
	    @CacheLookup
	    WebElement inputActive;

	    @FindBy(id = "AdminComment")
	    @CacheLookup
	    WebElement inputAdminComment;


	    public void clickCustomerMenu()
	    {
	    	customerMenu.click();
	    }

	    public void clickCustomerOpt()
	    {
	        customerOpt.click();
	    }

	    public void addCustomer() throws InterruptedException {
	        addCustomerBtn.click();
	        Thread.sleep(10000);
	    }

	    public void setEmail(String custEmail)
	    {
	        inputEmail.sendKeys(custEmail);
	    }

	    public void setPassword(String cusPassword)
	    {
	        inputPassword.sendKeys(cusPassword);
	    }

	    public void setFirstName(String firstName)
	    {
	        inputFirstName.sendKeys(firstName);
	    }

	    public void setLastName(String lastName)
	    {
	        inputLastName.sendKeys(lastName);
	    }

	    public void setGender(String gender)
	    {
	        if(gender.equals("Male"))
	        {
	            genderMale.click();
	        }
	        else if (gender.equals("Female"))
	        {
	            genderFemale.click();
	        }
	        else
	        {
	            genderMale.click();
	        }
	    }

	    public void setDOB(String dob)
	    {
	        inputDOB.sendKeys(dob);
	    }

	    public void setCompanyName(String cmpName)
	    {
	        inputCompany.sendKeys(cmpName);
	    }

	    public void setTaxExempt()
	    {
	        inputTaxExempt.click();
	    }

	    public void setNewsLetter(String letter) throws InterruptedException
	    {
	        inputNewsLetter.click();
	        Thread.sleep(5000);

	        if (letter.equals("Your store name"))
	        {
	            inputNewsLetterYourStoreName.click();
	        }
	        else
	        {
	            inputNewsLetterTestStore.click();
	        }
	    }

	    public void setRole(String role) throws InterruptedException
	    {

	        inputRole.click();
	        WebElement listItems;
	        
	        Thread.sleep(5000);

	        if(role.equals("Administrators"))
	        {
	            listItems= inputRoleAdministrator;
	        }
	        else if(role.equals("Forum Moderators"))
	        {
	            listItems= inputRoleForumModerators;
	        }
	        else if(role.equals("Guests"))
	        {
	            listItems= inputRoleGuests;
	        }
	        else if(role.equals("Registered"))
	        {
	            listItems= inputRoleRegistered;
	        }
	        else
	        {
	            listItems= inputRoleVendors;
	        }

	        listItems.click();
	    }

	    public void setManagerOfVendor(String value) throws InterruptedException
	    {
	        Select drp = new Select(inputManagerVendor);
	        
	        Thread.sleep(5000);
	        drp.selectByVisibleText(value);
	    }

	    public void setActive()
	    {
	        inputActive.click();
	    }

	    public void setAdminComment(String comment)
	    {
	        inputAdminComment.sendKeys(comment);
	    }

	    public void clickSave()
	    {
	        ldriver.findElement(By.xpath("//button[@name='save']")).click();
	    }

}
