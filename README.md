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

## Projeto dos Casos de Teste Funcionais

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

## Diferença entre Testes Funcionais e Estruturais

### Testes Funcionais (Caixa Preta)
Os testes funcionais verificam **o que** o sistema faz, baseando-se apenas nos requisitos e especificações, sem conhecimento do código fonte interno. O foco é garantir que para uma dada entrada, a saída esteja correta conforme as regras de negócio (ex: Particionamento em Classes de Equivalência).

### Testes Estruturais (Caixa Branca)
Os testes estruturais verificam **como** o sistema funciona, baseando-se na análise do código fonte. O foco é garantir que a lógica interna foi totalmente exercitada.

#### Critério de Fluxo de Controle Utilizado

Neste projeto, utilizamos critérios baseados no Grafo de Fluxo de Controle (GFC):

1.  **Todos-Nós:** Garante que cada linha de código foi executada pelo menos uma vez.
2.  **Todos-Arcos:** Garante que cada desvio (arestas do grafo) foi percorrido. Ou seja, para cada decisão (`if`, loops), testamos tanto o caminho **Verdadeiro** quanto o **Falso**.

**Critério Adotado:** O conjunto de testes abaixo atende ao critério de **Todos-Arcos**, que é mais rigoroso e consequentemente satisfaz também o critério de **Todos-Nós**. Isso garante que não apenas passamos por todas as linhas, mas validamos a lógica de decisão em todos os seus resultados possíveis.

## Casos de Teste Estruturais

O objetivo destes testes é atingir 100% de cobertura de instruções e decisões no método `validate_identifier`.

| ID | Cenário | Entrada | Resultado Esperado | O que testa (Cobertura de Arcos) |
|:---:|:---|:---|:---:|:---|
| **CTE01** | **Entrada não é string** | `None` ou `123` | `False` | Arco `False` da verificação de tipo. |
| **CTE02** | **String vazia** | `""` | `False` | Arco `False` da validação de tamanho (limite inferior). |
| **CTE03** | **Tamanho excedido** | `"abcdefg"` | `False` | Arco `False` da validação de tamanho (limite superior). |
| **CTE04** | **Primeiro caractere inválido (Dígito)** | `"2"` | `False` | Arco `False` da função `valid_s`. |
| **CTE05** | **Primeiro caractere inválido (Símbolo)** | `"#abc"` | `False` | Arco `False` da função `valid_s` (variação). |
| **CTE06** | **Caractere subsequente inválido** | `"a-bc"` | `False` | Arco `True` do Loop -> Arco `False` de `valid_f`. |
| **CTE07** | **Identificador Válido (Mínimo)** | `"z"` | `True` | Arco `True` das validações iniciais -> Arco `False` do Loop (não entra) -> Retorno True. |
| **CTE08** | **Identificador Válido (Máximo)** | `"a1B2c3"` | `True` | Arco `True` das validações -> Arco `True` do Loop (completo) -> Retorno True. |
