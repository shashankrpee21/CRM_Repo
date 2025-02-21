package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.webDriverUtility.WebDriverUtility;

public class CreateNewOrganizationPage {

	WebDriver driver;
		
	WebDriverUtility wlib = new WebDriverUtility();
	
	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement organizationNameTF;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDD;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDD;
	
	@FindBy(id = "phone")
	private WebElement phoneTF;
	
	@FindBy(name = "description")
	private WebElement descriptionTA;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement verfiyOrgTitle;
	
	public WebElement getOrganizationNameTxt() {
		return organizationNameTF;
	}

	public WebElement getIndustryDD() {
		return industryDD;
	}

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getPhoneTxt() {
		return phoneTF;
	}

	public WebElement getDescriptionTA() {
		return descriptionTA;
	}
	public WebElement getSaveBt() {
		return saveBtn;
	}
	
	public WebElement getVerfiyOrgTitle() {
		return verfiyOrgTitle;
	}

	public void verfiyOrgTitle() {
		verfiyOrgTitle.getText();
	}
	
 
	public void createOrg(String orgName, String description) {
		organizationNameTF.sendKeys(orgName);
		descriptionTA.sendKeys(description);
		saveBtn.click();
	}
	
	public void createOrgWithIndustry(String orgName, String pIndustry, String type, String description) {
		organizationNameTF.sendKeys(orgName);
		wlib.select(getIndustryDD(), pIndustry);
		wlib.select(getTypeDD(), type);
		descriptionTA.sendKeys(description);		
		saveBtn.click();
	}
	
	public void createOrgWithIndustryAndPhone(String orgName, String pIndustry, String type, String description, String phone) {
		organizationNameTF.sendKeys(orgName);
		wlib.select(getIndustryDD(), pIndustry);
		wlib.select(getTypeDD(), type);
		descriptionTA.sendKeys(description);	
		phoneTF.sendKeys(phone);
		saveBtn.click();
	}
	
	
	

}