import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from identifier_class import Identifier
import pytest

class TestIdentifierStructural:
    def setup_method(self):
        self.validator = Identifier()

    # CTE01: Cobertura da verificação de tipo (isinstance)
    # Testa se a entrada NÃO é uma string (ex: int, None).
    # Diferente de testar uma string contendo dígitos (que passa aqui e falha depois).
    def test_invalid_type_none(self):
        assert self.validator.validate_identifier(None) is False
        
    def test_invalid_type_int(self):
        assert self.validator.validate_identifier(123) is False

    # CTE02: Cobertura do limite inferior de tamanho
    def test_invalid_empty(self):
        assert self.validator.validate_identifier("") is False

    # CTE03: Cobertura do limite superior de tamanho
    def test_invalid_too_long(self):
        assert self.validator.validate_identifier("abcdefghi") is False

    # CTE04: Cobertura do primeiro caractere inválido (Dígito)
    # A entrada É uma string ("2"), mas o conteúdo é inválido.
    # Testa a falha na validação do primeiro caractere (valid_s).
    def test_invalid_starts_with_digit(self):
        assert self.validator.validate_identifier("2") is False

    # CTE05: Cobertura do primeiro caractere inválido (Símbolo)
    # Testa falha antes do loop.
    def test_invalid_starts_with_symbol(self):
        assert self.validator.validate_identifier("#abc") is False

    # CTE06: Cobertura de caractere subsequente inválido (Loop)
    # Este teste garante que entramos no loop e falhamos lá dentro (valid_f).
    def test_invalid_contains_symbol_middle(self):
        assert self.validator.validate_identifier("a*c") is False

    # CTE07: Cobertura do Caminho Válido (Mínimo)
    # Testa fluxo sem entrar no loop (range(1, 1) é vazio) -> Retorna True
    def test_valid_min_length(self):
        assert self.validator.validate_identifier("a") is True

    # CTE08: Cobertura do Caminho Válido (Máximo com Loop)
    # Testa fluxo completo do loop com todas as iterações passando -> Retorna True
    def test_valid_max_length_alphanum(self):
        assert self.validator.validate_identifier("a1B2c3") is True
