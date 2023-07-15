import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pojo.Employee;
import pojo.EmployeeData;
import utils.PropertiesHandling;


public class HttpMethods {
    // HTTP client
    HttpClient client = HttpClient.newHttpClient();
    // HTTP client
    HttpClient client2 = HttpClient.newHttpClient();

    public Employee getRequest(int ID) throws Exception {

        // creating the request

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(PropertiesHandling.getProperty("get.employee.url") + "/" + ID))
                .build();

        // sending the request
        HttpResponse<String> response;
        Employee getEmployee;

        {
            try {
                response = client.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(response.body());

        getEmployee = new GsonBuilder().create().fromJson(response.body(), Employee.class);
        return getEmployee;

    }


    public Employee postRequest(String employeeName,int salary,int age ) throws IOException {

        // creating the request
        EmployeeData inputData = new EmployeeData();
        inputData.setEmployee_name(employeeName);
        inputData.setEmployee_salary(salary);
        inputData.setEmployee_age(age);
        Gson gson = new Gson();
        String gsonRequest = gson.toJson(inputData);

        System.out.println(gsonRequest);
        HttpRequest request = HttpRequest.newBuilder()
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(PropertiesHandling.getProperty("post.employee.url")))
                .header("Content-Type" ,"application/json" )
                .POST(HttpRequest.BodyPublishers.ofString(gsonRequest))
                .build();

        // sending the request
        HttpResponse<String> response;
        Employee employee;

        {
            try {
                response = client2.send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(response.body());
        employee = new GsonBuilder().create().fromJson(response.body(), Employee.class);
        return employee;

    }
}


