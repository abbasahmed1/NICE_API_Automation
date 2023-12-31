# Employee's API Task

## Tech Stack
Java , Junit , Maven , httpclient

## API Documentation 
https://www.dummy.restapiexample.com/

The API endpoints :
> GET https://dummy.restapiexample.com/api/v1/employee/{ID}
> 
> POST https://dummy.restapiexample.com/api/v1/create

## Project Structure

Project Name : httpClient_Task

Project files path: Src->Test->Java  

pojo : Contains 2 classes for The response body parameters for the API calls   

Utils : propertiesHandling class for handling the URLs  

HttpMethods Class : for the GET / POST request creation  

TestRunner : The 2 test cases one GET and one POST  




## How to run ?

1- Through IDE :  
 > Execute the TestRunner Class 
 >
 > Click double Ctrl key so you can execute a maven command 
 > 
 > Execute Command : mvn -Dmaven.test.skip=true surefire-report:report for the Report  


2- Maven commands
 > go to CMD and go to the application folder  
 > 
 > execute command : mvn clean test + Enter  
 > 
 > Execute Command : mvn -Dmaven.test.skip=true surefire-report:report for the Report   

## Reporting

 1- After executing the test a test report will be generated in Target folder-> surfire-reports   

 2- After Executing Command : mvn -Dmaven.test.skip=true surefire-report:report :

  >  HTML report will be generated under Target-> site ->surefire-report.html
  > 
  >  open the report with a web browser 


## Documentation Files

> The Documentaion Folder :
> 
> TestCases 
> 
> Test Coverage
> 
> suggestions and Improvements

