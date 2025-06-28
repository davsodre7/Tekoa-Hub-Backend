# Tekoá Hub - Backend

**Versão submetida:** Intermediária (Nível Padrão)  
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

## Deploy

- O deploy pode ser feito gratuitamente no [Render](https://render.com/) (backend) e [Vercel/Netlify](https://vercel.com/) (frontend).
- O link do deploy, se disponível, deve ser informado aqui.

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

# 🚀 Deploy Scripts - Backend Tekoá Hub

Este diretório contém scripts para facilitar o deploy e gerenciamento do repositório GitHub do backend.

## 📁 Arquivos de Script

### 1. `setup-github.sh` - Configuração Inicial
Script para configurar o repositório GitHub pela primeira vez.

**Funcionalidades:**
- ✅ Verifica pré-requisitos (Git instalado)
- ✅ Configura Git global se necessário
- ✅ Inicializa repositório Git local
- ✅ Configura repositório remoto no GitHub
- ✅ Faz primeiro commit e push
- ✅ Cria branch main

**Como usar:**
```bash
# Tornar executável
chmod +x setup-github.sh

# Executar
./setup-github.sh
```

### 2. `deploy.sh` - Deploy Contínuo
Script para fazer deploy de atualizações para o GitHub.

**Funcionalidades:**
- ✅ Verifica mudanças no repositório
- ✅ Adiciona arquivos ao staging
- ✅ Solicita mensagem de commit
- ✅ Faz commit e push
- ✅ Trata primeiro push automaticamente
- ✅ Exibe informações do repositório

**Como usar:**
```bash
# Tornar executável
chmod +x deploy.sh

# Executar
./deploy.sh
```

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

### Deploy Contínuo

Após a configuração inicial, use o script de deploy:

```bash
chmod +x deploy.sh
./deploy.sh
```

O script irá:
1. Verificar se há mudanças
2. Adicionar arquivos modificados
3. Solicitar mensagem de commit
4. Fazer push para o GitHub

## 🎯 Fluxo de Trabalho Recomendado

### Para Desenvolvedores

1. **Desenvolva suas mudanças**
   ```bash
   # Faça suas alterações no código
   # Teste localmente
   ```

2. **Deploy para GitHub**
   ```bash
   ./deploy.sh
   ```

3. **Verifique no GitHub**
   - Acesse: https://github.com/seu-usuario/tekoa-cultural-archive-hub-backend
   - Confirme que as mudanças estão lá

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

## 🔍 Troubleshooting

### Erro: "Git não está instalado"
```bash
# Ubuntu/Debian
sudo apt-get update
sudo apt-get install git

# macOS
brew install git

# Windows
# Baixe e instale do site oficial
```

### Erro: "Falha ao fazer push"
1. Verifique suas credenciais do GitHub
2. Confirme que o repositório existe
3. Verifique suas permissões
4. Teste a conexão: `git remote -v`

### Erro: "Repositório remoto não encontrado"
```bash
# Configure manualmente
git remote add origin https://github.com/seu-usuario/tekoa-cultural-archive-hub-backend.git
```

### Erro: "Branch não encontrada"
```bash
# Crie a branch main
git checkout -b main
git push --set-upstream origin main
```

## 📊 Comandos Úteis

### Verificar Status
```bash
git status
git log --oneline -5
git remote -v
```

### Atualizar Local
```bash
git pull origin main
```

### Ver Histórico
```bash
git log --oneline --graph
```

### Desfazer Último Commit
```bash
git reset --soft HEAD~1
```

## 🔗 Links Úteis

- **GitHub**: https://github.com
- **Documentação Git**: https://git-scm.com/doc
- **GitHub CLI**: https://cli.github.com
- **Git Credential Manager**: https://github.com/GitCredentialManager/git-credential-manager

## 📞 Suporte

Se encontrar problemas:

1. Verifique os logs do script
2. Consulte a documentação do Git
3. Verifique a documentação do GitHub
4. Abra uma issue no repositório

---

**Desenvolvido para o Tekoá Hub** 🏛️ 