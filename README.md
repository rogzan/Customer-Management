# Customer-Management

<img width="897" alt="localhost:8080" src="https://user-images.githubusercontent.com/58004469/230616953-05d25af7-b72b-47f6-ae25-1188ba4f2cf8.png">
<img width="897" alt="/customers" src="https://user-images.githubusercontent.com/58004469/230617071-1c17a69a-dff0-49b6-97f5-25afb573f0ff.png">
<img width="897" alt="/customers/new" src="https://user-images.githubusercontent.com/58004469/230617125-f014cf92-b119-4ecc-bf59-a06617a4215e.png">>
<img width="897" alt="/customers/edit" src="https://user-images.githubusercontent.com/58004469/230617246-bec001dd-a68e-41d8-a872-277143948221.png">

## Introduction 
Java web application based on Spring framework implementing all the crud operations - adding, editing and deleting customers from list.

## Installation
The project is created with Maven, so you just need to import it to your IDE and build the project to resolve the dependencies

## Database configuration 
Create a MySQL database with the name `customerdb` and add the credentials to `/resources/application.properties`.  
The default ones are :

```
spring.datasource.url=jdbc:mysql://localhost:3306/customerdb
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.show_sql=true
```
