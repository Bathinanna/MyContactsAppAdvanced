package com.mycontactsapp.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    // Regex pattern for email validation
    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@(.+)$";

    // Validates email format
    public static boolean isValidEmail(String email) {
        return Pattern.matches(EMAIL_REGEX, email);
    }

    // Validates password length
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}