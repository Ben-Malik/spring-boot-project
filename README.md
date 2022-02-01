# A boilerplate code for a spring boot Java web application; Java 17, Spring boot 2.5.4

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