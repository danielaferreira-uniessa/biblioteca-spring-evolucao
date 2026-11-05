# Biblioteca — sistema simples de gerenciamento de livros

## Apresentação

Aplicação web de biblioteca desenvolvida com Java e Spring Boot. O sistema permite visualizar o acervo, cadastrar livros e controlar o empréstimo e a devolução do primeiro livro da lista.

## Descrição

A aplicação oferece uma página web para cadastrar livros e consultar sua disponibilidade. A lista começa com o livro **O Hobbit**, de J. R. R. Tolkien. Os livros cadastrados e as alterações de disponibilidade ficam armazenados em memória enquanto a aplicação está em execução; portanto, os dados são reiniciados quando o servidor é encerrado.

O controle de empréstimo e devolução está disponível somente para o primeiro livro da lista. O cadastro de novos livros e a listagem abrangem todo o acervo em memória.

## Arquitetura do sistema

O projeto segue uma estrutura em camadas, com a interface e a API fornecidas pela mesma aplicação Spring Boot:

```text
Navegador
   │
   ├── Interface estática (HTML, CSS e JavaScript)
   │       └── consulta e cadastra livros pela API REST
   │
   └── API REST (LivroController)
           └── regras e estado em memória (LivroService)
                   └── modelo de domínio (Livro)
```

- **Interface:** página servida como recurso estático, responsável pelo formulário de cadastro, exibição do acervo e ações de empréstimo/devolução.
- **Controller:** expõe os endpoints HTTP e encaminha as operações para o serviço.
- **Service:** mantém a lista de livros em memória e inicializa o acervo com um livro.
- **Modelo:** representa título, autor e disponibilidade de cada livro.
- **Persistência:** não há banco de dados; os dados existem apenas durante a execução do processo.

### Endpoints

| Método | Rota | Descrição |
|---|---|---|
| `GET` | `/livros` | Lista os livros cadastrados. |
| `POST` | `/livros` | Cadastra um livro. Envie `titulo`, `autor` e `disponivel` em JSON. |
| `GET` | `/livro` | Retorna o primeiro livro da lista. |
| `GET` | `/livro/emprestar` | Marca o primeiro livro como indisponível. |
| `GET` | `/livro/devolver` | Marca o primeiro livro como disponível. |

Exemplo de corpo para `POST /livros`:

```json
{
  "titulo": "Dom Casmurro",
  "autor": "Machado de Assis",
  "disponivel": true
}
```

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4.1.1**
- **Spring MVC**, para a API REST e o servidor web
- **Maven**, para gerenciamento do projeto e execução dos testes
- **HTML, CSS e JavaScript**, para a interface web
- **JUnit 5 e Spring Boot Test**, para testes automatizados

## Como executar

É necessário ter o **Java 21** instalado. No terminal, acesse a pasta do projeto Maven e inicie a aplicação:

```bash
cd biblioteca
./mvnw spring-boot:run
```

Depois, abra [http://localhost:8080](http://localhost:8080) no navegador.

Para executar os testes:

```bash
./mvnw test
```