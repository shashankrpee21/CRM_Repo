package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsCreatePage {

	WebDriver driver;
	
	public CampaignsCreatePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampaignNameTF;	
	
	public WebElement getCampaignNameTF() {
		return CampaignNameTF;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getCampaignSaveBtn() {
		return saveBtn;
	}

	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement  selectProduct;
	
	public WebElement getSelectProductBtn() {
		return selectProduct;
	}
	
	
	
}
