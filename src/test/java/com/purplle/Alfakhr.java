package com.purplle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class Alfakhr {


	private static final Class<? extends IRetryAnalyzer> Retryanalayzer = null;
	static WebDriver driver;
	   @DataProvider(name="product")
	   public Object[] dataName(){
			return new Object[] {"AL-FAKHR"};
	   }
	   
	   @BeforeClass(groups="two")
  
	   public void Enter_The_website1() {
		WebDriverManager.edgedriver().setup();
	    driver =new EdgeDriver(); 
		String url="https://www.purplle.com/";
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String Currenturl =driver.getCurrentUrl();
		if(Currenturl.startsWith(url)) {
			System.out.println("enter the website sucessful-2");
		}
		else 
		{
			System.out.println(" not enter the website");
		}    
	    
	   }
	   
		@Test (priority =-9,groups="two")
	    public void click_on_Brands() {
	    	WebElement brand =driver.findElement(By.xpath("//a[text()=' BRANDS ']"));
	    	brand.click();
	    	System.out.println("click on Brands");	      	 	
		}
		
		@Test (priority =-8,dataProvider ="product",groups="two")
	    public void click_on_Alfakhr(String name) {
	    	WebElement Alfakhr =driver.findElement(By.xpath("//span[text()='AL-FAKHR']"));
	    	String text =Alfakhr.getText();
	    	Alfakhr.click();
	    	SoftAssert soft =new SoftAssert();
	    	soft.assertEquals(text,"name"+"given value is not equal");
	    	soft.assertAll();
	    	  	
	    	if(text.equals("name")) {
	    	System.out.println("AL-FAKHR Squad clicked");    	}
	    	else {
	    		System.out.println("AL-FAKHR not clicked"); }
	    }    
		     @Test(priority =-7,groups="plus")
	      public void validate_on_Alfakhr() {
	        try {
	    	List<WebElement> tables1 =driver.findElements(By.xpath("//div[@class='product-title fs-7 text-start text-black fw-normal']"));
	        List<String>text= new ArrayList<String>();
	        text.add("AL-FAKHR Froua Al Oud Eau De Perfume for Men & Women 100 ml");
	        text.add("AL-FAKHR Ameer Al Oud Khususi Eau De Perfume for Men & Women 100 ml ");
	        text.add("AL-FAKHR Attar Al Layal Eau De Perfume for Men & Women 100 ml ");
	        text.add("AL-FAKHR Rahal I Eau De Perfume for Women 100 ml  ");
	        	        
	        for(int i=0;i<tables1.size();i++) {
	        WebElement able =tables1.get(i);
	        String actproductname =able.getText();
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


