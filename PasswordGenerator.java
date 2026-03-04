import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PasswordGenerator {

    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()_+";

    private static final String ALL = UPPER + LOWER + DIGITS + SPECIAL;

    public static String generatePassword(int length) {

        if (length < 4) {
            throw new IllegalArgumentException("Password length must be at least 4");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each category
        password.append(UPPER.charAt(random.nextInt(UPPER.length())));
        password.append(LOWER.charAt(random.nextInt(LOWER.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL.charAt(random.nextInt(SPECIAL.length())));

        // Fill remaining length
        for (int i = 4; i < length; i++) {
            password.append(ALL.charAt(random.nextInt(ALL.length())));
        }

        // Shuffle characters
        List<Character> characters = new ArrayList<>();
        for (char c : password.toString().toCharArray()) {
            characters.add(c);
        }

        Collections.shuffle(characters);

        StringBuilder finalPassword = new StringBuilder();
        for (char c : characters) {
            finalPassword.append(c);
        }

        return finalPassword.toString();
    }
    public static String checkStrength(String password) {

        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[0-9].*")) score++;
        if (password.matches(".*[!@#$%^&*()_+].*")) score++;

        if (score <= 2) return "Weak";
        else if (score <= 4) return "Medium";
        else return "Strong";
    }
}