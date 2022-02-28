package co.com.apitesting.lulo.utils;

import co.com.apitesting.lulo.model.Employee;
import io.restassured.response.Response;
import org.apache.pdfbox.util.Matrix;

import java.util.Arrays;
import java.util.List;

public class JsonTo {
    public static Employee employee(Response json) {
        return new Employee(
                json.path("data.id"),
                json.path("data.employee_name").toString(),
                json.path("data.employee_salary"),
                json.path("data.employee_age"),
                json.path("data.profile_image").toString()
        );
    }

    public static List<Employee> employees(Response response) {

        List<Integer> idList = response.path("data.id");
        List<String> nameList = response.path("data.employee_name");
        List<Integer> salaryList = response.path("data.employee_salary");
        List<Integer> ageList = response.path("data.employee_age");
        List<String> profileImageList = response.path("data.profile_image");

        int size = idList.size();
        Employee[] employeeArray = new Employee[size];

        for (int i = 0; i < size; i++) {
            employeeArray[i] =
                    new Employee(
                            idList.get(i),
                            nameList.get(i),
                            salaryList.get(i),
                            ageList.get(i),
                            profileImageList.get(i)
                    );
        }

        return Arrays.asList(employeeArray);
    }
}
