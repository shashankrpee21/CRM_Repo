package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsCreatePage {

	WebDriver driver;
	
	public ProductsCreatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='productname']")
	private WebElement ProductNameTF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getProductNameTF() {
		return ProductNameTF;
	}
	
	public WebElement getProductSaveBtn() {
		return saveBtn;
	}
}
