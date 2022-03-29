package co.com.apitesting.questions;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class TheApiResponse implements Question<Object> {
    private Map<String, List<String>> expectedMessage;
    private String expectedStatusCode;

    public TheApiResponse(String expectedStatusCode, Map<String, List<String>> expectedMessage) {
        this.expectedStatusCode = expectedStatusCode;
        this.expectedMessage = expectedMessage;
    }

    public static TheApiResponse matches(String expectedStatusCode, Map<String, List<String>> expectedMessage) {
        return new TheApiResponse(expectedStatusCode, expectedMessage);
    }

    @Override
    public Object answeredBy(Actor actor) {
        Response response = SerenityRest.lastResponse();
        assertThat(response.getStatusCode(), equalTo(Integer.parseInt(expectedStatusCode)));
        String expectedMessage = this.expectedMessage.get("message").get(0);
        String message = response.path("message");
        assertThat(message, equalTo(expectedMessage));
        return null;
    }
}
