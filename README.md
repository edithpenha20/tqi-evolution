# Challenge TQI
### tqi_evolution_avaliacao

<h2>API de Empréstimos</h2>

O objetivo do projeto Loan API é disponibilizar uma API para solicitação de empréstimo através de uma API REST.
O projeto foi desenvolvido utilizando a linguagem Kotlin. Utilizei-a pois decidi me desafiar empregando os conceitos aprendidos não só no Bootcamp como em cursos particulares realizados.

Durante o projeto, são abordados os seguintes tópicos:

* Setup inicial de projeto com o Spring Boot Initialzr.
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados.
* Desenvolvimento de operações de gerenciamento de clientes e empréstimos.
* Desenvolvimento de autenticaçao e autorização de usuários através do Spring Security, e com suporte a JWT.
* Relação de cada uma das operações acima com o padrão arquitetural REST, e a explicação de cada um dos conceitos REST envolvidos durante o desenvolvimento do projeto.

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/api/customers
```
Através da URL acima é possível cadastrar um cliente.

Depois de cadastrado o cliente é possível realizar o login através do link:
```
http://localhost:8080/login
```
Para abrir solicitar um empréstimo acesse o seguinte link abaixo:

```
http://localhost:8080/loans
```

As seguintes ferramentas abaixo são utilizadas como parte do desenvolvimento do projeto prático:

* Java 11 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* Banco de dados MySQL como SGBD do nosso projeto (em ambos ambientes, Dev e Prod)
* Spring Security
* JWT
* BCrypt
* Validation
* Intellj IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.

