package co.com.apitesting.lulo.stepdefinitions;

import co.com.apitesting.lulo.model.Employee;
import co.com.apitesting.lulo.questions.TheEmployeeWasAdded;
import co.com.apitesting.lulo.tasks.AddANewRecord;
import co.com.apitesting.lulo.questions.TheEmployeeData;
import co.com.apitesting.lulo.questions.TheListOfEmployees;
import co.com.apitesting.lulo.tasks.MakeAGetRequest;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class ApiTestingStepDefinitions {
    private EnvironmentVariables environmentVariables;

    @DataTableType(replaceWithEmptyString = "[blank]")
    public Employee convert(Map<String, String> entry){
        return new Employee(
            Integer.parseInt(entry.get("id")),
            entry.get("name"),
            Integer.parseInt(entry.get("salary")),
            Integer.parseInt(entry.get("age")),
            entry.get("profile image")
        );
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        String apiBaseUrl = environmentVariables.optionalProperty("restapi.baseurl")
                .orElse("http://dummy.restapiexample.com/api/v1");
        theActorCalled("Daniel").whoCan(CallAnApi.at(apiBaseUrl));
    }

    @Given("that the user meets the requirements to make request to API")
    public void thatTheUserMeetsTheRequirementsToMakeRequestToAPI() {
        theActorInTheSpotlight().wasAbleTo();
    }

    @When("the user sends a request via GET to the endpoint {string}")
    public void theUserSendsARequestViaGETtoTheEndpoint(String endpoint) {
        theActorInTheSpotlight().attemptsTo(MakeAGetRequest.toThe(endpoint));
    }

    @Then("the user should get the data of {string} employees")
    public void theUserShouldGeTheDataOfEmployees(String expectedResponseSize, List<Employee> expectedEmployees) {
        theActorInTheSpotlight().should(seeThat(TheListOfEmployees.matches(expectedEmployees, expectedResponseSize)));
    }

    @Then("the user should get the data of one single employee")
    public void theUserShouldGetTheDataOfOneSingleEmployee(List<Employee> expectedEmployee) {
        theActorInTheSpotlight().should(seeThat(TheEmployeeData.matches(expectedEmployee.get(0))));

    }

    @When("the user sends a request via POST to the endpoint {string}")
    public void theUserSendsARequestViaPOSTToTheEndpoint(String endpoint, List<Employee> employeeToAdd) {
        theActorInTheSpotlight().attemptsTo(AddANewRecord.with(employeeToAdd.get(0), endpoint));
    }

    @Then("the user should be able to verify the data was added successfully")
    public void theUserShouldBeAbleToVerifyTheDataWasAddedSuccessfully(Map<String, List<String>> successfulMessage) {
        theActorInTheSpotlight().should(seeThat(TheEmployeeWasAdded.successfully(successfulMessage)));
    }
}
