package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement compareOrgNameMsg;

	public WebElement getVerifyOrgNameMsg() {
		return compareOrgNameMsg;
	}
	
	
	@FindBy(id="dtlview_Industry")
	private WebElement IndutryMsg;

	public WebElement getIndutryMsg() {
		return IndutryMsg;
	}
	
	@FindBy(id="dtlview_Type")
	private WebElement TypeMsg;

	public WebElement getTypeMsg() {
		return TypeMsg;
	}
	
	@FindBy(id="dtlview_Phone")
	private WebElement PhoneMsg;

	public WebElement getPhoneMsg() {
		return PhoneMsg;
	}
	
}
