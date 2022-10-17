package stepDefination;


import org.apache.log4j.Logger;
import paigeObject.AddCustomerPage;
import paigeObject.LoginPage;
import paigeObject.SearchCustomerPage;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class BaseClass {
	    WebDriver driver;
	    public LoginPage lp;
	    public AddCustomerPage acp;
	    public SearchCustomerPage scp;
		public Logger logger;

		public Properties prop;

	    public static String randomString()
	    {
	        String generatedString = RandomStringUtils.randomAlphabetic(5);
	        return (generatedString);
	    }
	}

