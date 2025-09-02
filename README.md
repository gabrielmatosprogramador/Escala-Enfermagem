# 🏥 Sistema de Escala de Enfermagem API

API RESTful desenvolvida como parte de um projeto acadêmico para solucionar o problema real de gerenciamento de escalas de trabalho para profissionais de enfermagem em um posto de saúde. A aplicação substitui o controle manual feito em planilhas por um sistema centralizado, robusto e de fácil consulta.

<p align="center">
  <a href="#-tecnologias"><img alt="Java" src="https://img.shields.io/badge/Java-21-blue"/></a>
  <a href="#-tecnologias"><img alt="Spring Boot" src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen"/></a>
  <a href="#-tecnologias"><img alt="PostgreSQL" src="https://img.shields.io/badge/PostgreSQL-16-blue"/></a>
  <a href="#-como-executar"><img alt="Build" src="https://img.shields.io/badge/Build-Maven-orange"/></a>
  <a href="#-licenca"><img alt="License" src="https://img.shields.io/badge/license-MIT-lightgrey"/></a>
</p>

---

## 🚀 Funcionalidades
A API oferece um conjunto completo de endpoints para gerenciar as três entidades principais do sistema:

### 👩‍⚕️ Gestão de Profissionais
- Adicionar e remover profissionais.
- Atualizar informações de cadastro.
- Ativar e desativar profissionais (exclusão lógica).
- Listar todos os profissionais ativos.

### 🏢 Gestão de Sítios (Atribuições)
- Adicionar e remover sítios de trabalho (ex: "Vacina", "Acolhimento").
- Atualizar informações dos sítios.
- Ativar e desativar sítios.
- Listar todos os sítios disponíveis.

### 📅 Gestão de Escalas
- Alocar um profissional a um sítio em uma data específica.
- Atualizar ou alterar a alocação de um profissional.
- Remover uma alocação.
- Consultar a escala completa de um profissional para um determinado mês e ano.

---

## 🛠 Tecnologias
- **Java 21** (LTS)
- **Spring Boot 3.x** (Web, Validation)
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**

---

## 🧱 Arquitetura & Padrões
- **Camadas**: `controller` → `service` → `repository` → `entity`
- **DTOs** para entrada/saída, evitando expor entidades diretamente
- **Validação** com `jakarta.validation`
- **Exclusão lógica** via campo `ativo` em Profissional e Sítio
- **Tratamento de erros** com `@ControllerAdvice` e respostas padronizadas

---

## 🏛 Modelo de Dados (DER)
```
+---------------------+           +---------------------+           +------------------+
|    PROFISSIONAL     |           |       ESCALA        |           |      SITIO       |
+---------------------+           +---------------------+           +------------------+
| PK id               |           | PK id               |           | PK id            |
| nome_completo       |-----------<| FK profissional_id  |           | nome             |
| cargo               |           | FK sitio_id         |>----------| descricao        |
| ativo               |           | data                |           | ativo            |
| data_cadastro       |           +---------------------+           +------------------+
+---------------------+
```

---

## ⚙️ Como Executar

### 🔑 Pré-requisitos
- JDK **21**
- Maven **3.x**
- PostgreSQL (ex.: 15 ou 16)
- IDE (IntelliJ, VS Code, Eclipse)

### 🧩 Configuração
1. Clone o repositório:
   ```bash
   git clone https://github.com/gabrielmatosprogramador/Escala-Enfermagem
   cd Escala-Enfermagem
   ```
2. Configure o banco de dados (PostgreSQL):
   - Crie o banco `escala_db`
   - Ajuste `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/escala_db
     spring.datasource.username=seu_usuario_postgres
     spring.datasource.password=sua_senha_postgres
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
     spring.jpa.show-sql=false
     ```

### ▶️ Executar Localmente
```bash
./mvnw spring-boot:run
```
A API ficará disponível em **http://localhost:8080**.

---

## 📖 Documentação da API

> Base URL: `http://localhost:8080`

### Profissionais (`/api/profissionais`)

| Verbo | Endpoint | Descrição | Corpo (JSON) |
|------|----------|-----------|--------------|
| POST | `/` | Cria um novo profissional | `{ "nome": "...", "cargo": "..." }` |
| GET  | `/` | Lista todos os profissionais **ativos** | — |
| GET  | `/{id}` | Busca profissional por ID | — |
| PUT  | `/{id}` | Atualiza nome e cargo | `{ "nome": "...", "cargo": "..." }` |
| PATCH| `/{id}/desativar` | Desativa profissional (lógico) | — |
| PATCH| `/{id}/ativar` | Reativa profissional | — |

---

### Sítios (`/api/sitios`)

| Verbo | Endpoint | Descrição | Corpo (JSON) |
|------|----------|-----------|--------------|
| POST | `/` | Cria um novo sítio/atribuição | `{ "nome": "...", "descricao": "..." }` |
| GET  | `/` | Lista todos os sítios **ativos** | — |
| GET  | `/{id}` | Busca sítio por ID | — |
| PUT  | `/{id}` | Atualiza dados | `{ "nome": "...", "descricao": "..." }` |
| PATCH| `/{id}/desativar` | Desativa sítio | — |
| PATCH| `/{id}/ativar` | Reativa sítio | — |

---

### Escalas (`/api/escalas`)

| Verbo | Endpoint | Descrição | Corpo (JSON) |
|------|----------|-----------|--------------|
| POST | `/` | Aloca profissional em um sítio numa data | `{ "profissionalId": 1, "sitioId": 1, "data": "2025-09-01" }` |
| GET  | `/profissional/{id}?ano=A&mes=M` | Escala de um profissional por ano/mês | — |
| DELETE | `/{escalaId}` | Remove alocação pelo ID | — |

---

## 👨‍💻 Autor
**Gabriel Matos**  
🔗 GitHub: https://github.com/gabrielmatosprogramador

---
