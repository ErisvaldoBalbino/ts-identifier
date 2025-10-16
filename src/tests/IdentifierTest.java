package tests;
import org.junit.Test;
import testIdentifier.Identifier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IdentifierTest {
    private final Identifier id = new Identifier();

    @Test
    public void testMinLength() {
        assertTrue(id.validateIdentifier("a"));
    }

    @Test
    public void testMaxLength() {
        assertTrue(id.validateIdentifier("string"));
    }

    @Test
    public void testEmpty() {
        assertFalse(id.validateIdentifier(""));
    }

    @Test
    public void testExceedMaxLength() {
        assertFalse(id.validateIdentifier("stringmuitogrande"));
    }

    @Test
    public void testStartsWithNumeric() {
        assertFalse(id.validateIdentifier("1strin"));
    }

    @Test
    public void testStartWithInvalidCharacter() {
        assertFalse(id.validateIdentifier("_strin"));
    }

    @Test
    public void testStartWithLetter() {
        assertTrue(id.validateIdentifier("a5"));
    }

    @Test
    public void testContainsOnlyDigits() {
        assertFalse(id.validateIdentifier("665432"));
    }

    @Test
    public void testContainsInvalidCharacter() {
        assertFalse(id.validateIdentifier("B*ss1"));
    }

}
