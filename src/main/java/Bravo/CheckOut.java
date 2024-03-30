package Bravo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ResuableComponent.AbstractComponent;

public class CheckOut extends AbstractComponent  {

	WebDriver driver;
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy(css=".action__submit")
	WebElement submit;
	
// 	driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
//	a.sendKeys(driver.findElement(By.xpath("//*[@placeholder='Select Country']")), "india").build().perform();
	@FindBy(xpath="//*[@placeholder='Select Country']")
	WebElement country;
	
	By result = By.cssSelector(".ta-results ");
	
	
	public void SelectCountry(String CountryName) {
		Actions a= new Actions(driver);
		a.sendKeys(country, CountryName).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
	}
	
	public ConfirmationPage SubmitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
