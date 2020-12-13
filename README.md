# VEPCM
Projeto realizado em Spring Boot como avaliação para disciplina TCC00338 Desenvolvimento de Aplicações Coorporativas da Universidade Federal Fluminense.



## 1. Compilando o código

Para rodar localmente a aplicação backend, no PowerShell rode o comando `mvn spring-boot:run`. O endereço base da aplicação é http://localhost:5000.

Além disso, é necessário configurar a url, username e senha para o banco em `application.properties`.

## 2. Estrutura do projeto

* apl-vepcm/src/main
    * java
        * br.com.uff.vepcm
            * domain
                * entity
                * enums 
                * repository
            * service
                * exception
                * impl (implementação dos serviços)
                * *interfaces dos services*
            * web
                * controller
                * dto
                * utils (ferramentas de apoio)
    * resources
        * application.properties (configurações do projeto)
        * data.sql (carga mock do banco)

## 3. API

É possível testar os endpoints e visualizar a documentação da API rodando a aplicação e acessando a [UI Swagger](https://swagger.io/tools/swagger-ui/) no endereço **http://localhost:5000/api-doc.html**.
