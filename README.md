# 🏛️ Tekoá Hub - Backend

**Versão submetida:** Intermediária (Nível Padrão)  
**Público-alvo:** Povos Indígenas  
**ODS:** ODS 4 – Educação de Qualidade, ODS 10 – Redução das Desigualdades

Backend do Tekoá Hub: API RESTful para preservação e valorização da cultura indígena brasileira.

## 🎯 Sobre o Projeto

O Tekoá Hub é uma plataforma digital dedicada à preservação e divulgação da cultura indígena brasileira. O backend Spring Boot oferece uma API RESTful robusta para cadastro, consulta, edição e exclusão de conteúdos culturais e categorias, integrando-se ao frontend React.

### Público-Alvo
- **Povos Indígenas** - Para preservar e compartilhar sua cultura
- **Educadores** - Para usar em sala de aula
- **Público Geral** - Para conhecer e valorizar a cultura indígena

### ODS Alinhadas
- **ODS 4 - Educação de Qualidade**: Promovendo educação inclusiva sobre cultura indígena
- **ODS 10 - Redução das Desigualdades**: Valorizando e preservando culturas minoritárias
- **ODS 16 - Paz, Justiça e Instituições Eficazes**: Promovendo sociedades inclusivas

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **Hibernate**
- **MySQL 8.0+**
- **Jakarta Validation**
- **Lombok**
- **Spring Web**
- **Maven**

## 📋 Pré-requisitos

- **Java 17+**
- **Maven 3.8+**
- **MySQL 8.0+** rodando localmente

## 🚀 Como Executar o Backend

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd tekoa-hub-backend
```

### 2. Configure o banco de dados
Edite `src/main/resources/application.properties` se necessário:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tekoa_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

### 3. Build e execute o projeto
```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

### 4. Acesse a aplicação
O backend estará disponível em: **http://localhost:8080**

## ⚡ Comandos Rápidos

```bash
# Executar em desenvolvimento
./mvnw spring-boot:run

# Build para produção
./mvnw clean package

# Compilar apenas
./mvnw compile

# Limpar build anterior
./mvnw clean
```

## ✅ Verificação de Funcionamento

1. Acesse `http://localhost:8080/api/categories` no navegador ou via curl
2. Verifique se retorna a lista de categorias em JSON
3. Confirme que o banco foi criado automaticamente (`tekoa_db`)

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/tekoahub/
│   │   ├── controller/   # Controllers REST
│   │   │   ├── CategoryController.java    # API de categorias
│   │   │   └── ContentController.java     # API de conteúdos
│   │   ├── service/      # Lógica de negócio
│   │   │   ├── CategoryService.java       # Serviços de categoria
│   │   │   └── ContentService.java        # Serviços de conteúdo
│   │   ├── repository/   # Acesso a dados (JPA)
│   │   │   ├── CategoryRepository.java    # Repository de categorias
│   │   │   └── ContentRepository.java     # Repository de conteúdos
│   │   ├── model/        # Entidades
│   │   │   ├── Category.java              # Entidade categoria
│   │   │   └── Content.java               # Entidade conteúdo
│   │   ├── dto/          # Data Transfer Objects
│   │   │   ├── CategoryRequestDTO.java    # DTO de requisição categoria
│   │   │   ├── CategoryResponseDTO.java   # DTO de resposta categoria
│   │   │   ├── ContentRequestDTO.java     # DTO de requisição conteúdo
│   │   │   └── ContentResponseDTO.java    # DTO de resposta conteúdo
│   │   ├── mapper/       # Conversão entre entidades e DTOs
│   │   │   ├── CategoryMapper.java        # Mapper de categoria
│   │   │   └── ContentMapper.java         # Mapper de conteúdo
│   │   ├── config/       # Configurações
│   │   │   └── WebConfig.java             # Configuração web/CORS
│   │   ├── exception/    # Tratamento global de erros
│   │   │   ├── ApiError.java              # Modelo de erro da API
│   │   │   └── GlobalExceptionHandler.java # Handler global
│   │   └── TekoaHubApplication.java       # Classe principal
│   └── resources/
│       ├── application.properties          # Configurações principais
│       └── static/                        # Arquivos estáticos
└── test/
    └── java/com/tekoahub/
        └── TekoaHubApplicationTests.java  # Placeholder de teste (sem dependências)
```

## 📱 Funcionalidades

- CRUD completo de categorias e conteúdos culturais
- API RESTful documentada
- Validação de dados com Jakarta Validation
- Tratamento global de exceções
- Configuração de CORS para integração com frontend
- Integração com MySQL
- Organização em pacotes por responsabilidade
- DTOs para transferência de dados

## 🔌 Endpoints da API

### Categorias (`/api/categories`)
- `GET /api/categories` - Listar todas as categorias
- `GET /api/categories/{id}` - Buscar categoria por ID
- `POST /api/categories` - Criar nova categoria
- `PUT /api/categories/{id}` - Atualizar categoria
- `DELETE /api/categories/{id}` - Excluir categoria

### Conteúdos (`/api/contents`)
- `GET /api/contents` - Listar todos os conteúdos
- `GET /api/contents/{id}` - Buscar conteúdo por ID
- `POST /api/contents` - Criar novo conteúdo
- `PUT /api/contents/{id}` - Atualizar conteúdo
- `DELETE /api/contents/{id}` - Excluir conteúdo

## 📊 Dados Culturais

O sistema trabalha com dados culturais indígenas incluindo:
- 5 categorias culturais: Histórias e Lendas, Artesanato, Música e Dança, Rituais e Cerimônias, Linguagem e Comunicação
- 8 conteúdos culturais: Uirapuru, Arte Marajoara, Toré dos Fulni-ô, Mandioca, Trançado Yanomami, Pintura Corporal Kadiwéu, Ritual do Quarup, Língua Guarani

## 🚀 Scripts Disponíveis

```bash
./mvnw spring-boot:run    # Inicia aplicação em desenvolvimento
./mvnw clean package      # Build para produção
./mvnw compile           # Compila o projeto
./mvnw clean             # Limpa build anterior
```

## 🤝 Contribuição

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** suas mudanças seguindo Conventional Commits (`git commit -m 'feat: minha feature'`)
4. **Push** para a branch (`git push origin feature/AmazingFeature`)
5. Abra um **Pull Request**

### Padrões de Commit
Este projeto segue o padrão [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/):
- `feat:` novas funcionalidades
- `fix:` correções de bugs
- `docs:` documentação
- `style:` formatação de código
- `refactor:` refatoração
- `chore:` tarefas de manutenção

## 👥 Autores

- **Davi Sodré Gonçalves** - Desenvolvimento inicial

## 🙏 Agradecimentos

- Comunidades indígenas brasileiras - Inspiração e propósito
- Professores e orientadores - Apoio e mentoria
- Comunidade open source - Ferramentas e bibliotecas
- Spring Framework - Framework robusto para APIs
- MySQL - Banco de dados confiável

## 🔗 Links Úteis

- [Frontend Repository](../tekoa-hub-frontend)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/)
