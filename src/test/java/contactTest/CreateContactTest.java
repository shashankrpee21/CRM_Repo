package contactTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import generic.baseTest.BaseClass;
import generic.webDriverUtility.UtilityClassObject;
import objectRepositoryUtility.*;

//@Listeners(generic.listenerUtility.ListenerImplementationClass.class)
public class CreateContactTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {

		// read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "data from Excel file");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandonNumber();

		//Step 2 : navigate to contact module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact module");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		//Step 3 : click on "Create Contact Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Contact Icon button");
		ContactCreatePage ccp = new ContactCreatePage(driver);
		ccp.getCreateContactIcon().click();

		// Step 4 : Enter all the details and Create new Contact
		UtilityClassObject.getTest().log(Status.INFO, "Create new Contact");
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.lastNameSavebt(lastName);

		// verifying Header Name & Last Name Excepted Result
		String actualHeader = cip.getVerifyHeaderMsg().getText();
		boolean status = actualHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actLastName = cip.getVerifyLastNameMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		
		
		
		// comment
	}
	
	
	@Test(groups = "regressionTest")
	public void createContactTestSupportDate() throws Throwable {
		
		// read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "data from Excel file");
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandonNumber();
		
		//Step 2 : navigate to contact module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact module");
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		//Step 3 : click on "Create Contact Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Contact Icon button");
		ContactCreatePage ccp = new ContactCreatePage(driver);
		ccp.getCreateContactIcon().click();

		// Step 4 : Enter all the details and Create new Contact with Support Date
		UtilityClassObject.getTest().log(Status.INFO, "Create new Contact with Support Date");
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getConatactLastName().sendKeys(lastName);
		String startDate = jlib.getSystemDateYYYYMMDD();
		String endDate = jlib.getRequiredDateYYYYMMDD(30);
		cip.getSupportStartDate().clear();
		cip.getSupportStartDate().sendKeys(startDate);
		cip.getSupportEndDate().clear();
		cip.getSupportEndDate().sendKeys(endDate);
		cip.getContactSavebtn().click();

		// verifying Header Name & Last Name Excepted Result
		String actualHeader = cip.getVerifyHeaderMsg().getText();
		boolean status = actualHeader.contains(actualHeader);
		Assert.assertEquals(status, true);
		
		String actLastName = cip.getVerifyLastNameMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, lastName);

		// verify Support Start & End Date Excepted Result
		String actStartDate = cip.getVerifySupportStartDate().getText();
		boolean ActualStartDate = actStartDate.contains(startDate);
		Assert.assertEquals(ActualStartDate, true);

		String actEndDate = cip.getVerifySupportEndDate().getText();
		boolean ActualEndDate = actEndDate.contains(endDate);
		Assert.assertEquals(ActualEndDate, true);
	}
	
	@Test(groups = {"smokeTest","regressionTest"})
	public void createContactWithOrgTest() throws Throwable {
		
		// read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "data from Excel file");
		
		String orgName = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandonNumber();
		String industry = elib.getDataFromExcel("org", 7, 3);
		String type = elib.getDataFromExcel("org", 7, 4);
		String descriptionInfo = elib.getDataFromExcel("org", 7, 6);
		String phoneNo = elib.getDataFromExcel("org", 7, 5);
		String contactLastName = elib.getDataFromExcel("contact", 7, 3);

		//Step 2 : navigate to Organization module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Organization module");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		//Step 3 : click on "Create Organization Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Organization Icon button");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationIcon().click();

		// Step 4 : Enter all the details and Create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create new Organization with Indutry and Phone no");
		CreateNewOrganizationPage cop = new CreateNewOrganizationPage(driver);
		cop.createOrgWithIndustryAndPhone(orgName, industry, type, descriptionInfo, phoneNo);

		// verify phoneNo info Excepted Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actPhoneNo = oip.getPhoneMsg().getText();
		boolean status = actPhoneNo.equals(phoneNo);
		Assert.assertEquals(status, true);

		//Step 2 : navigate to contact module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Contact module");
		hp.getContactsLink().click();

		//Step 3 : click on "Create Contact Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Contact Icon button");
		ContactCreatePage ccp = new ContactCreatePage(driver);
		ccp.getCreateContactIcon().click();

		// Step 4 : Enter all the details and Create new Contact with Support Date
		UtilityClassObject.getTest().log(Status.INFO, "Create new Contact with Support Date");
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.getConatactLastName().sendKeys(contactLastName);
		cip.getAddOrgNameBtn().click();

		// switch to child window
		wlib.swtichToTabOnUrl(driver, "module=Accounts&action");

		cip.getsearchTF().sendKeys(orgName);
		cip.getsearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to parent window
		wlib.swtichToTabOnUrl(driver, "Contacts&action");
		
		String startDate = jlib.getSystemDateYYYYMMDD();
		String endDate = jlib.getRequiredDateYYYYMMDD(30);
		cip.getSupportStartDate().clear();
		cip.getSupportStartDate().sendKeys(startDate);
		cip.getSupportEndDate().clear();
		cip.getSupportEndDate().sendKeys(endDate);
		cip.getContactSavebtn().click();

		// verifying Header Name & Last Name Excepted Result
		String actualHeader = cip.getVerifyHeaderMsg().getText();
		boolean status2 = actualHeader.contains(actualHeader);
		Assert.assertEquals(status2, true);
		
		String actLastName = cip.getVerifyLastNameMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actLastName, contactLastName);

		// verify Support Start & End Date Excepted Result
		String actStartDate = cip.getVerifySupportStartDate().getText();
		boolean ActualStartDate = actStartDate.contains(startDate);
		Assert.assertEquals(ActualStartDate, true);

		String actEndDate = cip.getVerifySupportEndDate().getText();
		boolean ActualEndDate = actEndDate.contains(endDate);
		Assert.assertEquals(ActualEndDate, true);

	}
	
}