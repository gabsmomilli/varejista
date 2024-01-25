# Sistema de Cadastro de Produtos

Este projeto implementa um sistema de cadastro de produtos em Java, utilizando Spring Boot.

Os usuários têm a capacidade de executar operações de cadastro, listagem e exclusão para quatro entidades principais:
- Loja
- Produto
- Cliente
- Carrinho

Dentro da entidade Produto, é oferecida uma funcionalidade robusta de filtragem. Os usuários podem aplicar filtros específicos, tais como tamanho, categoria, cor, preço, marca, data de cadastro e descrição. A singularidade desta implementação reside na capacidade de combinar diversos filtros para refinar ainda mais os resultados desejados.
## Configuração

1. Clone o repositório.
2. Configure as propriedades do banco de dados no arquivo `src/main/resources/application.properties`
3. Execute a aplicação.

## Estrutura do Projeto

- `src/main/java/com.br.varejista`: Pacote principal.
    - `controller`: Contém os controladores da interface e da API.
    - `model`: Contém as classes `Produt`, `Client`, `ShoppingBag` e `Storage` representando um sistema de loja.
    - `repository`: Contém as classes `ProdutRepository`, `ClientRepository`, `ShoppingBagRepository` e `StorageRepository` para interação com o banco de dados.
    - `service`: Contém as classes `ProdutService`, `ClientService`, `ShoppingBagService` e `StorageService` para a lógica de negócios.


- `src/main/test/java/com.br.varejista`: Pacote de testes.
    - `controller`: Contém os testes dos controladores da interface e da API.
    - `service`: Contém os testes das classes de serviço do pacote principal para a lógica de negócios.


## Banco de Dados

É necessaria a criacao da base de dados MySQL com os seguintes dados:
- porta padrao: `3306`
- nome da base: `varejista`
- user: `root`
- password: `rootroot`

A aplicação suporta diversos bancos de dados, permitindo fácil adaptação às preferências do usuário, basta seta-las em `src/main/resources/application.properties

Não é necessário criar as tabelas manualmente, pois ao configurar o arquivo application.properties e criar a base de dados no esquema correspondente, a execução do sistema automaticamente gera as tabelas.

### Modelagem

<img width="618" alt="Captura de Tela 2024-01-25 às 01 05 50" src="https://github.com/gabsmomilli/varejista/assets/55815856/fd3e06c0-8cc0-4b60-a6a0-948d6c19159e">

## Testes

Foram implementados testes unitários para garantir a robustez do sistema. 

O sistema possui cerca de 72% das classes testadas e 80% das linhas cobertas.

## Documentação da API

Este projeto utiliza Swagger para documentar e testar a API RESTful. 

Nesta documentacao consta todas as rotas POST, GET e DELETE do projeto.

A documentação interativa pode ser acessada através do Swagger UI, no seguinte link: http://localhost:8080/swagger-ui/index.html#/
