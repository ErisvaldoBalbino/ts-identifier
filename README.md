# Atividade Prática – Testes Funcionais: Identifier

## Objetivo

Aplicar os critérios de Particionamento em Classes de Equivalência e Análise de Valor Limite no projeto de casos de teste para o programa `Identifier`, implementando tanto o programa quanto seus testes automatizados, e integrando-os com o GitHub Actions.

## Especificação do Programa

O programa deve determinar se um identificador é válido ou não. Um identificador válido:

- Deve começar com uma letra (a-z ou A-Z).
- Pode conter apenas letras ou dígitos.
- Deve ter de 1 a 6 caracteres de comprimento (inclusive).

A função retorna um valor booleano indicando se o identificador é válido.

---

## Projeto dos Casos de Teste

Para garantir a robustez do programa, foram aplicadas as técnicas de Particionamento em Classes de Equivalência e Análise de Valor Limite.

### 1. Particionamento em Classes de Equivalência

As classes de equivalência foram identificadas com base nas regras de validação do identificador:

- **(1) Válida:** Comprimento do identificador entre 1 e 6 caracteres.
- **(2) Válida:** O primeiro caractere é uma letra (maiúscula ou minúscula).
- **(3) Válida:** Os caracteres subsequentes são letras ou dígitos.
- **(4) Inválida:** Comprimento do identificador menor que 1 (zero).
- **(5) Inválida:** Comprimento do identificador maior que 6.
- **(6) Inválida:** O primeiro caractere não é uma letra (é um dígito, símbolo, etc.).
- **(7) Inválida:** Contém caracteres que não são letras ou dígitos (símbolos, espaços, etc.).

### 2. Análise de Valor Limite

A análise de valor limite foi aplicada à regra de comprimento do identificador.

- **Comprimento do identificador (1):**
  - **0 (inválido)** Abaixo do limite
  - **1 (válido)** 
  - **2 (válido)** 
  - **5 (válido)** 
  - **6 (válido)** 
  - **7 (inválido)** Acima do limite

### 3. Tabela de Casos de Teste


| ID   | Entrada             | Classe(s) de Equivalência Atendida(s) | Resultado Esperado |
|------|---------------------|---------------------------------------|--------------------|
| CT01 | `""`                | (4)                                   | Inválido           |
| CT02 | `"a"`               | (1), (2)                              | Válido             |
| CT03 | `"a12345"`          | (1), (2), (3)                         | Válido             |
| CT04 | `"a123456"`         | (5)                                   | Inválido           |
| CT05 | `"2"`               | (6)                                   | Inválido           |
| CT06 | `"A#$12"`           | (7)                                   | Inválido           |

---