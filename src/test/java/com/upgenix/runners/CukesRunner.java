package com.upgenix.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"

        },
        features = "src/test/resources/features",
        glue = "com/upgenix/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = false
)
public class CukesRunner {
}

