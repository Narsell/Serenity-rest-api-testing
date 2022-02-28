package co.com.apitesting.lulo.questions;

import co.com.apitesting.lulo.model.Employee;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.apitesting.lulo.utils.Constants.SUCCESSFUL_STATUS_CODE;
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

        String employeeName = response.path("data.employee_name");
        assertThat(employeeName, equalTo(expectedEmployee.getName()));

        return null;
    }
}
