# Atividade Prática – Testes Funcionais: Identifier

## Objetivo

Aplicar os critérios de Particionamento em Classes de Equivalência e Análise de Valor Limite no projeto de casos de teste para o programa Identifier, implementando tanto o programa quanto seus testes automatizados, e integrando-os com o GitHub Actions.

## Especificação do Programa

O programa deve determinar se um identificador é válido ou não.

Um identificador válido:
- Deve começar com uma letra (a-z ou A-Z);
- Pode conter apenas letras ou dígitos;
- Deve ter de 1 a 6 caracteres de comprimento (inclusive).

A função deve retornar um valor booleano indicando se o identificador é válido.

## Projeto dos Casos de Teste

Para garantir uma cobertura de teste abrangente, foram utilizadas as técnicas de Particionamento em Classes de Equivalência e Análise de Valor Limite.

### 1. Particionamento em Classes de Equivalência

Identificamos as seguintes classes de equivalência com base nas regras de validação do identificador:

#### Comprimento do Identificador
- **CE1 (Válida):** Comprimento entre 1 e 6 caracteres.
- **CE2 (Inválida):** Comprimento 0 (muito curto).
- **CE3 (Inválida):** Comprimento maior que 6 (muito longo).

#### Caractere Inicial
- **CE4 (Válida):** O primeiro caractere é uma letra (a-z, A-Z).
- **CE5 (Inválida):** O primeiro caractere é um dígito (0-9).
- **CE6 (Inválida):** O primeiro caractere é um símbolo (ex: `_`, `-`, `*`).

#### Caracteres Subsequentes
- **CE7 (Válida):** Os caracteres restantes são letras e/ou dígitos.
- **CE8 (Inválida):** Pelo menos um dos caracteres restantes é um símbolo ou espaço.

### 2. Análise de Valor Limite

Aplicamos a Análise de Valor Limite para o comprimento do identificador:
- **0:** Inválido (abaixo do mínimo)
- **1:** Válido (mínimo)
- **2:** Válido (logo acima do mínimo)
- **5:** Válido (logo abaixo do máximo)
- **6:** Válido (máximo)
- **7:** Inválido (acima do máximo)

### Tabela de Casos de Teste

A tabela a seguir resume os casos de teste projetados com base nas classes de equivalência e valores limite.

| ID | Entrada | Classe(s) de Equivalência Atendida(s) | Resultado Esperado |
| :--- | :---------- | :-------------------------------------- | :----------------- |
| CT01 | `""` | CE2 (comprimento < 1) | Inválido |
| CT02 | `"a"` | CE1, CE4, CE7 (limite inferior) | Válido |
| CT03 | `"a1"` | CE1, CE4, CE7 | Válido |
| CT04 | `"a1234"` | CE1, CE4, CE7 | Válido |
| CT05 | `"a12345"` | CE1, CE4, CE7 (limite superior) | Válido |
| CT06 | `"a123456"` | CE3 (comprimento > 6) | Inválido |
| CT07 | `"1a"` | CE5 (inicia com dígito) | Inválido |
| CT08 | `"_a"` | CE6 (inicia com símbolo) | Inválido |
| CT09 | `"a-1"` | CE8 (contém símbolo) | Inválido |
| CT10 | `"a 1"` | CE8 (contém espaço) | Inválido |
| CT11 | `"A1b2C"` | CE1, CE4, CE7 (misto) | Válido |
| CT12 | `"Abc"` | CE1, CE4, CE7 (só letras) | Válido |