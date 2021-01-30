# UserPointsManagement
This web service is implemented using Spring Boot(version 2.4.2) and in memory database H2.

To access the database, please follow the link: http://localhost:8080/h2-console 
with the following username and password

1. user name : sa
2. password: password
3. database: testdb

Please make sure to add **lombok plugin** in your IDE

**Swagger url**: http://localhost:8080/swagger-ui/

User table is created with the following fields. Please check src/main/resources/data.sql for all the entries in this table - 
1. first name
2. last name 
3. email

User Points will be stored in UserPoints table with the following fields:
1. payer name
2. points
3. transaction date

**POST Request**: User points will be added to user's account based on the user email id

http://localhost:8080/add-points?email=lilyjohn@gmail.com

Body:
{
    "payerName":"DANNON",
    "points":1000,
    "transactionDate":"2020-11-08T09:00:00"
}

**PUT Request**: User points will be deducted from user's account by providing user email id

http://localhost:8080/deduct-points?points=5000&email=lilyjohn@gmail.com

**GET Request**: Balance points of the user will be retrieved based on user email id

http://localhost:8080/get-points?email=lilyjohn@gmail.com
