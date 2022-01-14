# Angular's Project Back-End

<h4>FRONT-END: https://github.com/BrenoRev/FrontEnd_CarRent </h4>

<hr>

 <p>Ferramentas utilizadas</p>
        <ul>
  <li>Spring</li>
  <li>H2-Database</li>
  <li>JWT / Spring Security</li>
  <li>Cryptografy BCrypt</li>
  <li>Swagger-UI Documentation</li>
  <li>Mock / JUnit 5 for Tests </li>
  <li>Lombok</li>
        </ul>

<p> Swagger Documentation API </p>
  
  :warning: Put the Bearer Token on the authorization before each POST, PUT, DELETE OR PATCH REQUEST
```
localhost:8081/swagger-ui/#/
```

## Development Setup

### Prerequisites

- Java

Download or clone the code from this repository.

If you download as a zip file, be sure to unzip it.

```
https://github.com/BrenoRev/BackEnd_CarRent.git
```

Open your IDE and import the project as Maven Project

:warning: SET PROFILE TO DEV
```
spring.profiles.active=dev
```

Run project as Spring Boot Application

The application should then compile and starting to mock SQL into H2-DB.

