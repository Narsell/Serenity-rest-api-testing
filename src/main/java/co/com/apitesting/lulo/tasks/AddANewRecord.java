package co.com.apitesting.lulo.tasks;

import co.com.apitesting.lulo.model.Employee;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class AddANewRecord implements Task {
    private Employee employeeToAdd;
    private String endpoint;

    public AddANewRecord(Employee employeeToAdd, String endpoint) {
        this.employeeToAdd = employeeToAdd;
        this.endpoint = endpoint;
    }

    public static AddANewRecord with(Employee employeeToAdd, String endpoint) {
        return Tasks.instrumented(AddANewRecord.class, employeeToAdd, endpoint);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Headers headers = new Headers(
                new Header("Content-Type", "application/json"),
                new Header("Accept", "*/*"),
                new Header("Accept-Encoding", "gzip, deflate, br"),
                new Header("Connection", "keep-alive")
        );
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(
                                request -> request.headers(headers)
                                        .body("{\n" +
                                                "    \"name\":"+ employeeToAdd.getName() +",\n" +
                                                "    \"salary\":"+ employeeToAdd.getSalary() +",\n" +
                                                "    \"age\""+ employeeToAdd.getAge() +"\n" +
                                                "}")
                        )
        );
    }
}
