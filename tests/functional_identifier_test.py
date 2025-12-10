import sys
import os
sys.path.append(os.path.abspath(os.path.join(os.path.dirname(__file__), '..')))

from identifier_class import Identifier
import pytest

class TestIdentifierFunctional:
    def setup_method(self):
        self.validator = Identifier()

    def test_valid_a(self):
        assert self.validator.validate_identifier("a") is True

    def test_valid_a12345(self):
        assert self.validator.validate_identifier("a12345") is True

    def test_invalid_empty(self):
        assert self.validator.validate_identifier("") is False

    def test_invalid_too_long(self):
        assert self.validator.validate_identifier("a123456") is False

    def test_invalid_starts_with_digit(self):
        assert self.validator.validate_identifier("2") is False

    def test_invalid_contains_symbol(self):
        assert self.validator.validate_identifier("A#$12") is False
