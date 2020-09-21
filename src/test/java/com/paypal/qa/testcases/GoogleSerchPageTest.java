package com.paypal.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.paypal.qa.base.TestBase;
import com.paypal.qa.pages.GoogleSearchPage;

public class GoogleSerchPageTest extends TestBase{
	
	
	GoogleSearchPage googleSearchPage;
	
	public GoogleSerchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization(prop.getProperty("url"));
		googleSearchPage = new GoogleSearchPage();
	}
	
	@Test(priority = 1)
	@Parameters("stockComparisionValue")
	public void googleSearchTest(String stockComparisionValue) {
		
		googleSearchPage.searchPaypalStock(prop.getProperty("searchText"));
		
		String stockValue = googleSearchPage.validateStockValue();
		double value = Double.parseDouble(stockValue);	
		double compareValue = Double.parseDouble(stockComparisionValue);
		
		Assert.assertTrue(value > compareValue);
		 	System.out.println("The stock value of Paypal is more than 175 ");
	}
	
	  @AfterTest 
	  public void tearDown() { 
		  driver.close(); 
	  }
	 
	
	

}
