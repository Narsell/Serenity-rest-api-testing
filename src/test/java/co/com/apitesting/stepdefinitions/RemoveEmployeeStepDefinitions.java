package co.com.apitesting.stepdefinitions;

import co.com.apitesting.tasks.RemoveAnEmployee;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RemoveEmployeeStepDefinitions {

    @When("the user attempts to delete an employee via the {string} endpoint")
    public void theUserAttemptsToDeleteAnEmployeeViaTheEndpoint(String endpoint) {
        theActorInTheSpotlight().attemptsTo(RemoveAnEmployee.with(endpoint));
    }

}
