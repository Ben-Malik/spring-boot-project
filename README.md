# A boilerplate code for a spring boot Java web application 
 # Teck Stack
 1. Java 17
 2. Spring Boot 2.5.4
 3. Maven
 4. Hibernate
 5. Liquibase
 6. Postgresql
 7. Thymeleaf
 8. Bootstrap

### To run the app 

``` 
$ git clone https://github.com/Ben-Malik/spring-boot-project.git my-project
$ cd my-project
```
Do make sure your server on docker is accecptin requests on port 5432.

### To create necessary maven updates
```
$ mvn -N io.takari:maven:wrapper
```

### To clean and install
```
$ ./mvnw clean install
```

### To run your spring boot app
```
$ ./mvnw spring-boot:run
```

Your app is running on Port ``` 8085 ```
Go to <a href="http://localhost:8085" target="new">localhost:8085</a>
