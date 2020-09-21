package com.paypal.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.paypal.qa.base.TestBase;

public class GoogleSearchPage extends TestBase{
	
	@CacheLookup
	@FindBy(name="q")
	WebElement searchBox;
	
	@CacheLookup
	@FindBy(name="btnK")  
	WebElement searchBtn;
	
	@CacheLookup
	@FindBy(xpath="//span[@class='IsqQVc NprOob XcVN5d']")
	WebElement stockValue;
	
	public GoogleSearchPage() {
		PageFactory.initElements(driver, this);
	}
	public void searchPaypalStock(String searchText) {
		/*
		 * searchBox.clear(); searchBox.sendKeys(searchText); searchBtn.click();
		 */
		
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(searchBox)).clear();
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(searchBox)).sendKeys(searchText);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(searchBtn)).click();
	}
	
	public String validateStockValue() {
		return stockValue.getText();
	}

}
