# Aula: Domain-Driven Design (DDD) com Java + JDBC (Oracle) - Prof. Salatiel Luz Marinho

## Objetivos
- Implementar **Camada Model (Domínio)** com entidades ricas e regras de negócio.
- Expor **métodos relevantes** (lógica de domínio) em entidades/serviços.
- Criar **testes unitários** (JUnit + Mockito) para regras.
- Integrar com **Oracle Database** via JDBC.
- Implementar **DAO** com CRUD completo.

## Domínio de exemplo
*Agendamento de Consultas em Clínica* — entidades: `Paciente`, `Medico`, `Consulta` e caso de uso **agendar consulta** com regras.

## Execução rápida
```bash
# (1) Compilar e testar
mvn -q -e -DskipTests=false test

# (2) Criar tabelas no Oracle (rode o conteúdo de sql/schema.sql no seu banco)
# (3) Configure variáveis de ambiente para conexão:
#    ORACLE_URL="jdbc:oracle:thin:@//localhost:1521/FREEPDB1"
#    ORACLE_USER="system"
#    ORACLE_PASSWORD="oracle"

# (4) Integração: use ConsultaJdbcRepository em uma aplicação para agendar consultas
```

## Estrutura (camadas)
```
domain/
  model/ (Entidades ricas)
  service/ (Casos de uso / Domínio)
infra/
  db/ (ConnectionFactory)
  dao/ (DAO JDBC)
sql/ (DDL)
test/ (Testes JUnit/Mockito)
```

## Desafio de Fixação
Implemente as funcionalidades:
1. **Cancelamento de consulta** com regra: só pode cancelar até 24h antes; após isso, cobrar multa.
2. **Reagendamento** mantendo todas as validações de agendamento.
3. **Transação**: ao agendar, crie uma *log entry* em tabela `auditoria` na mesma transação (commit/rollback).
4. **Relatório**: método DAO para listar a agenda de um médico por dia, ordenada por horário.

> Dica: extraia uma interface `TransactionManager` e implemente uma `JdbcTransactionManager`.


## Executar aplicação principal (App.java)

Após compilar e testar, você pode rodar o exemplo principal que integra todas as camadas:

```bash
# Compilar o projeto
mvn clean compile

# Executar a classe principal
mvn exec:java -Dexec.mainClass="App"
```

### Pré-requisitos de ambiente

Antes de rodar, configure as variáveis de ambiente para acesso ao Oracle:

```bash
export ORACLE_URL="jdbc:oracle:thin:@//localhost:1521/FREEPDB1"
export ORACLE_USER="system"
export ORACLE_PASSWORD="oracle"
```

### O que o App faz?
1. Cria um `ConsultaJdbcRepository` (DAO com JDBC puro).
2. Injeta no `AgendaService` (camada de domínio).
3. Aplica todas as **regras de negócio** (antecedência, horário comercial, duração mínima, sem conflito).
4. Persiste no Oracle via JDBC.
5. Exibe no console o ID gerado ou mensagem de erro de validação.


-- Evoluções possíveis para o projeto --

1. Criar services para gerir as regras de negócio de pacientes e médicos;
2. Notificação de consultas por e-mail;
3. CRUD de médicos, agendamentos e pacientes (está incompleto).

-- Evoluções aplicadas no projeto -- 

1. Reestruturação de pacotes;
2. Interface no console mais "user-friendly";
3. Possibilidade de inserção de médicos, pacientes e consultas, com persistência no banco de dados.