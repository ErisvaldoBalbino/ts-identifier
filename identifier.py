import sys
from identifier_class import Identifier

def main():
    if len(sys.argv) != 2:
        print("Uso: python identifier.py <identificador>")
        sys.exit(1)

    input_identifier = sys.argv[1]
    
    validator = Identifier()
    is_valid = validator.validate_identifier(input_identifier)

    if is_valid:
        print(f'"{input_identifier}" é Válido.')
    else:
        print(f'"{input_identifier}" é Inválido.')

if __name__ == "__main__":
    main()