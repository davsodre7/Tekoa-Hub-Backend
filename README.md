# 🏛️ Tekoá Hub - Backend

**Versão submetida:** Intermediária (Nível Padrão)  
**Público-alvo:** Povos Indígenas  
**ODS:** ODS 4 – Educação de Qualidade, ODS 10 – Redução das Desigualdades

Backend do Tekoá Hub: API para preservação e valorização da cultura indígena brasileira.

## 🎯 Sobre o Projeto

O Tekoá Hub é uma plataforma digital dedicada à preservação e divulgação da cultura indígena brasileira. O backend expõe uma API RESTful para cadastro, consulta, edição e exclusão de conteúdos culturais e categorias, integrando-se ao frontend React.

### Público-Alvo
- **Povos Indígenas** - Para preservar e compartilhar sua cultura
- **Educadores** - Para usar em sala de aula
- **Público Geral** - Para conhecer e valorizar a cultura indígena

### ODS Alinhadas
- **ODS 4 - Educação de Qualidade**: Promovendo educação inclusiva sobre cultura indígena
- **ODS 10 - Redução das Desigualdades**: Valorizando e preservando culturas minoritárias

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL** (produção) / **H2** (desenvolvimento)
- **Maven**
- **Lombok**

## 📋 Pré-requisitos

- Java 17+
- Maven 3.8+
- (Opcional) MySQL rodando, caso queira testar com banco real

## 🔧 Configuração

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd tekoa-hub-backend
```

### 2. Configure o banco de dados
- Por padrão, o projeto usa H2 em memória para desenvolvimento.
- Para usar MySQL, edite `src/main/resources/application.properties`:
  ```properties
  spring.datasource.url=jdbc:mysql://localhost:3306/tekoa_db
  spring.datasource.username=seu_usuario
  spring.datasource.password=sua_senha
  spring.jpa.hibernate.ddl-auto=update
  spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
  ```

### 3. Build e execute
```bash
./mvnw spring-boot:run
```
O backend estará disponível em: [http://localhost:8080](http://localhost:8080)

### 4. Acesse o console H2 (opcional)
- [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- JDBC URL: `jdbc:h2:mem:tekoa_db`

## 🏗️ Estrutura do Projeto

```
src/
├── main/
│   ├── java/com/tekoahub/
│   │   ├── controller/   # Controllers REST
│   │   ├── service/      # Lógica de negócio
│   │   ├── repository/   # Acesso a dados (JPA)
│   │   ├── model/        # Entidades
│   │   ├── dto/          # Data Transfer Objects
│   │   ├── mapper/       # Conversão entre entidades e DTOs
│   │   ├── config/       # Configurações (CORS, segurança)
│   │   └── exception/    # Tratamento global de erros
│   └── resources/
│       └── application.properties
└── test/
```

## 📱 Funcionalidades

- CRUD completo para as entidades:
  - **Category** (Categoria de conteúdo cultural)
  - **Content** (Conteúdo cultural: histórias, arte, música, etc)
- Endpoints REST documentados
- Integração com banco de dados relacional (MySQL/H2)
- Organização em pacotes por responsabilidade
- Tratamento global de exceções
- Configuração de CORS e segurança básica

## 🔌 Integração com Frontend

O backend expõe endpoints REST para integração com o frontend React:

### Endpoints Principais
- `GET /api/categories` - Listar categorias
- `POST /api/categories` - Criar categoria
- `PUT /api/categories/{id}` - Atualizar categoria
- `DELETE /api/categories/{id}` - Excluir categoria
- `GET /api/contents` - Listar conteúdos
- `POST /api/contents` - Criar conteúdo
- `PUT /api/contents/{id}` - Atualizar conteúdo
- `DELETE /api/contents/{id}` - Excluir conteúdo

> Para detalhes de cada endpoint, consulte o arquivo [API.md](./API.md).

## 📊 Dados de Exemplo

O backend inclui dados de exemplo com:
- 5 categorias culturais
- 8 conteúdos culturais
- Imagens e descrições completas

## 🤝 Contribuição

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b minha-feature`)
3. Commit suas mudanças seguindo Conventional Commits (`git commit -m 'feat: minha feature'`)
4. Push para a branch (`git push origin minha-feature`)
5. Abra um Pull Request

## 📝 Commits

Este projeto segue o padrão [Conventional Commits](https://www.conventionalcommits.org/pt-br/v1.0.0/).

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👥 Autores

- **Seu Nome** - Desenvolvimento inicial
- **Outros Participantes** (se houver)

## 🙏 Agradecimentos

- Comunidades indígenas brasileiras
- Professores e orientadores
- Comunidade open source

---
