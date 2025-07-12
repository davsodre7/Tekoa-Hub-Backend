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

## 🚀 Tecnologias Utilizadas

### **Core Framework**
- **Java 17** - Linguagem de programação principal
- **Spring Boot 3.5.3** - Framework para aplicações Java
- **Spring Data JPA** - Persistência de dados
- **Maven** - Gerenciador de dependências

### **Database & Persistence**
- **MySQL 8.0+** - Banco de dados principal
- **Hibernate** - ORM para mapeamento objeto-relacional
- **Jakarta Validation** - Validação de dados

### **Security & Utilities**
- **Spring Security Crypto** - Criptografia de dados sensíveis
- **Lombok** - Redução de boilerplate code
- **Spring Web** - Construção de APIs REST

## 📋 Pré-requisitos

- **Java 17+**
- **Maven 3.8+**
- **MySQL 8.0+** rodando localmente

## 🚀 Como Executar o Backend

### **Passo a Passo Completo**

#### 1. **Clone o repositório**
```bash
git clone <url-do-repositorio>
cd tekoa-hub-backend
```

#### 2. **Configure o banco de dados MySQL**
O projeto utiliza MySQL como banco de dados principal para armazenar os dados culturais indígenas.

**Certifique-se de que o MySQL está rodando** e edite `src/main/resources/application.properties` se necessário:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tekoa_db?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

#### 3. **Build e execute o projeto**
```bash
./mvnw spring-boot:run
# ou
mvn spring-boot:run
```

#### 4. **Acesse a aplicação**
O backend estará disponível em: **http://localhost:8080**

#### 5. **Verifique o funcionamento**
Teste os endpoints da API:
```bash
# Listar categorias
curl http://localhost:8080/api/categories

# Listar conteúdos
curl http://localhost:8080/api/contents
```

### **Comandos Rápidos**

```bash
# Executar em desenvolvimento
./mvnw spring-boot:run

# Build para produção
./mvnw clean package

# Executar testes
./mvnw test

# Compilar apenas
./mvnw compile

# Limpar build anterior
./mvnw clean
```

### **Verificação de Funcionamento**

1. **Acesse a API** em `http://localhost:8080/api/categories`
2. **Verifique se retorna** a lista de categorias em JSON
3. **Teste o endpoint** `/api/contents` para listar conteúdos
4. **Confirme que o banco** foi criado automaticamente (`tekoa_db`)

### **Solução de Problemas**

#### **Erro: "MySQL connection failed"**
- Verifique se o MySQL está rodando: `sudo systemctl status mysql`
- Confirme as credenciais no `application.properties`
- Teste a conexão: `mysql -u root -p`

#### **Erro: "Port 8080 already in use"**
```bash
# Encontre o processo usando a porta
netstat -tulpn | grep :8080

# Mate o processo ou use uma porta diferente
# Adicione ao application.properties:
server.port=8081
```


### **Acesso ao Banco de Dados (Opcional)**

Para visualizar os dados diretamente no MySQL:
- Use um cliente MySQL como **MySQL Workbench**, **phpMyAdmin** ou **DBeaver**
- Conecte-se ao banco `tekoa_db` na porta 3306
- Usuário: `root`, Senha: `root`

### **Dados Iniciais**

O sistema carrega automaticamente dados culturais indígenas incluindo:
- **5 categorias culturais**: Histórias e Lendas, Artesanato, Música e Dança, Rituais e Cerimônias, Linguagem e Comunicação
- **8 conteúdos culturais**: Uirapuru, Arte Marajoara, Toré dos Fulni-ô, Mandioca, Trançado Yanomami, Pintura Corporal Kadiwéu, Ritual do Quarup, Língua Guarani

## 🔧 Configuração

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
│   │   │   ├── SecurityConfig.java        # Configuração de segurança
│   │   │   └── WebConfig.java             # Configuração web/CORS
│   │   ├── exception/    # Tratamento global de erros
│   │   │   ├── ApiError.java              # Modelo de erro da API
│   │   │   └── GlobalExceptionHandler.java # Handler global
│   │   └── TekoaHubApplication.java       # Classe principal
│   └── resources/
│       ├── application.properties          # Configurações principais
│       └── static/                        # Arquivos estáticos
└── test/
    ├── java/com/tekoahub/
    │   └── TekoaHubApplicationTests.java  # Testes da aplicação
    └── resources/
        └── application-test.properties     # Configurações de teste
