# JUnit 5 - Exemplos Práticos

Este projeto demonstra o uso prático do JUnit 5 para testes unitários em Java, apresentando exemplos de classes de domínio e seus respectivos testes.

## 📋 Sobre o Projeto

Este repositório contém exemplos práticos de testes unitários utilizando JUnit 5, com foco em demonstrar diferentes tipos de asserções e cenários de teste. O projeto inclui duas classes principais (`Conta` e `Pessoa`) e seus respectivos testes unitários.

## 🏗️ Estrutura do Projeto

```bash
src/
├── main/java/one/digitalinnovation/junit/
│   ├── Conta.java          # Classe que representa uma conta bancária
│   └── Pessoa.java         # Classe que representa uma pessoa
└── test/java/one/digitalinnovation/junit/
    ├── ContaTest.java      # Testes unitários para a classe Conta
    └── PessoaTest.java     # Testes unitários para a classe Pessoa
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

## 🧪 Testes Unitários

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

### PessoaTest.java

Testa as funcionalidades da classe `Pessoa` com os seguintes cenários:

- ✅ **Verificação de maioridade**: Testa pessoas menores e maiores de idade
- ✅ **Testes agrupados**: Utiliza `assertAll` para múltiplas verificações
- ⏸️ **Teste desabilitado**: Exemplo de teste marcado com `@Disabled`

**Exemplo de teste:**

```java
@Test
void deveRetornarSeEhMaiorDeIdade(){
    Pessoa joao = new Pessoa("Joãozinho", LocalDateTime.of(2020, 1, 1, 15, 0));
    Assertions.assertFalse(joao.ehMaiorDeIdade());

    Pessoa darieldon = new Pessoa("Darieldon", LocalDateTime.of(1994, 11, 9, 12, 50));
    Assertions.assertTrue(darieldon.ehMaiorDeIdade());
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
   mvn test -Dtest=ContaTest
   mvn test -Dtest=PessoaTest
   ```

4. **Compile o projeto:**

   ```bash
   mvn compile
   ```

5. **Execute o projeto completo:**

   ```bash
   mvn clean install
   ```

## 📊 Relatórios de Teste

Após executar os testes, você pode encontrar os relatórios em:

- `target/surefire-reports/` - Relatórios detalhados dos testes

## 🎯 Conceitos Demonstrados

Este projeto demonstra os seguintes conceitos do JUnit 5:

- **Asserções básicas**: `assertEquals`, `assertNotEquals`, `assertTrue`, `assertFalse`
- **Verificação de nulos**: `assertNull`, `assertNotNull`
- **Testes agrupados**: `assertAll` para múltiplas verificações
- **Anotações**: `@Test`, `@Disabled`
- **Testes parametrizados**: Uso de listas para múltiplos cenários

## 📝 Padrões de Teste Utilizados

1. **Arrange-Act-Assert (AAA)**: Organização clara dos testes
2. **Testes independentes**: Cada teste é executado de forma isolada
3. **Nomes descritivos**: Métodos de teste com nomes que descrevem o comportamento
4. **Cobertura de cenários**: Testes para casos positivos e negativos

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
