# GerenciamentoEmprestimos

##Sistema de Gestão de Itens

Este projeto é um sistema de gestão de itens, desenvolvido em Java com interface gráfica (Java Swing) e banco de dados MySQL. O sistema permite o cadastro de itens e usuários, controle de empréstimos e devoluções, além de consultas e geração de relatórios.

### Funcionalidades
1. Cadastro de Itens
Inserir informações como:
Nome do item
Categoria
Estado (disponível ou emprestado)

2. Cadastro de Usuários
Registrar dados dos usuários, incluindo:
Nome
Matrícula
Contato

3. Registro de Empréstimos e Devoluções
Controlar o status dos itens, com:
Data e hora de empréstimo
Data e hora de devolução
Nesta tela, é possível realizar o empréstimo e devolução de itens.

4. Consulta de Histórico
Exibir o histórico de empréstimos e devoluções:
Por item
Por usuário

5. Relatórios
Gerar relatórios, incluindo:
Itens mais emprestados
Itens com devoluções atrasadas

### Requisitos Técnicos<br>
Banco de Dados
MySQL: Utilizado para armazenar os dados de itens, usuários, empréstimos e devoluções.

Interface Gráfica
Desenvolvido com Java Swing para:
Cadastro de itens e usuários
Controle de empréstimos e devoluções
Consultas e geração de relatórios

Pré-requisitos para Execução
Java Development Kit (JDK) versão 8 ou superior.
MySQL instalado e configurado.
Um ambiente de desenvolvimento compatível, como NetBeans ou Eclipse.
Biblioteca MySQL Connector for Java para conectar ao banco de dados.

### Configuração do Banco de Dados<br>

Crie um banco de dados no MySQL: CREATE DATABASE GerenciamentoEmprestimos;

Execute os scripts de criação das tabelas fornecidos no arquivo Banco.sql.

Atualize as configurações de conexão no código (host, usuário, senha, nome do banco).

Executando o Projeto
Clone este repositório:
git clone <[url-do-repositorio](https://github.com/pireszx/GerenciamentoEmprestimos.git)>
Abra o projeto no seu ambiente de desenvolvimento.
Configure as dependências do MySQL Connector.
Compile e execute a aplicação.

### Demonstração em Vídeo

Assista a demonstração do sistema no YouTube:  
(https://www.youtube.com/watch?v=mOn4Fn65g1o)  

O vídeo apresenta as principais funcionalidades e um passo a passo para começar a utilizar o sistema.


### Desenvolvido por

Bernardo Paz, João Vitor Ritter, Marcelo Moro, Matheus Sansonowicz, Pedro Pires & Wendel Nunes