```

## 🗄️ Arquitetura do Banco de Dados

O MySQL é o banco de dados principal do Tekoá Hub, responsável por:

### **Entidades Principais:**
- **Category**: Categorias culturais (ex: Artesanato, Dança, Música, Culinária)
- **Content**: Conteúdos culturais específicos com imagens, descrições e categorias

### **Funcionalidades do Banco:**
- **Persistência robusta**: Armazena dados culturais indígenas de forma permanente
- **Relacionamentos**: Mantém integridade referencial entre categorias e conteúdos
- **Busca otimizada**: Índices para consultas rápidas de conteúdos por categoria
- **Escalabilidade**: Suporte a grande volume de dados culturais
- **Backup e recuperação**: Estratégias de backup para preservar dados culturais

### **Ambientes:**
- **Desenvolvimento**: `tekoa_db` - Banco principal para desenvolvimento
- **Testes**: `tekoa_test_db` - Banco isolado para execução de testes automatizados

## 📱 Funcionalidades

### **CRUD Completo**
- ✅ **Category** - Gerenciamento completo de categorias culturais
- ✅ **Content** - Gerenciamento completo de conteúdos culturais

### **API RESTful**
- ✅ **Endpoints documentados** para todas as operações
- ✅ **Validação de dados** com Jakarta Validation
- ✅ **Tratamento global de exceções** com respostas padronizadas
- ✅ **Configuração de CORS** para integração com frontend
- ✅ **Criptografia de dados** sensíveis com Spring Security

### **Integração e Performance**
- ✅ **Integração com MySQL** para persistência robusta
- ✅ **Organização em pacotes** por responsabilidade
- ✅ **Mapeamento objeto-relacional** com JPA/Hibernate
- ✅ **DTOs para transferência** de dados otimizada

## 🔌 API Endpoints

O backend expõe endpoints REST para integração com o frontend React:

### **Categorias (`/api/categories`)**
- `GET /api/categories` - Listar todas as categorias
- `GET /api/categories/{id}` - Buscar categoria por ID
- `POST /api/categories` - Criar nova categoria
- `PUT /api/categories/{id}` - Atualizar categoria
- `DELETE /api/categories/{id}` - Excluir categoria

### **Conteúdos (`/api/contents`)**
- `GET /api/contents` - Listar todos os conteúdos
- `GET /api/contents/{id}` - Buscar conteúdo por ID
- `POST /api/contents` - Criar novo conteúdo
- `PUT /api/contents/{id}` - Atualizar conteúdo
- `DELETE /api/contents/{id}` - Excluir conteúdo

### **Exemplos de Uso**

#### Criar uma categoria:
```bash
POST /api/categories
Content-Type: application/json

{
  "name": "Artesanato",
  "description": "Artesanato tradicional indígena",
  "color": "#8B4513"
}
```

#### Criar um conteúdo:
```bash
POST /api/contents
Content-Type: application/json

{
  "title": "Uirapuru: O Pássaro Místico",
  "description": "O uirapuru é uma ave lendária da Amazônia...",
  "type": "story",
  "ethnicity": "Diversas",
  "region": "Amazônia",
  "imageUrl": "/assets/Uirapuru.jpg",
  "creator": "Anônimo",
  "categoryId": 1
}
```

## 📊 Dados Culturais

O sistema trabalha com dados culturais indígenas incluindo:
- **5 categorias culturais**: Histórias e Lendas, Artesanato, Música e Dança, Rituais e Cerimônias, Linguagem e Comunicação
- **8 conteúdos culturais**: Uirapuru, Arte Marajoara, Toré dos Fulni-ô, Mandioca, Trançado Yanomami, Pintura Corporal Kadiwéu, Ritual do Quarup, Língua Guarani

### **Exemplo de Categoria:**
```json
{
  "id": 1,
  "name": "Histórias e Lendas",
  "description": "Narrativas tradicionais e lendas dos povos indígenas",
  "color": "#8B4513"
}
```

### **Exemplo de Conteúdo:**
```json
{
  "id": 1,
  "title": "Uirapuru: O Pássaro Místico",
  "description": "O uirapuru é uma ave lendária da Amazônia...",
  "type": "story",
  "ethnicity": "Diversas",
  "region": "Amazônia",
  "imageUrl": "/assets/Uirapuru.jpg",
  "creator": "Anônimo",
  "category": {
    "id": 1,
    "name": "Histórias e Lendas"
  }
}
```

## 🚀 Scripts Disponíveis

```bash
./mvnw spring-boot:run    # Inicia aplicação em desenvolvimento
./mvnw clean package      # Build para produção
./mvnw test              # Executa testes
./mvnw compile           # Compila o projeto
./mvnw clean             # Limpa build anterior
```

## 🧪 Testes

Para executar os testes:
```bash
./mvnw test
```

Os testes utilizam um banco MySQL separado (`tekoa_test_db`) para garantir isolamento.

### **Configuração de Teste**
- Banco isolado: `tekoa_test_db`
- DDL automático: `create-drop`
- Dados de teste carregados automaticamente

## 🔒 Segurança

- **Configuração de CORS** para integração com frontend
- **Validação de dados** de entrada com Jakarta Validation
- **Tratamento global de exceções** com respostas padronizadas
- **Criptografia de dados** sensíveis com Spring Security Crypto

## 🚀 Deploy

### **Desenvolvimento Local**
```bash
./mvnw spring-boot:run
```

### **Build para Produção**
```bash
./mvnw clean package
java -jar target/tekoa-hub-backend-0.0.1-SNAPSHOT.jar
```

### **Docker (opcional)**
```bash
docker build -t tekoa-hub-backend .
docker run -p 8080:8080 tekoa-hub-backend
```

## 🤝 Contribuição

1. **Fork** o projeto
2. Crie uma **branch** para sua feature (`git checkout -b feature/AmazingFeature`)
3. **Commit** suas mudanças seguindo Conventional Commits (`git commit -m 'feat: minha feature'`)
4. **Push** para a branch (`git push origin feature/AmazingFeature`)
5. Abra um **Pull Request**

### **Padrões de Commit**
Este projeto segue o padrão [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/):
- `feat:` novas funcionalidades
- `fix:` correções de bugs
- `docs:` documentação
- `style:` formatação de código
- `refactor:` refatoração
- `test:` testes
- `chore:` tarefas de manutenção

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👥 Autores

- **Davi Sodré Gonçalves** - Desenvolvimento inicial

## 🙏 Agradecimentos

- **Comunidades indígenas brasileiras** - Inspiração e propósito
- **Professores e orientadores** - Apoio e mentoria
- **Comunidade open source** - Ferramentas e bibliotecas
- **Spring Framework** - Framework robusto para APIs
- **MySQL** - Banco de dados confiável

## 🔗 Links Úteis

- [Frontend Repository](../tekoa-hub-frontend)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/)

---

**Tekoá Hub** - Preservando e valorizando a cultura indígena brasileira através da tecnologia.
