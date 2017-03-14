package com.singleStone;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
//@CucumberOptions(dryRun=true)
@CucumberOptions(plugin={"pretty","html:target/html"},
                   tags={"@Test"},features="src/test/resources/com/singleStone/features")

public class Runner {

}
