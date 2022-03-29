package co.com.apitesting.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class RemoveAnEmployee implements Task {
    private final String endpoint;

    public RemoveAnEmployee(String endpoint) {
        this.endpoint = endpoint;
    }

    public static RemoveAnEmployee with(String endpoint) {
        return Tasks.instrumented(RemoveAnEmployee.class, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(endpoint)
        );
    }
}
