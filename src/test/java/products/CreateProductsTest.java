package products;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import generic.baseTest.BaseClass;
import generic.webDriverUtility.UtilityClassObject;
import objectRepositoryUtility.*;


//@Listeners(com.comcast.crm.generic.listenerUtility.ListenerImplementationClass.class)
public class CreateProductsTest extends BaseClass{

	@Test(groups = {"smokeTest","regressionTest"})
	public void createProductsTest() throws Throwable {

		// read testScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "data from Excel file");
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
		boolean VerifyProductHeaderInfo = ProductHeaderInfo.contains(ProductsName);
		Assert.assertEquals(VerifyProductHeaderInfo, true);

		String actualProductsName = pip.getVerifyProductsHeaderMsg().getText();
		boolean VerifyactualProductsName = actualProductsName.equals(ProductsName);
		Assert.assertEquals(VerifyactualProductsName, true);
	}
}
