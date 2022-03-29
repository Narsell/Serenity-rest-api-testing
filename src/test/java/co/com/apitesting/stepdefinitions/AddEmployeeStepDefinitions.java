package co.com.apitesting.stepdefinitions;

import co.com.apitesting.model.Employee;
import co.com.apitesting.tasks.AddANewRecord;
import io.cucumber.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AddEmployeeStepDefinitions {

    @When("the user attempts to add a new employee via the {string} endpoint")
    public void theUserAttemptsToAddANewEmployeeViaTheEndpoint(String endpoint, List<Employee> employeeToAdd) {
        theActorInTheSpotlight().attemptsTo(AddANewRecord.with(employeeToAdd.get(0), endpoint));
    }

}
