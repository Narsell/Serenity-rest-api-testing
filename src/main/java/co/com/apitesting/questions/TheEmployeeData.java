package co.com.apitesting.questions;

import co.com.apitesting.model.Employee;
import co.com.apitesting.utils.JsonTo;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.apitesting.utils.Constants.SUCCESSFUL_STATUS_CODE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TheEmployeeData implements Question<Object> {
    private Employee expectedEmployee;

    public TheEmployeeData(Employee expectedEmployee) {
        this.expectedEmployee = expectedEmployee;
    }

    public static TheEmployeeData matches(Employee expectedEmployee) {
        return new TheEmployeeData(expectedEmployee);
    }

    @Override
    public Object answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        assertThat(response.getStatusCode(), equalTo(SUCCESSFUL_STATUS_CODE));
        Employee employee = JsonTo.employee(response);
        assertThat(employee, samePropertyValuesAs(expectedEmployee));
        return null;
    }
}
