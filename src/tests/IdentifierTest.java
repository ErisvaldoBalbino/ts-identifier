package tests;
import org.junit.Test;
import testIdentifier.Identifier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class IdentifierTest {
    private final Identifier id = new Identifier();

    @Test
    public void testCT01_EmptyString() {
        assertFalse(id.validateIdentifier(""));
    }

    @Test
    public void testCT02_ValidMinLength() {
        assertTrue(id.validateIdentifier("a"));
    }

    @Test
    public void testCT03_ValidWithDigit() {
        assertTrue(id.validateIdentifier("a1"));
    }

    @Test
    public void testCT04_ValidMidLength() {
        assertTrue(id.validateIdentifier("a1234"));
    }

    @Test
    public void testCT05_ValidMaxLength() {
        assertTrue(id.validateIdentifier("a12345"));
    }

    @Test
    public void testCT06_InvalidLength() {
        assertFalse(id.validateIdentifier("a123456"));
    }

    @Test
    public void testCT07_InvalidStartWithDigit() {
        assertFalse(id.validateIdentifier("1a"));
    }

    @Test
    public void testCT08_InvalidStartWithSymbol() {
        assertFalse(id.validateIdentifier("_a"));
    }

    @Test
    public void testCT09_InvalidContainsSymbol() {
        assertFalse(id.validateIdentifier("a-1"));
    }

    @Test
    public void testCT10_InvalidContainsSpace() {
        assertFalse(id.validateIdentifier("a 1"));
    }

    @Test
    public void testCT11_ValidMixedCase() {
        assertTrue(id.validateIdentifier("A1b2C"));
    }

    @Test
    public void testCT12_ValidOnlyLetters() {
        assertTrue(id.validateIdentifier("Abc"));
    }

    @Test
    public void testNullInput() {
        assertFalse(id.validateIdentifier(null));
    }
}
