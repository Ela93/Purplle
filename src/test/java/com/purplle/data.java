package com.purplle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;


@Test

   public class data {
   
//static WebDriver driver;
//@DataProvider(name="product")
//   public Object[] dataName(){
//		return new Object[] {"Acne Squad"};
//   }
   
@BeforeClass
public void beforeclass() {
	   System.out.println("before Class");
}
@Parameters({"browser"})
public static void setUp(@Optional("Chorme") String arg) {
	   if(arg.equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver =new ChromeDriver();
		   System.out.println("Chrome browser");
	   }
	   
	   {  if (arg.equalsIgnoreCase("Edge")) 
    	   WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	    System.out.println("edge browser");
	   }}
 @BeforeMethod
   public void before() {
	   System.out.println("before method");
   }
   
   @AfterMethod
   public void after() {
	   System.out.println("after method");
   }
   
   
    
   @Test(priority= -10)
	public static void Enter_the_website() {
	WebDriverManager.edgedriver().setup();
    driver =new EdgeDriver(); 
	String url="https://www.purplle.com/";
	driver.manage().window().maximize();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	String Currenturl =driver.getCurrentUrl();
	if(Currenturl.startsWith(url)) {
		System.out.println("enter the website sucessful-1");
	}
	else 
	{
		System.out.println(" not enter the website");
	}  
	}   @AfterClass  
	    public void close_the_Application() {
		System.out.println("After class");
		driver.manage().window().fullscreen();
	}
		
	@Test(priority = -9)
	public void click_on_Brands() {
	try {
	        WebElement brand = driver.findElement(By.xpath("//a[text()=' BRANDS ']"));
	        brand.click();
	        System.out.println("Clicked on Brands");
	        } 
	   catch (NoSuchElementException e1) {
	   }     
	 catch (Exception e1) {
	   
	     
	    }
	    }
	
	@Test (priority =-8)
    public void click_on_AcneSquad(String name) {
    	WebElement ance =driver.findElement(By.xpath("//span[text()='Acne Squad']"));
    	String text =ance.getText();
    	ance.click();
    	SoftAssert soft =new SoftAssert();
    	soft.assertEquals(text,"name"+"given value is not equal");
    	soft.assertAll();
    	  	
    	if(text.equals("name")) {
    	System.out.println("Acne Squad clicked");    	}
    	else {
    		System.out.println("AcneSquad not clicked"); }
    }    
	           
      @Test(priority =-7)
      public void validate_on_AcneSquad() {
        try {
    	List<WebElement> tables =driver.findElements(By.xpath("//div[@class='pb-1 mb-1 fs-7 text-start text-black lh-base truncate-2-lines']"));
        List<String>text= new ArrayList<String>();
        text.add(" Acne Squad Serum for Acne Scars with Triple Concentrate Formula ");
        text.add(" Acne Squad Pore Minimising Super Shield Serum Jelly with 10% Niacinamide 30ml ");
        text.add(" Acne Squad Breakout Terminator Back & Body Spray with 2% Salicylic Acid & Glycolic Acid 100 ml ");
        text.add(" Acne Squad Serum for Acne Scars with Triple Concentrate Formula ");
        text.add(" Acne Squad Pore Minimising Super Shield Serum Jelly with 10% Niacinamide 30ml ");
        
        for(int i=0;i<tables.size();i++) {
        WebElement table =tables.get(i);
        String actproductname =table.getText();
        String expproductname =text.get(i);
        if(actproductname.equals(expproductname)) {
        	System.out.println(" actual Company and expected Company is matched :"+actproductname +" and Expect Company name" + expproductname);
                }
        else {                                                
        	System.out.println(" actual Company and expected Company is not matched :"+actproductname +" and Expect Company name" + expproductname);
        } 
        }
        }catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());

        }        }

}

    
    


