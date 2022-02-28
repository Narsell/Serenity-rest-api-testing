package co.com.apitesting.lulo.questions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

import static co.com.apitesting.lulo.utils.Constants.SUCCESSFUL_STATUS_CODE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TheEmployeeWasAdded implements Question<Object> {
    private final Map<String, List<String>> successfulMessage;

    public TheEmployeeWasAdded(Map<String, List<String>> successfulMessage) {
        this.successfulMessage = successfulMessage;
    }

    public static TheEmployeeWasAdded successfully(Map<String, List<String>> successfulMessage) {
        return new TheEmployeeWasAdded(successfulMessage);
    }

    @Override
    public Object answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        assertThat(response.getStatusCode(), equalTo(SUCCESSFUL_STATUS_CODE));
        String successfulMessage = this.successfulMessage.get("successfulMessage").get(0);
        String message = response.path("message");
        assertThat(message, equalTo(successfulMessage));
        System.out.println(response.prettyPrint());

        return null;
    }
}
