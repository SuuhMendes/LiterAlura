# 📚 Projeto LiterAlura

Aplicação Java + Spring Boot desenvolvida como parte do desafio proposto pela [Alura](https://www.alura.com.br/) no programa **Oracle Next Education (ONE)**.

Este projeto realiza o consumo da API pública de livros [Gutendex](https://gutendex.com/) e permite diversas consultas e registros de livros e autores no banco de dados.

---

## 🚀 Funcionalidades disponíveis

Ao executar a aplicação, o usuário poderá escolher uma das seguintes opções:

1. ✍🏻 **Buscar livro pelo título**  
   → Realiza uma requisição à API do Gutendex e registra o livro no banco, se ainda não existir.

2. 📚 **Listar livros registrados**  
   → Exibe todos os livros salvos localmente no banco de dados.

3. 👨🏻‍💼 **Listar autores registrados**  
   → Mostra todos os autores salvos no sistema.

4. 📅 **Listar autores vivos em determinado ano**  
   → Filtra autores cuja data de nascimento e falecimento indicam que estavam vivos no ano informado.

5. 🧑‍💻 **Listar livros em determinado idioma**  
   → Filtra livros salvos no banco de acordo com o idioma (ex: en, pt, es).

6. 🔥 **Listar Top 5 dos livros mais baixados**  
   → Exibe os livros mais populares com base no número de downloads.

---

## 🛠️ Tecnologias utilizadas

- ☕ Java 17  
- ⚙️ Spring Boot  
- 🐘 PostgreSQL  
- 🌐 API Gutendex (https://gutendex.com)  
- 🔄 Jackson para manipulação de JSON  
- 🧪 Banco de testes H2 (opcional para ambiente local)

---

## 💾 Banco de Dados

Por padrão, o projeto usa **PostgreSQL**. Certifique-se de configurar corretamente o `application.properties` com sua URL, usuário e senha.
Antes de rodar o aplicativo, configure o arquivo:

`src/main/resources/application.properties`

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literAlura
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
---
📌 Obs: Crie um banco de dados chamado literAlura no PostgreSQL antes de rodar a aplicação.
---

📦Como executar a aplicação
---
### 1. Faça o clone do repositório:
```bash
git clone https://github.com/SuuhMendes/literalura.git

```

### 2.Navegue até o diretório
```bash
cd literalura
```

### 3.Execute a aplicação com o Maven:
```bash
mvn spring-boot:run
```
✅ A aplicação exibe um menu interativo no console, onde é possível buscar livros e armazená-los no banco de forma simples e rápida.
---
* **👩‍💻 Desenvolvedora**
**Sulamita Mendes**
💼 [LinkedIn](linkedin.com/in/sulamita-mendes-2019p)
