# JUnit 5 - Exemplos Práticos e Avançados

Este projeto demonstra o uso prático e avançado do JUnit 5 para testes unitários em Java, apresentando exemplos abrangentes de classes de domínio, simulação de banco de dados e diversos cenários de teste.

## 📋 Sobre o Projeto

Este repositório contém exemplos práticos e avançados de testes unitários utilizando JUnit 5, com foco em demonstrar diferentes tipos de asserções, cenários de teste, lifecycle de testes, execução condicional, ordenação de testes e tratamento de exceções. O projeto inclui quatro classes principais e oito classes de teste que cobrem diversos aspectos do framework JUnit 5.

## 🏗️ Estrutura do Projeto

```bash
src/
├── main/java/one/digitalinnovation/junit/
│   ├── BancoDeDados.java           # Simulação de operações de banco de dados
│   ├── Conta.java                  # Classe que representa uma conta bancária
│   ├── Pessoa.java                 # Classe que representa uma pessoa
│   └── TransferenciaEntreContas.java # Classe para transferências entre contas
└── test/java/one/digitalinnovation/junit/
    ├── AssertionTest.java          # Exemplos de diferentes tipos de asserções
    ├── AssumptionsTest.java        # Testes com assumptions (condicionais)
    ├── CondicionaisTest.java       # Testes condicionais com anotações
    ├── ConsultarDadosDePessoaTest.java # Testes com lifecycle (@BeforeAll, @AfterAll, etc.)
    ├── ContaTest.java              # Testes unitários para a classe Conta
    ├── EscolhendoAOrdemTest.java   # Exemplos de ordenação de execução de testes
    ├── ExceptionsTest.java         # Testes de tratamento de exceções
    └── PessoaTest.java             # Testes unitários para a classe Pessoa
```

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **JUnit 5 (Jupiter) 6.0.0-RC3**
- **Maven 3.8.0**
- **Maven Surefire Plugin 2.22.1**

## 📦 Dependências

O projeto utiliza as seguintes dependências principais:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>6.0.0-RC3</version>
    <scope>test</scope>
</dependency>
```

## 🏛️ Classes do Domínio

### BancoDeDados.java

Classe utilitária que simula operações de banco de dados com logging para demonstrar lifecycle de testes.

**Métodos estáticos:**

- `iniciarConexao()`: Simula o início de uma conexão com banco de dados
- `finalizarConexao()`: Simula o fechamento de uma conexão com banco de dados
- `inserirDados(Pessoa pessoa)`: Simula inserção de dados no banco
- `removerDados(Pessoa pessoa)`: Simula remoção de dados do banco

**Uso:** Utilizada nos testes para demonstrar anotações de lifecycle (`@BeforeAll`, `@AfterAll`, `@BeforeEach`, `@AfterEach`).

### Conta.java

Classe que representa uma conta bancária com funcionalidades básicas de crédito e débito.

**Atributos:**

- `numeroConta` (String): Número identificador da conta
- `saldo` (double): Valor atual do saldo

**Métodos:**

- `getSaldo()`: Retorna o saldo atual
- `lancaCredito(double valor)`: Adiciona valor ao saldo
- `lancaDebito(double valor)`: Subtrai valor do saldo

### Pessoa.java

Classe que representa uma pessoa com funcionalidades para cálculo de idade e verificação de maioridade.

**Atributos:**

- `nome` (String): Nome da pessoa
- `nascimento` (LocalDateTime): Data e hora de nascimento

**Métodos:**

- `getNome()`: Retorna o nome da pessoa
- `getNascimento()`: Retorna a data de nascimento
- `getIdade()`: Calcula e retorna a idade em anos
- `ehMaiorDeIdade()`: Verifica se a pessoa é maior de idade (≥ 18 anos)

### TransferenciaEntreContas.java

Classe que gerencia transferências entre contas bancárias com validação de valores.

**Métodos:**

- `transfere(Conta contaOrigem, Conta contaDestino, int valor)`: Executa transferência entre contas
  - Valida se o valor é maior que zero
  - Lança `IllegalArgumentException` para valores inválidos

## 🧪 Testes Unitários

### AssertionTest.java

Demonstra diferentes tipos de asserções do JUnit 5:

- ✅ **Comparação de arrays**: `assertArrayEquals` para validar arrays idênticos
- ✅ **Verificação de nulos**: `assertNull` e `assertNotNull` para objetos nulos/não nulos
- ✅ **Comparação de números**: `assertEquals` para valores numéricos de tipos diferentes

**Exemplos de asserções:**

```java
@Test
void validarLancamentos(){
    int[] primeiroLancamento = {10, 20, 30, 40, 50};
    int[] segundoLancamento = {10, 20, 30, 40, 50};
    assertArrayEquals(primeiroLancamento, segundoLancamento);
}

