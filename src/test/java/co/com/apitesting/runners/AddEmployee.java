package co.com.apitesting.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static co.com.apitesting.utils.Constants.STEPDEFINITIONS_PATH;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/add_employee.feature",
        tags = "@add-one-employee",
        glue = STEPDEFINITIONS_PATH,
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class AddEmployee {
}
