package co.com.apitesting.questions;

import co.com.apitesting.model.Employee;
import co.com.apitesting.utils.JsonTo;
import co.com.apitesting.utils.RandomNumber;
import co.com.apitesting.utils.Constants;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.com.apitesting.utils.Constants.SUCCESSFUL_STATUS_CODE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import java.util.List;

public class TheListOfEmployees implements Question<Object>{
    private final List<Employee> expectedEmployees;
    private final String expectedResponseSize;

    private static final Logger logger = LogManager.getLogger(TheListOfEmployees.class);

    public TheListOfEmployees(List<Employee> expectedEmployees, String expectedResponseSize) {
        this.expectedEmployees = expectedEmployees;
        this.expectedResponseSize = expectedResponseSize;
    }

    public static TheListOfEmployees matches(List<Employee> employees, String responseSize) {
        return new TheListOfEmployees(employees, responseSize);
    }

    @Override
    public Object answeredBy(Actor actor) {

        Response response = SerenityRest.lastResponse();
        assertThat(response.getStatusCode(), equalTo(SUCCESSFUL_STATUS_CODE));
        List<Employee> employees = JsonTo.employees(response);
        int index = RandomNumber.getRandomNumber(0, expectedEmployees.size()-1);
        assertThat(employees.get(index), samePropertyValuesAs(expectedEmployees.get(index)));
        assertThat(employees.size(), equalTo(Integer.parseInt(expectedResponseSize)));
        return null;
    }
}
