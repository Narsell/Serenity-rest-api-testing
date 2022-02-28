package co.com.apitesting.lulo.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/get_one_employee.feature",
        tags = "@get-one-employee",
        glue = "co.com.apitesting.lulo.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class GetOneEmployee {
}