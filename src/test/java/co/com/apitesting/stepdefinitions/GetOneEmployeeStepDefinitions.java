package co.com.apitesting.stepdefinitions;

import co.com.apitesting.model.Employee;
import co.com.apitesting.questions.TheEmployeeData;
import io.cucumber.java.en.Then;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetOneEmployeeStepDefinitions {
    @Then("the user should get the data of one single employee")
    public void theUserShouldGetTheDataOfOneSingleEmployee(List<Employee> expectedEmployee) {
        theActorInTheSpotlight().should(seeThat(TheEmployeeData.matches(expectedEmployee.get(0))));

    }
}
