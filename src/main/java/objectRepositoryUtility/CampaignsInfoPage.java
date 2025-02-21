package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage {

	WebDriver driver;
	
	public CampaignsInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement CampaignHeaderMsg;

	public WebElement getCampaignHeaderMsg() {
		return CampaignHeaderMsg;
	}
	
	@FindBy(id="dtlview_Campaign Name")
	private WebElement compareCampaignNameMsg;

	public WebElement getVerifyCampaignNameMsg() {
		return compareCampaignNameMsg;
	}
	
	@FindBy(xpath = "//input[@name='product_name']/following-sibling::img[@title='Select']")
	private WebElement getAddProductBtn;
	
	public WebElement getAddProductBtn() {
		return getAddProductBtn;
	}

	@FindBy(id="search_txt")
	private WebElement searchTF;
	
	public WebElement getsearchTF() {
		return searchTF;
	}
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	public WebElement getsearchBtn() {
		return searchBtn;
	}
	

}
