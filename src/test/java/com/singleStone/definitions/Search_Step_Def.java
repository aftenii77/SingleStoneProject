package com.singleStone.definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSpinnerUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.singleStone.pages.HomePage;
import com.singleStone.pages.SearchResultsPage;
import com.singleStone.utils.Base;
import com.singleStone.utils.Config;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;

public class Search_Step_Def extends Base{
	//Second commit
	
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	@Given("^User is on GitHub home page$")
	public void User_is_on_GitHub_home_page() throws Throwable {
		driver.get(Config.getProperty("url"));
		homePage = new HomePage(driver);
	}
	

	@When("^User enters \"([^\"]*)\" in the search input box$")
	public void I_should_enter_in_the_search_input_box(String searchItem) throws Throwable {
		homePage.searchBox.sendKeys(searchItem + Keys.ENTER);
	 
	}
	
	@Then("^User should see \"([^\"]*)\" or more number of repos$")
	public void User_should_see_or_more_number_of_repos(int count) throws Throwable {
		searchResultsPage=new SearchResultsPage(driver);
		assertTrue(searchResultsPage.verifyResultsCount(count));
		
	}
	
	@Then("^User selects CapitalOne/Hygieia repository$")
	public void User_should_select_CapitalOne_Hygieia_repository() throws Throwable {
		searchResultsPage.capOneRepository.click();
	}
	
	@Then("^User should see following headers with following counts:$")
	public void User_should_see_following_headers(Map<String,Integer> headers) throws Throwable {
		int actualCommitsCount=0;
		int actualNumBranches = 0;
	    int actualNumRealeases = 0;
	    int actualNumContributors = 0;
		for(WebElement header : searchResultsPage.headers){
			String text=header.getText();
			String[] arrText=text.split(" ");
			
			if(arrText.length < 2)
				continue;
			
			switch(arrText[1].trim()){
				case "commits":
					actualCommitsCount=Integer.valueOf(arrText[0].replace(",", ""));
					break;
				case "branches":
					actualNumBranches=Integer.valueOf(arrText[0].replace(",", ""));
					break;
				case "releases":
					actualNumRealeases=Integer.valueOf(arrText[0].replace(",", ""));
					break;
				case "contributors":
					actualNumContributors=Integer.valueOf(arrText[0].replace(",", ""));
					break;
			}
		}
		
		//System.out.println(actualCommitsCount+" "+actualNumBranches+" "+actualNumRealeases+" "+actualNumContributors);
  
	    assertTrue(actualCommitsCount>=headers.get("commits"));
	    assertTrue(actualNumBranches>=headers.get("branches"));
	    assertTrue(actualNumRealeases>=headers.get("releases"));
	    assertTrue(actualNumContributors>=headers.get("contributors"));
	
	}

	
}

	


	
	

