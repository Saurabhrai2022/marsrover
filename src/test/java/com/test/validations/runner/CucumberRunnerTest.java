package com.test.validations.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@SmokeTest",
        dryRun = false,
        features = "src/test/resources/features",
        glue = "com.test.validations.definitions")

public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

}
