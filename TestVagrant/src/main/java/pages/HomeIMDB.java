package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeIMDB {
	WebDriver driver;
	@FindBy(xpath="//input[@type='text']")
	private WebElement search;
	@FindBy(xpath="(//a[text()='Pushpa: The Rise - Part 1'])[1]")
	private WebElement name;
	
	@FindBy(xpath="//span[text()='Details']")
	private WebElement details;
	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement releasedate;
	
	@FindBy(xpath="//a[text()='India']")
	private WebElement country;
	
	
	public HomeIMDB(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void search() throws InterruptedException
	{
		search.sendKeys("Pushpa: The Rise");
		search.sendKeys(Keys.ENTER);
	}
	public void ClickonName() throws InterruptedException
	{
		name.click();
	}
	public String getreleasedate()
	{
		String release=releasedate.getText();
		return release;
	}
	public String getCountry()
	{
		String country_new=country.getText();
		return country_new;
	}

}
