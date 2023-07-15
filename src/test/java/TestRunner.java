import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.Employee;

import java.io.IOException;


class TestRunner {


    @Test
    public void AgetRequest() throws Exception {
        int id = 10;
        HttpMethods Getrequest = new HttpMethods();
        Employee Getemployee = Getrequest.getRequest(id);

        Assertions.assertEquals(id, Getemployee.getData().getId());

    }

    @Test

    public void BpostRequest() throws IOException {

        String employeeName="Ahmed";
        int salary=5000;
        int age = 30;
        HttpMethods request = new HttpMethods();

        Employee employee = request.postRequest(employeeName,salary,age);
        Assertions.assertEquals(employeeName, employee.getData().getEmployee_name());
        Assertions.assertEquals(salary, employee.getData().getEmployee_salary());
        Assertions.assertEquals(age, employee.getData().getEmployee_age());

    }

}