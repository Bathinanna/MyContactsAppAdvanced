package com.mycontactsapp.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    // Regex pattern for email validation
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final String PASSWORD_REGEX =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

    // Validates email format
    public static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    // Validates password length
    public static boolean isValidPassword(String password) {
        return Pattern.matches(PASSWORD_REGEX, password);
    }
}