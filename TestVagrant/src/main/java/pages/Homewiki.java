package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homewiki {
	WebDriver driver;
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;
	@FindBy(xpath="(//a[@title=\"Pushpa: The Rise\"])[2]")
	private WebElement name;
	
	
	@FindBy(xpath="(//div[@class='plainlist'])[4]")
	private WebElement releasedate;
	
	@FindBy(xpath="//td[text()='India']")
	private WebElement country;
	
	
	public Homewiki(WebDriver driver)
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
