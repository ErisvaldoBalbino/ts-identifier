package testIdentifier;

public class Identifier {

    public boolean validateIdentifier(String s) {
        if (s == null || s.isEmpty() || s.length() > 6) {
            return false;
        }

        if (!valid_s(s.charAt(0))) {
            return false;
        }

        for (int i = 1; i < s.length(); i++) {
            if (!valid_f(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public boolean valid_s(char ch) {
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z'));
    }

    public boolean valid_f(char ch) {
        return ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'));
    }

}