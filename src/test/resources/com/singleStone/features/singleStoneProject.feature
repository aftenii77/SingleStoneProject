@Test
Feature: SingleStone Test

Background: 
   Given User is on GitHub home page
   
@Test
Scenario Outline: The user should search for "hygieia"
   When User enters "<searchingItem>" in the search input box
   Then User should see "<count>" or more number of repos
   And  User selects CapitalOne/Hygieia repository
   Then User should see following headers with following counts:
	   |commits     |1000|
	   |branches    |4   |
	   |releases    |8   | 
	   |contributors|48  |
   Examples:
       |searchingItem|count|
       |hygieia      |  3  |
                              