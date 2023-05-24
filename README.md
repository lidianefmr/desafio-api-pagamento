<h1>API de Pagamento by: Lidiane Ferreira Machado Rodrigues</h1>

Desenvolvido usando o Spring Boot para o back-end e alguns módulos:

* Spring MVC;
* Spring Data JPA;
* Spring Validation;

<b>Configuração do Spring Datasource e JPA</b>

Abra o arquivo: src/main/resources/application.properties

<b>Para uso com o PostgreSQL:</b><br>
spring.datasource.url= jdbc:postgresql://localhost:5432/postgres<br>
spring.datasource.username= postgres<br>
spring.datasource.password= 12345678<br>
spring.jpa.hibernate.ddl-auto= update<br>

spring.datasource.driver-class-name=org.postgresql.Driver <br>
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

## Rodar a aplicação
PagamentoApplication

