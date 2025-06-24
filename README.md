# Projeto API de Tarefas com Spring Boot

Este é o README para o projeto de API de Lista de Tarefas (To-Do List), desenvolvido com Spring Boot.

---

## 🚀 Sobre o Projeto

Uma API RESTful simples para gerenciar tarefas, permitindo criar, listar, atualizar e deletar itens de uma lista de afazeres.

---
## 📋 Pré-requisitos

Para compilar e rodar este projeto localmente, você precisará ter as seguintes ferramentas instaladas em sua máquina.

| Requisito Essencial | Descrição |
| ------------------ | ------------------------------------------------------------------ |
| **Java** | O projeto utiliza a plataforma Java (versão 17+ recomendada). |
| **Maven** | Ferramenta de automação de compilação e gerenciamento de dependências. |
| **PostgreSQL** | Banco de dados relacional utilizado para persistir os dados. |
| **Docker** | Plataforma para criar e gerenciar contêineres (usado para rodar a aplicação e o banco de dados de forma isolada). |
| **Git** | Sistema de controle de versão para clonar o repositório. |
| **IDE** | Um Ambiente de Desenvolvimento Integrado como **VSCode** ou **IntelliJ IDEA** para facilitar a codificação e gerenciamento do projeto. |

--- 

## ⚙️ Rodando Localmente

Siga os passos abaixo para executar o projeto em seu ambiente de desenvolvimento.

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/loreslei/Back-Spring-Todo.git
    cd Back-Spring-Todo
    ```

2.  **Configure as variáveis de ambiente:**
    Crie um arquivo chamado `.env` na raiz do projeto e adicione as suas credenciais do PostgreSQL. Este arquivo será usado pelo `docker-compose`.

    **Arquivo: `.env`**
    ```env
    POSTGRES_USER=seu_usuario_aqui
    POSTGRES_PASSWORD=sua_senha_aqui
    POSTGRES_DB=seu_banco_de_dados_aqui
    ```

3.  **Configure o Spring Boot:**
    Altere o arquivo `src/main/resources/application.properties` para que o Spring Boot possa se conectar ao banco de dados que será criado pelo Docker. As variáveis `${...}`. Se estiver utilizando um banco externo (Supabase, Railway), utilize `spring.datasource.url=jdbc:postgresql://localhost:5432/${SEU_DB}`, se estiver usando um banco local, utilize `spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/${SEU_DB}`.
    Como estou usando Supabase, o resultado abaixo mostra essa perspectiva.

    **Arquivo: `src/main/resources/application.properties`**
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/${SEU_DB}
    spring.datasource.username=${SEU_USUARIO}
    spring.datasource.password=${SUA_SENHA}
    spring.jpa.hibernate.ddl-auto=update
    ```

5.  **Suba os contêineres com Docker Compose:**
    No terminal, a partir da raiz do projeto, execute o comando abaixo. Ele irá baixar as imagens necessárias e iniciar a aplicação e o banco de dados.
    ```bash
    docker-compose up --build
    ```

6.  **Teste a aplicação:**
    Após os contêineres estarem no ar, a API estará disponível para testes no seu navegador ou cliente de API (Postman, Insomnia).

    * **URL Local:** [**http://localhost:8080/api/tarefas**](http://localhost:8080/api/tarefas)
  
---

## 🌐 Teste Rápido (API em Produção)

Para uma demonstração prática e fácil, você pode testar a API diretamente no endpoint público hospedado no Render.

* **URL de Produção:** [**https://back-spring-todo.onrender.com/api/tarefas**](https://back-spring-todo.onrender.com/api/tarefas)
