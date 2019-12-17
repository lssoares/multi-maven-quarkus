# Multi-Maven-Quarkus
Project to reproduce Multi module maven project based on Quarkus


## Panache Automated Test issue

Although webservice works fine (compile the project skipping the automated tests),
the JUnit test fails with:

```
java.lang.IllegalStateException: This method is normally automatically overridden in subclasses: did you forget to annotate your entity with @Entity?
```


## How to run the project

 On a terminal, under project root folder, run  the following command:
```
./mvnw compile quarkus:dev
```

Open a browser and navigate to:
 `
```
http://0.0.0.0:8080/swagger-ui
```

Use the interactive swagger interface to execute the web service.


## How to reproduce the issue

 On a terminal, under project root folder, run  the following command:
```
./mvnw package
```

