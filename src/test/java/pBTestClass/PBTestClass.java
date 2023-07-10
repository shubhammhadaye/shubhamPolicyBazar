package pBTestClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basePackage.Base;
import pbPOM.MyAcounttPage;
import pbPOM.LoginPagePOM;
import utilityPackage.UtilityClass;

public class PBTestClass extends Base{
     LoginPagePOM LPP;
     MyAcounttPage MAP;
    
	
	@BeforeClass
  public void openbrowser() throws InterruptedException
  {
		luanchBrowser(); 
		LPP=new LoginPagePOM(driver);
	    MAP=new MyAcounttPage(driver);
  }
	@BeforeMethod
	public void logintoPOlicyBazaar() throws EncryptedDocumentException, IOException, InterruptedException
	{   
		
	   
		LPP.clickOnHomePageSignInButton();
		UtilityClass.waitsleep(2000);
		LPP.enterMobileNumber(UtilityClass.readDataFromProperties("mobNo"));
		UtilityClass.waitsleep(1000);
		LPP.clickOnSignInWithPassword();
		UtilityClass.waitsleep(2000);
		LPP.enterPassword(UtilityClass.readDataFromProperties("pwd"));
		UtilityClass.waitsleep(1000);
		LPP.clickOnSignInButton();
		UtilityClass.waitsleep(2000);
		LPP.clickOnMyAccountButton();
		UtilityClass.waitsleep(1000);
		LPP.clickOnMyProfileButton();
		
		// switch to new tab
		  
		Set<String> allID = driver.getWindowHandles();
		List<String> wh=new ArrayList<>(allID);
		
		driver.switchTo().window(wh.get(1));
		
	}
	
	@Test
	  public void verifyUserName() throws EncryptedDocumentException, IOException, InterruptedException 
	  {     UtilityClass.waitsleep(2000);
			String actoutput=MAP.validateUserName();
			String expOutput=UtilityClass.readDataFromProperties("un");
			
	   Assert.assertEquals(actoutput, expOutput,"Actual Output and Expected Ouput are not Matched, TC is failed");
	 }
//	@Test
//	 public void verifyemail() throws EncryptedDocumentException, IOException, InterruptedException 
//	  {      UtilityClass.waitsleep(1000);
//			String acotput=MAP.validatemailid();
//			String epotput=UtilityClass.readDataFromProperties("email");
//			
//	   Assert.assertEquals(acotput, epotput,"Actual Output and Expected Ouput are not Matched, TC is failed");
//	 }
	
	
	@AfterMethod
	public void logoutFromPolicyBazar() throws InterruptedException
	{   
		UtilityClass.waitsleep(2000);
		MAP.clickOnLogoutButton();
	}
	
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{   
		UtilityClass.waitsleep(2000);
		closetheBrowser();
		UtilityClass.waitsleep(3000);
	}
}
