package co.com.apitesting.lulo.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class MakeAGetRequest implements Task {
    private final String endpoint;

    public MakeAGetRequest(String endpoint) {
        this.endpoint = endpoint;
    }

    public static MakeAGetRequest toThe(String endpoint) {
        return Tasks.instrumented(MakeAGetRequest.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(endpoint));
    }
}
