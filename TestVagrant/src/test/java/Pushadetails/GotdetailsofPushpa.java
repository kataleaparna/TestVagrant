package Pushadetails;

import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomeIMDB;
import pages.Homewiki;
import utility.BrowserUtility;

public class GotdetailsofPushpa {
	WebDriver driver;
	String imdb_realeasedate;
	String imdb_country;
	String wiki_realeasedate;
	String wiki_country;
	@Parameters("browser")
	@BeforeClass
	 public void launchbrowser(String browsername)
		 {
		 if(browsername.equals("chrome"))
		 {
			 driver=BrowserUtility.chromebrowser();
		 }
		}
	@Test(priority = 1)
	public void fetchdatafromIMDB() throws InterruptedException
	{
		driver.get("https://www.imdb.com/");
		HomeIMDB homeIMDB=new HomeIMDB(driver);
		homeIMDB.search();
		homeIMDB.ClickonName();
		 imdb_realeasedate=homeIMDB.getreleasedate();
		 imdb_country=homeIMDB.getCountry();
	}
	
	@Test(priority = 2)
	public void fetchdatafromwiki() throws InterruptedException
	{
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
		Homewiki homewiki=new Homewiki(driver);
		homewiki.search();
		homewiki.ClickonName();
		wiki_realeasedate=homewiki.getreleasedate();
		wiki_country=homewiki.getCountry();
	}
	
	@Test(priority = 3)
	public void comparedetails() throws ParseException
	{
		String newrelaese=imdb_realeasedate.substring(0,17);
		String release_date=newrelaese.substring(9,11)+" "+newrelaese.substring(0,9)+newrelaese.substring(13,17);
		System.out.println("Details from wiki"+" "+wiki_realeasedate+ " "+wiki_country);
		System.out.println("Details from IMDB"+" "+release_date+" "+imdb_country);
		Assert.assertEquals(imdb_country, wiki_country);
		Assert.assertEquals(release_date, wiki_realeasedate);
		System.out.println("Compare both");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//driver.close();
	}

}
