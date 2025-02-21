package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsInfoPage {

	WebDriver driver;
	
	public ProductsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="lvtHeaderText")
	private WebElement ProductsHeaderMsg;

	public WebElement getProductsHeaderMsg() {
		return ProductsHeaderMsg;
	}
	
	@FindBy(id="dtlview_Product Name")
	private WebElement compareProductsHeaderMsg;

	public WebElement getVerifyProductsHeaderMsg() {
		return compareProductsHeaderMsg;
	}
	
	

}