@Test
void validarSeObjetoEstaNulo(){
    Pessoa pessoa = null;
    assertNull(pessoa);

    pessoa = new Pessoa("Lucian", LocalDateTime.now());
    assertNotNull(pessoa);
}
```

### AssumptionsTest.java

Demonstra o uso de assumptions para execução condicional de testes:

- ✅ **Assumptions**: `assumeTrue` para executar testes apenas sob certas condições
- ✅ **Execução condicional**: Teste executa apenas se a condição for verdadeira

**Exemplo:**

```java
@Test
void validarAlgoSomenteNoUsuarioDarieldon(){
    assumeTrue("seu_username".equals(System.getenv("USERNAME")));
    assertEquals(10, 5 + 5);
}
```

### CondicionaisTest.java

Demonstra execução condicional usando anotações do JUnit 5:

- ✅ **Anotações condicionais**: `@EnabledIfEnvironmentVariable` para execução baseada em variáveis de ambiente
- ✅ **Execução seletiva**: Teste executa apenas se a variável de ambiente corresponder ao padrão

**Exemplo:**

```java
@Test
@EnabledIfEnvironmentVariable(named = "USERNAME", matches = "seu_username")
void validarAlgoSomenteNoUsuarioDarieldon(){
    assertEquals(10, 5 + 5);
}
```

### ConsultarDadosDePessoaTest.java

Demonstra o lifecycle completo de testes com anotações de setup e teardown:

- ✅ **Lifecycle de testes**: `@BeforeAll`, `@AfterAll`, `@BeforeEach`, `@AfterEach`
- ✅ **Setup e teardown**: Configuração e limpeza de dados para cada teste
- ✅ **Simulação de banco**: Uso da classe `BancoDeDados` para demonstrar operações

**Exemplo de lifecycle:**

```java
@BeforeAll
static void configuraConexao(){
    BancoDeDados.iniciarConexao();
}

@BeforeEach
void insereDadosParaTeste(){
    BancoDeDados.inserirDados(new Pessoa("João", LocalDateTime.of(2000, 1, 1, 13, 0)));
}

@AfterEach
void removeDadosParaTeste(){
    BancoDeDados.removerDados(new Pessoa("João", LocalDateTime.of(2000, 1, 1, 13, 0)));
}

@AfterAll
static void finalizaConexao(){
    BancoDeDados.finalizarConexao();
}
```

### ContaTest.java

Testa as funcionalidades da classe `Conta` com os seguintes cenários:

- ✅ **Validação de saldo**: Testa operações de crédito e débito
- ✅ **Verificação de valores**: Confirma valores esperados e inesperados
- ✅ **Verificação de nulos**: Testa objetos nulos e não nulos

**Exemplo de teste:**

```java
@Test
void validaSaldo(){
    Conta conta = new Conta("123456", 100);
    Assertions.assertNotNull(conta);

    conta.lancaCredito(50);
    Assertions.assertEquals(150, conta.getSaldo());

    conta.lancaDebito(50);
    Assertions.assertEquals(100, conta.getSaldo());
}
```

### EscolhendoAOrdemTest.java

Demonstra controle de ordem de execução de testes:

- ✅ **Ordenação de testes**: `@TestMethodOrder` com `MethodOrderer.OrderAnnotation.class`
- ✅ **Anotações de ordem**: `@Order` para definir sequência de execução
- ✅ **Display names**: `@DisplayName` para nomes personalizados nos relatórios

**Exemplo de ordenação:**

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EscolhendoAOrdemTest {

    @DisplayName("A")
    @Order(4)
    @Test
    void validaFluxoA(){
        assertTrue(true);
    }

    @DisplayName("D")
    @Order(1)
    @Test
    void validaFluxoD(){
        assertTrue(true);
    }
}
```

### ExceptionsTest.java

Demonstra teste de exceções e tratamento de erros:

- ✅ **Teste de exceções**: `assertThrows` para verificar se exceções são lançadas
- ✅ **Teste de não exceções**: `assertDoesNotThrow` para verificar execução sem erros
- ✅ **Validação de tipos de exceção**: Verificação de tipos específicos de exceção

**Exemplo de teste de exceções:**

```java
@Test
void validarCenarioDeExcecaoNaTransferencia(){
    Conta contaOrigem = new Conta("123456", 0);
    Conta contaDestino = new Conta("456548", 100);
    TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

    assertThrows(IllegalArgumentException.class,
        () -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, -1));

    assertDoesNotThrow(() ->
        transferenciaEntreContas.transfere(contaOrigem, contaDestino, 100));
}
```

### PessoaTest.java

Testa as funcionalidades da classe `Pessoa` com os seguintes cenários:

- ✅ **Verificação de maioridade**: Testa pessoas menores e maiores de idade
- ✅ **Verificação de idade**: Testa o retorno da idade utilizando `assertEquals`
- ✅ **Testes agrupados**: Utiliza `assertAll` para múltiplas verificações

**Exemplos de testes:**

