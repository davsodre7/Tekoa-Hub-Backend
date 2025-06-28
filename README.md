# Tekoá Hub - Backend

**Versão submetida:** Intermediária (Nível Recomendado)  
**Público-alvo:** Povos Indígenas  
**ODS:** ODS 10 – Redução das Desigualdades, ODS 4 – Educação de Qualidade

## Descrição

O Tekoá Hub é uma plataforma web para valorização, preservação e divulgação da herança cultural dos povos indígenas brasileiros. O backend foi desenvolvido em Java com Spring Boot, seguindo arquitetura MVC, e expõe uma API RESTful para cadastro, consulta, edição e exclusão de conteúdos culturais e categorias.

## Funcionalidades

- CRUD completo para as entidades:
  - **Category** (Categoria de conteúdo cultural)
  - **Content** (Conteúdo cultural: histórias, arte, música, etc)
- Endpoints REST documentados
- Integração com banco de dados relacional (MySQL em produção, H2 em desenvolvimento)
- Organização em pacotes por responsabilidade (controller, service, repository, model, dto, mapper, config, exception)
- Tratamento global de exceções
- Configuração de CORS e segurança básica

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Spring Data JPA
- MySQL (produção) / H2 (desenvolvimento)
- Maven
- Lombok

## Como Executar Localmente

### Pré-requisitos

- Java 17+
- Maven 3.8+
- (Opcional) MySQL rodando, caso queira testar com banco real

### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/tekoa-hub-backend.git
   cd tekoa-hub-backend
   ```

2. **Configure o banco de dados:**
   - Por padrão, o projeto usa H2 em memória para desenvolvimento.
   - Para usar MySQL, edite `src/main/resources/application.properties`:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/tekoa_db
     spring.datasource.username=seu_usuario
     spring.datasource.password=sua_senha
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
     ```

3. **Build e execute:**
   ```bash
   ./mvnw spring-boot:run
   ```
   O backend estará disponível em: [http://localhost:8080](http://localhost:8080)

4. **Acesse o console H2 (opcional):**
   - [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:tekoa_db`

## Endpoints Principais

- `/api/categories` - CRUD de categorias
- `/api/contents` - CRUD de conteúdos culturais

> Para detalhes de cada endpoint, consulte o arquivo [API.md](./API.md).

## Organização dos Pacotes

- `controller/` - Controllers REST
- `service/` - Lógica de negócio
- `repository/` - Acesso a dados (JPA)
- `model/` - Entidades
- `dto/` - Data Transfer Objects
- `mapper/` - Conversão entre entidades e DTOs
- `config/` - Configurações (CORS, segurança)
- `exception/` - Tratamento global de erros

## Commits

O projeto segue o padrão [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/), facilitando o entendimento do histórico e automação de changelog.

## Como contribuir

1. Faça um fork do projeto
2. Crie uma branch: `git checkout -b minha-feature`
3. Commit com mensagem convencional: `git commit -m "feat: minha nova feature"`
4. Push: `git push origin minha-feature`
5. Abra um Pull Request

## Licença

Este projeto é open-source, para fins educacionais e sociais.

## 🔧 Pré-requisitos

### 1. Git Instalado
```bash
# Ubuntu/Debian
sudo apt-get install git

# macOS
brew install git

# Windows
# Baixe em: https://git-scm.com/download/win
```

### 2. Conta GitHub
- Crie uma conta em: https://github.com
- Configure autenticação (SSH key ou Personal Access Token)

### 3. Repositório GitHub
Crie o repositório no GitHub:
1. Acesse: https://github.com/new
2. Nome: `tekoa-cultural-archive-hub-backend`
3. Descrição: `Backend do Tekoá Hub`
4. **NÃO** inicialize com README, .gitignore ou license
5. Clique em "Create repository"

## 📋 Passo a Passo

### Primeira Configuração

1. **Clone ou baixe o projeto**
   ```bash
   git clone <url-do-seu-repositorio>
   cd tekoa-cultural-archive-hub-backend
   ```

2. **Execute o setup**
   ```bash
   chmod +x setup-github.sh
   ./setup-github.sh
   ```

3. **Siga as instruções do script**
   - Digite seu nome de usuário do GitHub
   - Confirme a criação do repositório
   - Aguarde o push inicial

### Para Colaboradores

1. **Clone o repositório**
   ```bash
   git clone https://github.com/seu-usuario/tekoa-cultural-archive-hub-backend.git
   cd tekoa-cultural-archive-hub-backend
   ```

2. **Configure seu ambiente**
   ```bash
   # Configure seu nome e email
   git config user.name "Seu Nome"
   git config user.email "seu-email@exemplo.com"
   ```

3. **Use o script de deploy**
   ```bash
   ./deploy.sh
   ```
   
---

**Desenvolvido para o Tekoá Hub** 🏛️ 
