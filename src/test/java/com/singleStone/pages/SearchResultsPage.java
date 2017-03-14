package com.singleStone.pages;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.singleStone.utils.Base;

public class SearchResultsPage extends Base {

	public SearchResultsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[contains(text(),'repository results')]")
	public WebElement repositoryResults;
	
	@FindBy(xpath="//a[@href='/capitalone/Hygieia']")
	public WebElement capOneRepository;
	
	@FindBy(css="ul.numbers-summary li")
	public List<WebElement> headers;

	public boolean verifyResultsCount(int expectedCount) {
		try {
		   assertTrue("Repository Results NOT Displayed",repositoryResults.isDisplayed());
		}catch(Exception e) {
		   fail("Repository Results NOT Displayed");
		}
		
		String repoResultsFull=repositoryResults.getText();
		repoResultsFull=repoResultsFull.replace("We’ve found ", "");
		repoResultsFull=repoResultsFull.replace(" repository results", "");
		int repoResultsCount=Integer.valueOf(repoResultsFull);
		System.out.println(repoResultsCount);
		if(repoResultsCount >= expectedCount){
			return true;
		}
		   return false;
		
		
	}

}
