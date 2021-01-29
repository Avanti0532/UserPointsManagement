# UserPointsManagement
This web service is implemented using Spring Boot(version 2.4.2) and in memory database H2.

To access the database, please follow the link: http://localhost:8080/h2-console 
with the following username and password

user name : sa
password: password

Please make sure to add lombok plugin in your IDE

Swagger link: http://localhost:8080/swagger-ui/

POST Request:

http://localhost:8080/add-points

Body:

{
    "payerName":"DANNON",
    "points":1000,
    "transactionDate":"2020-11-08T09:00:00"
}

PUT Request:

http://localhost:8080/deduct-points?points=5000

GET Request:

http://localhost:8080/get-points