```java
@Test
void deveCalcularIdadeCorretamente(){
    Pessoa jessica = new Pessoa("Jéssica", LocalDateTime.of(2000, 1, 1, 15, 0, 0));
    Assertions.assertEquals(25, jessica.getIdade());
}

@Test
void deveRetornarSeEhMaiorDeIdade(){
    Pessoa joao = new Pessoa("Joãozinho", LocalDateTime.of(2020, 1, 1, 15, 0));
    Assertions.assertFalse(joao.ehMaiorDeIdade());

    Pessoa darieldon = new Pessoa("Darieldon", LocalDateTime.of(1994, 11, 9, 12, 50));
    Assertions.assertTrue(darieldon.ehMaiorDeIdade());

    // Teste agrupado com assertAll
    List<Pessoa> pessoas = List.of(new Pessoa("Julia", LocalDateTime.now()),
                                  new Pessoa("Maria", LocalDateTime.now()));
    Assertions.assertAll("pessoas",
        () -> Assertions.assertFalse(pessoas.get(0).ehMaiorDeIdade()),
        () -> Assertions.assertFalse(pessoas.get(1).ehMaiorDeIdade())
    );
}
```

## 🛠️ Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

### Executando os Testes

1. **Clone o repositório:**

   ```bash
   git clone <url-do-repositorio>
   cd junit5-exemplos
   ```

2. **Execute os testes:**

   ```bash
   mvn test
   ```

3. **Execute um teste específico:**

   ```bash
   # Testes de classes específicas
   mvn test -Dtest=ContaTest
   mvn test -Dtest=PessoaTest
   mvn test -Dtest=AssertionTest
   mvn test -Dtest=ExceptionsTest

   # Testes com lifecycle
   mvn test -Dtest=ConsultarDadosDePessoaTest

   # Testes condicionais
   mvn test -Dtest=CondicionaisTest
   mvn test -Dtest=AssumptionsTest

   # Testes com ordenação
   mvn test -Dtest=EscolhendoAOrdemTest
   ```

4. **Execute testes por padrão:**

   ```bash
   # Todos os testes que começam com "Conta"
   mvn test -Dtest=Conta*

   # Todos os testes que contêm "Test"
   mvn test -Dtest=*Test
   ```

5. **Compile o projeto:**

   ```bash
   mvn compile
   ```

6. **Execute o projeto completo:**

   ```bash
   mvn clean install
   ```

7. **Execute testes condicionais:**

   ```bash
   # Para executar testes que dependem de variáveis de ambiente
   # Defina a variável USERNAME antes de executar
   set USERNAME=seu_username && mvn test -Dtest=CondicionaisTest
   set USERNAME=seu_username && mvn test -Dtest=AssumptionsTest

   # No Linux/Mac
   USERNAME=seu_username mvn test -Dtest=CondicionaisTest
   USERNAME=seu_username mvn test -Dtest=AssumptionsTest
   ```

## 📊 Relatórios de Teste

Após executar os testes, você pode encontrar os relatórios em:

- `target/surefire-reports/` - Relatórios detalhados dos testes

## 🎯 Conceitos Demonstrados

Este projeto demonstra os seguintes conceitos do JUnit 5:

### 🔧 Asserções e Validações

- **Asserções básicas**: `assertEquals`, `assertNotEquals`, `assertTrue`, `assertFalse`
- **Verificação de nulos**: `assertNull`, `assertNotNull`
- **Comparação de arrays**: `assertArrayEquals` para validação de arrays
- **Testes agrupados**: `assertAll` para múltiplas verificações em um único teste
- **Comparação de tipos diferentes**: `assertEquals` com tipos numéricos diferentes

### 🎭 Lifecycle e Controle de Execução

- **Lifecycle de testes**: `@BeforeAll`, `@AfterAll`, `@BeforeEach`, `@AfterEach`
- **Setup e teardown**: Configuração e limpeza de dados para cada teste
- **Ordenação de testes**: `@TestMethodOrder` com `MethodOrderer.OrderAnnotation.class`
- **Anotações de ordem**: `@Order` para definir sequência de execução
- **Display names**: `@DisplayName` para nomes personalizados nos relatórios

### ⚡ Execução Condicional

- **Assumptions**: `assumeTrue` para execução condicional de testes
- **Anotações condicionais**: `@EnabledIfEnvironmentVariable` para execução baseada em variáveis de ambiente
- **Execução seletiva**: Testes que executam apenas sob certas condições

### 🚨 Tratamento de Exceções

- **Teste de exceções**: `assertThrows` para verificar se exceções são lançadas
- **Teste de não exceções**: `assertDoesNotThrow` para verificar execução sem erros
- **Validação de tipos de exceção**: Verificação de tipos específicos de exceção

### 🏗️ Padrões e Boas Práticas

- **Arrange-Act-Assert (AAA)**: Organização clara dos testes
- **Testes independentes**: Cada teste é executado de forma isolada
- **Nomes descritivos**: Métodos de teste com nomes que descrevem o comportamento
- **Cobertura de cenários**: Testes para casos positivos e negativos
- **Simulação de dependências**: Uso de classes mock para simular operações externas

## 🤝 Contribuição

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/nova-feature`)
5. Abra um Pull Request

## 👨‍💻 Autor

**Darieldon Medeiros.**

- GitHub: [DarieldonMedeiros](https://github.com/darieldonmedeiros)

---

_Este projeto foi criado como parte do curso da Digital Innovation One (DIO) para demonstrar práticas de testes unitários com JUnit 5._
