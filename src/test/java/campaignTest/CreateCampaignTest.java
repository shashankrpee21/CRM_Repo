package campaignTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import generic.baseTest.BaseClass;
import generic.webDriverUtility.UtilityClassObject;
import objectRepositoryUtility.*;


@Listeners(generic.listenerUtility.ListenerImplementationClass.class)
public class CreateCampaignTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createCampaignTest() throws Throwable {

		// read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "data from Excel file");
		String CampaignName = elib.getDataFromExcel("campaign", 1, 1) + jlib.getRandonNumber();

		//Step 2 : navigate to Campaigns module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Campaigns module");
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		hp.getCampaignsLink().click();

		//Step 3 : click on "Create Campaigns Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Campaigns Icon button");
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignsIcon().click();

		// Step 4 : Enter all the details and Create new Campaigns
		UtilityClassObject.getTest().log(Status.INFO, "Create new Campaigns");
		CampaignsCreatePage ccp = new CampaignsCreatePage(driver);
		ccp.getCampaignNameTF().sendKeys(CampaignName);
		ccp.getCampaignSaveBtn().click();

		//Verifying Campaigns Header Info and Campaigns Name
		CampaignsInfoPage cip = new CampaignsInfoPage(driver);		
		String actualCampaignHeaderInfo = cip.getCampaignHeaderMsg().getText();
		boolean VerifyCampaignHeaderInfo = actualCampaignHeaderInfo.contains(CampaignName);
		Assert.assertEquals(VerifyCampaignHeaderInfo, true);
		
		String actualCampaignName= cip.getVerifyCampaignNameMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualCampaignName, CampaignName);
	}

	@Test(groups = "regressionTest")
	public void createCampaignWithProductTest() throws Throwable {

		// read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "data from Excel file");
		String CampaignName = elib.getDataFromExcel("campaign", 1, 1) + jlib.getRandonNumber();
		String ProductsName = elib.getDataFromExcel("products", 1, 1) + jlib.getRandonNumber();

		//Step 2 : navigate to Product module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Product module");
		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		//Step 3 : click on "Create Products Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Products Icon button");
		ProductsPage pp = new ProductsPage(driver);
		pp.getCreateProductsIcon().click();

		// Step 4 : Enter all the details and Create new Products
		UtilityClassObject.getTest().log(Status.INFO, "Create new Products");
		ProductsCreatePage pcp = new ProductsCreatePage(driver);
		pcp.getProductNameTF().sendKeys(ProductsName);
		pcp.getProductSaveBtn().click();

		//Verifying Product Header Info and Product Name
		ProductsInfoPage pip = new ProductsInfoPage(driver);
		String ProductHeaderInfo = pip.getVerifyProductsHeaderMsg().getText();
		boolean VerifyactualProductsName = ProductHeaderInfo.contains(ProductsName);
		Assert.assertEquals(VerifyactualProductsName, true);

		//Step 5 : navigate to Campaigns module 
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Campaigns module");
		hp.getMoreLink().click();
		hp.getCampaignsLink().click();

		//Step 6 : click on "Create Campaigns Icon" button
		UtilityClassObject.getTest().log(Status.INFO, "Create Campaigns Icon button");
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignsIcon().click();
		
		// Step 7 : Enter all the details and Create new Campaigns
		UtilityClassObject.getTest().log(Status.INFO, "Create new Campaigns");
		CampaignsCreatePage ccp = new CampaignsCreatePage(driver);
		ccp.getCampaignNameTF().sendKeys(CampaignName);
		
		// Step 8 : In Campaigns and add a Product
		UtilityClassObject.getTest().log(Status.INFO, "In Campaigns and add a Product");
		CampaignsInfoPage cip = new CampaignsInfoPage(driver);
		cip.getAddProductBtn().click();

		// switch to child window
		wlib.swtichToTabOnUrl(driver, "module=Products&action");

		cip.getsearchTF().sendKeys(ProductsName);
		cip.getsearchBtn().click();
		driver.findElement(By.xpath("//a[text()='" + ProductsName + "']")).click();

		// switch to parent window
		wlib.swtichToTabOnUrl(driver, "module=Campaigns&action");
		ccp.getCampaignSaveBtn().click();
		
		//Verifying Campaigns Header Info and Campaigns Name
		String actualCampaignHeaderInfo = cip.getCampaignHeaderMsg().getText();
		boolean VerifyCampaignHeaderInfo = actualCampaignHeaderInfo.contains(CampaignName);
		Assert.assertEquals(VerifyCampaignHeaderInfo, true);
		
		String actualCampaignName= cip.getVerifyCampaignNameMsg().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualCampaignName, CampaignName);
	}
}
