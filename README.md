
---

## 📦 Projeto: Sistema de Cadastro com Java, SQL e Swing

### 🧰 Tecnologias Utilizadas
- **Java** – Lógica de programação e estrutura principal
- **Java Swing** – Interface gráfica (GUI)
- **JDBC + SQL** – Conexão e manipulação de banco de dados relacional
---

### 📋 Descrição
Este projeto é um sistema simples de cadastro e listagem de **Produtos** e **Categorias**, com interface gráfica desenvolvida em Java Swing e com persistência de dados via SQL.

O sistema permite:
- ✅ Cadastrar produtos com nome e preço
- ✅ Cadastrar categorias com nome e status ativo/inativo
- ✅ Listar produtos e categorias em uma interface com rolagem
- ✅ Conectar ao banco de dados e realizar operações CRUD

---

### 🖼️ Interface
A interface foi construída com **Java Swing**, utilizando componentes como:
- `JFrame`, `JPanel`, `JTextArea`, `JButton`, `JScrollPane`
- Mensagens de erro e sucesso com `JOptionPane`

---

### 🗃️ Estrutura do Projeto
```
src/
├── Data/
│   ├── ProdutoDAO.java
│   └── CategoriaDAO.java
├── Model/
│   ├── Produto.java
│   └── Categoria.java
└── Telas/
    ├── Listar.java
    └── Cadastro.java
```

---

### 🛠️ Como Executar
1. Clone o repositório:
   ```bash
   git clone https://github.com/VictorDumer/https://github.com/VictorDumer/Java-SQL-Att.git
   ```
2. Importe o projeto em sua IDE Java (Eclipse, IntelliJ, NetBeans etc.)
3. Configure o banco de dados:
   - Crie o banco e as tabelas necessárias
   - Atualize as credenciais de conexão no DAO
4. Execute a classe principal (ex: `Main.java`)

---

### 🗄️ Exemplo de Tabela SQL

```sql
CREATE TABLE Categoria (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    ativo BOOLEAN
);

CREATE TABLE Produto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    preco DOUBLE
);
```

---

### 🚨 Tratamento de Erros
- Mensagens amigáveis para falhas de conexão com o banco
- Validação de campos obrigatórios
- Logs no console para depuração

---

### 📌 Melhorias Futuras
- 🔍 Filtro de busca por nome
- ✏️ Edição de registros
- 🗑️ Exclusão de produtos e categorias

---

### 👨‍💻 Autor
- **Victor Dumer**
- GitHub: [@VictorDumer](https://github.com/VictorDumer)
- LinkedIn: [VictorDumer](https://linkedin.com/in/VictorDumer)

---
