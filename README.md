# Customer-Management

<img width="897" alt="localhost:8080">
<img width="897" alt="/customers">
<img width="897" alt="/customers/new">
<img width="897" alt="/customers/edit">

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
