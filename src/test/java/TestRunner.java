import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pojo.Employee;

import java.io.IOException;


class TestRunner {

    @Test
    public void getRequest() throws Exception {
        int id = 1;
        HttpMethods getRequest = new HttpMethods();
        Employee employee = getRequest.getRequest(id);

        if (employee.getStatus().contains("success")) {
            System.out.println("The Request is : " + employee.getStatus());
            Assertions.assertEquals(id, employee.getData().getId());
        } else {
            System.out.println("The Request is Unsuccess:" + employee.getStatus());
        }
    }

    @Test

    public void postRequest() throws IOException, InterruptedException {

        String employeeName = "Ahmed";
        int salary = 5000;
        int age = 30;
        HttpMethods request = new HttpMethods();

        Employee employee = request.postRequest(employeeName, salary, age);

        if (employee.getStatus().contains("success")) {
            System.out.println("The Request is : " + employee.getStatus());
            Assertions.assertEquals(employeeName, employee.getData().getEmployee_name());
            Assertions.assertEquals(salary, employee.getData().getEmployee_salary());
            Assertions.assertEquals(age, employee.getData().getEmployee_age());

        } else {
            System.out.println("The Request is Unsuccess:" + employee.getStatus());

        }

        /* The waiting Time for the next request needs a minute to be executed or we got too many request in the response
            this issue happens while manual testing as well
        * */
        Thread.sleep(60000);

    }

}