# SingleStoneProject
Automation Task

In order to complete this task, I used management and test tools like Eclipse IDE, Selenium WebDriver, Cucumber and Maven.
I followed the Page Object Model structure so I created two separate java classes for my home page and search result page.
Inside my pom.xml file I have stored all necessary dependencies.
Also, there is a runner class that kicks in my test and generates html reports. I used "features" in order to be able to point to my 
cucmber future files. By doing that, my runner class can be located on the same level with the rest of the packages/classes. It doesn't have
to be all the way on top.
I have my driver inside "Base" java class. The driver is declared as protected static so I can access it from different packages. The rest
of the java classes extend the "Base" class. Inside my "Hooks" java class I used @Before and @After annotations. Under @Before I have the
driver set up together with the implicitlyWait() method and pageLoadTimeout() that helps me with the synchronization. Under @After I have
my close() method that closes my browser after the execution.
There is antother folder called "drivers", inside this folder I'm storing the chromedriver. I used chrome browser to run my test.
I also created a "testdata" folder which contains "configuration.properties" file. Inside this file I stored the driverPath and the url.

Inside "SearchResultsPage" I've also created a function that captures and verifies the number of repos. By doing that I can proceed and 
perform the comparison. 

Another thing I would like to menssion about last verification step is that if I write my condition that number of branches is grater 
than 4, my test will fail since the number of branches is exactly 4. So in order to make it pass I wrote my condition as number of 
branches is grater or equals to 4.




