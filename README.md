## Before run the project
* src/main/resources/application.properties
```
spring.application.name=spring-data-jpa
spring.datasource.url=jdbc:postgresql://localhost:5432/<DB_NAME>
spring.jpa.properties.hibernate.default_schema=<SCHEMA_NAME>
spring.datasource.username=<USERNAME>
spring.datasource.password=<DB_PASSWORD>

spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```
