# Desafio Serasa Experian - Nível 2

Este projeto foi criado com base nas orientações do desafio Serasa Experian Nível 2.

## Características do Projeto
- Criado em um projeto Maven, na linguagem Java 11 e utilizando Spring Framework.
- Criado a partir do archetype disponível em [Spring Initializer](https://start.spring.io).
- Utilizado o banco de dados H2.
- Testes unitários criados com JUnit e Mockito.

## Endpoints da aplicação
- POST /vendedor  
Localizado no controller: [VendedorController](../main/src/main/java/br/com/matheliasc/Vendedores/controller/VendedorController.java#L39).  
Responsável pelo cadastro de vendedores.  
Retorna 201 ao sucesso da inclusão e 204 caso não encontre uma Atuacao com a região informada.  
Dentro de sua lógica ([VendedorService](../main/src/main/java/br/com/matheliasc/Vendedores/service/Impl/VendedorServiceImpl.java#L41)) é verificado se existe Atuacao com a região informada e retorna os estados de tal Atuacao.

- POST /atuacao  
Localizado no controller: [AtuacaoController](../main/src/main/java/br/com/matheliasc/Vendedores/controller/AtuacaoController.java#L24).  
Responsável pelo cadastro de atuacao.  
Retorna 201 ao sucesso da inclusão.  

- GET /vendedor/{id}  
Localizado no controller: [VendedorController](../main/src/main/java/br/com/matheliasc/Vendedores/controller/VendedorController.java#L46).  
Responsável por localizar um determinado vendedor de acordo com o ID fornecido.  
Retorna 200 ao obter sucesso encontrando um vendedor com tal id e 204 caso contrário.  
Dentro de sua lógica ([VendedorService](../main/src/main/java/br/com/matheliasc/Vendedores/service/Impl/VendedorServiceImpl.java#L48)) é buscada a Atuacao com a região do vendedor encontrado para retornar um DTO do Vendedor com os estados da região.  

- GET /vendedor  
Localizado no controller: [VendedorController](../main/src/main/java/br/com/matheliasc/Vendedores/controller/VendedorController.java#L33).  
Responsável por localizar todos os vendedores cadastrados.  
Retorna 200 ao obter sucesso encontrando ao menos um vendedor e 204 caso contrário.  
Dentro de sua lógica ([VendedorService](../main/src/main/java/br/com/matheliasc/Vendedores/service/Impl/VendedorServiceImpl.java#L31)) para cada vendedor é buscada a Atuacao com a região, a fim de retornar um DTO do Vendedor com os estados da região.  

## Estrutura do Banco de dados
- Vendedor  
O Entity de Vendedor pode ser encontrado em [Vendedor](../main/src/main/java/br/com/matheliasc/Vendedores/model/Vendedor.java).  
O Id é gerado de forma automática e sequencial em função da anotação **@GeneratedValue(strategy = GenerationType.IDENTITY)**  

- Atuacao
O Entity de Atuacao pode ser encontrado em [Atuacao](../main/src/main/java/br/com/matheliasc/Vendedores/model/Atuacao.java).  

Ao executar a aplicação também é possível observar a estrutura do banco de dados e os dados inseridos através do link: (http://localhost:8080/h2-console), no qual é possível acessar o console do banco de dados h2, utilizando o JDBC Url: jdbc:h2:mem:db e o User name padrão: sa

## Testes unitários  
As classes de teste podem ser encontradas em: [Vendedor](../main/src/test/java/br/com/matheliasc/Vendedores/service/impl/VendedorServiceImplTest.java) e [Atuacao](../main/src/test/java/br/com/matheliasc/Vendedores/service/impl/AtuacaoServiceImplTest.java).


## Postman
Para testar a aplicação e o retorno dos endpoints, utilizei o Software Postman e disponibilizei a collection que pode ser importada para utilização, ela pode ser encontrada em: [Postman](../main/Vendedores.postman_collection.json)
