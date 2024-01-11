# Desafio TOTVS

## Objetivo:
O objetivo deste projeto é criar um sistema de gerenciamento de tarefas simples que permita aos usuários criar e visualizar cadastro de clientes com sua lista de contatos telefônicos. O sistema será composto por duas aplicações interconectadas: uma aplicação back-end desenvolvida em Java utilizando o framework Spring, e uma aplicação front-end construída em Angular.

## Documento com as especificações exigidas para o desafio: [Desafio Totvs](https://github.com/FernandaZaccaroRigolin/Challenge-Totvs-FullStack/blob/main/Desafio%20TOTVS.pdf)

## Arquitetura:
A arquitetura do sistema será baseada em uma abordagem de microserviços, onde o back-end e o front-end operam de forma independente, comunicando-se por meio de APIs REST.

## Aplicações:

### Back-end em Java com Spring:

Tecnologias Utilizadas:

  * Java 17
  * Spring Boot
  * Maven para gerenciamento de dependências
  * JUnit

Funcionalidades:
  * Estrutura para inserção de dados de clientes juntamente com sua lista de telefones.
    > Validar se o telefone é nulo e se está em um formato válido.
    >> Utilização de expressão regular (regex): formato definido (99)99999-9999 ou (99)9999-9999

  * Testes unitários somente para as validações
  * Documentação gerada pelo JavaDoc com a estrutura da API Java [(https://fernandazaccarorigolin.github.io/Challenge-Totvs-FullStack)]

### Front-end em Angular:

Tecnologias Utilizadas:
  * Node 20.10.0
  * Angular CLI: 16.2.11
  * Angular: 16
  * TypeScript
  * Angular CLI para geração de código
  * Biblioteca de componentes [PO UI](https://po-ui.io/)
  * RxJS para manipulação de assincronia
  * API JSON Server para interatividade da aplicação
    
Funcionalidades:

  * Inserção de dados de clientes: nome, endereço, bairro e lista de telefones (tabela separada vinculada ao cliente)
   > Validar se o nome do cliente é maior que 10 caracteres e não permitir dados redundantes.
   >> Validar se um telefone cadastro a um cliente X não está vinculado a outro. 1 para 1.

## Ambiente de desenvolvimento
  1. Clone o repositório das aplicações [(https://github.com/FernandaZaccaroRigolin/Challenge-Totvs-FullStack)]
     
## Servidor de Desenvolvimento: Angular
  1. Execute a instalação das dependências. ($ npm install)
  2. Execute `ng serve` para um servidor de desenvolvimento. Navegue para `http://localhost:4200/`
     
## Servidor de Desenvolvimento: JSON Server
  1. Instalando: npm install -g json-server
  2. Para rodar o servidor copie o arquivo db.json para a raiz do projeto e execute o seguinte comando: json-server --watch db.json

## Servidor de Desenvolvimento: Java
  1. Importe o projeto pra workspace da IDE de sua prefência. (Sugestão Eclipse IDE for Java Developers)
  2. Após as importações automática executadas pelo Maven
  3. Execute o main da aplicação. Tomcat será inicializado com porta `http://localhost:8080/`

## Pacote JAR para o depoy da aplicação back-end
  https://github.com/FernandaZaccaroRigolin/Challenge-Totvs-FullStack/blob/main/Desafio_Spring/desafiototvs.jar
  
