package co.com.apitesting.stepdefinitions;

import co.com.apitesting.model.Employee;
import co.com.apitesting.questions.TheListOfEmployees;
import io.cucumber.java.en.Then;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetEmployeesStepDefinitions {

    @Then("the user should get the data of {string} employees")
    public void theUserShouldGeTheDataOfEmployees(String expectedResponseSize, List<Employee> expectedEmployees) {
        theActorInTheSpotlight().should(seeThat(TheListOfEmployees.matches(expectedEmployees, expectedResponseSize)));
    }

}
