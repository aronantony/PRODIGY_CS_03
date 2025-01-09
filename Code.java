import java.util.regex.*;

public class PasswordStrengthChecker {

    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasDigit = false;
        boolean hasSpecialChar = false;

        // Check for each character in the password
        for (int i = 0; i < length; i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) hasUpperCase = true;
            else if (Character.isLowerCase(ch)) hasLowerCase = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (isSpecialCharacter(ch)) hasSpecialChar = true;
        }

        // Assess password strength
        if (length < 8) {
            return "Weak: Password must be at least 8 characters long.";
        } else if (!hasUpperCase || !hasLowerCase || !hasDigit || !hasSpecialChar) {
            return "Weak: Password must contain uppercase letters, lowercase letters, digits, and special characters.";
        } else if (length >= 8 && hasUpperCase && hasLowerCase && hasDigit && hasSpecialChar) {
            return "Strong: Your password is strong!";
        } else {
            return "Medium: Your password is decent, but could be improved.";
        }
    }

    private static boolean isSpecialCharacter(char ch) {
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";
        return specialCharacters.indexOf(ch
