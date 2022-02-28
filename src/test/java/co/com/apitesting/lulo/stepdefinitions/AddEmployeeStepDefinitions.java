package co.com.apitesting.lulo.stepdefinitions;

import co.com.apitesting.lulo.model.Employee;
import co.com.apitesting.lulo.questions.TheEmployeeWasAdded;
import co.com.apitesting.lulo.tasks.AddANewRecord;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddEmployeeStepDefinitions {

    @When("the user sends a request via POST to the endpoint {string}")
    public void theUserSendsARequestViaPOSTToTheEndpoint(String endpoint, List<Employee> employeeToAdd) {
        theActorInTheSpotlight().attemptsTo(AddANewRecord.with(employeeToAdd.get(0), endpoint));
    }

    @Then("the user should be able to verify the employee was added successfully")
    public void theUserShouldBeAbleToVerifyTheEmployeeWasAddedSuccessfully(Map<String, List<String>> successfulMessage) {
        theActorInTheSpotlight().should(seeThat(TheEmployeeWasAdded.successfully(successfulMessage)));
    }
}
