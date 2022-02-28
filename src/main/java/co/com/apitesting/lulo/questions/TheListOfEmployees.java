package co.com.apitesting.lulo.questions;

import co.com.apitesting.lulo.model.Employee;
import co.com.apitesting.lulo.utils.RandomNumber;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static co.com.apitesting.lulo.utils.Constants.SUCCESSFUL_STATUS_CODE;

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

        /*
        List<Employee> users = response
                .jsonPath()
                .getList("data", Employee.class);
         */

        List<String> employeeNames = response.path("data.employee_name");
        int index = RandomNumber.getRandomNumber(0, expectedEmployees.size()-1);
        assertThat(employeeNames, hasItem(expectedEmployees.get(index).getName()));

        assertThat(employeeNames.size(), equalTo(Integer.parseInt(expectedResponseSize)));

        return null;
    }
}
