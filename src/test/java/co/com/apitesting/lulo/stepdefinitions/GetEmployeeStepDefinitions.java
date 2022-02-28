package co.com.apitesting.lulo.stepdefinitions;

import co.com.apitesting.lulo.model.Employee;
import co.com.apitesting.lulo.questions.TheEmployeeData;
import io.cucumber.java.en.Then;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetEmployeeStepDefinitions {
    @Then("the user should get the data of one single employee")
    public void theUserShouldGetTheDataOfOneSingleEmployee(List<Employee> expectedEmployee) {
        theActorInTheSpotlight().should(seeThat(TheEmployeeData.matches(expectedEmployee.get(0))));

    }
}
