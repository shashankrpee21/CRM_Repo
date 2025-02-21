package objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.webDriverUtility.JavaUtility;

public class ContactInfoPage {
	
	WebDriver driver;
	
	JavaUtility jlib = new JavaUtility();
	
	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	public WebElement getConatactLastName() {
		return lastName;
	}
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement selectOrganizationName;
	
	public WebElement getselectOrganizationName() {
		return selectOrganizationName;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getContactSavebtn() {
		return saveBtn;
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement VerifyHeaderMsg;

	public WebElement getVerifyHeaderMsg() {
		return VerifyHeaderMsg;
	}
	
	@FindBy(xpath="//span[@id='dtlview_Last Name']")
	private WebElement VerifyLastNameMsg;

	public WebElement getVerifyLastNameMsg() {
		return VerifyLastNameMsg;
	}
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement AddOrgNameBtn;

	public WebElement getAddOrgNameBtn() {
		return AddOrgNameBtn;
	}
	
	@FindBy(name="support_start_date")
	private WebElement supportStartDate;
	
	@FindBy(name="support_end_date")
	private WebElement supportEndDate;
	
	public WebElement getSupportStartDate() {
		return supportStartDate;
	}

	public WebElement getSupportEndDate() {
		return supportEndDate;
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
	
	
	@FindBy(xpath ="//span[@id='dtlview_Support Start Date']")
	private WebElement VerifySupportStartDate;
	
	public WebElement getVerifySupportStartDate() {
		return VerifySupportStartDate;
	}
	
	@FindBy(xpath ="//span[@id='dtlview_Support End Date']")
	private WebElement VerifySupportEndDate;
	
	public WebElement getVerifySupportEndDate() {
		return VerifySupportEndDate;
	}
	
	@FindBy(xpath ="//span[@class='dvHeaderText']")
	private WebElement VerifyContactLastName;
	
	public WebElement getVerifyContactLastName() {
		return VerifyContactLastName;
	}

	@FindBy(id ="mouseArea_Organization Name")
	private WebElement VerifyOrganizationName;
	
	public WebElement getVerifyOrganizationName() {
		return VerifyOrganizationName;
	}
	
	public void lastNameSavebt(String lastname) {
		lastName.sendKeys(lastname);
		saveBtn.click();
	}
		
}
