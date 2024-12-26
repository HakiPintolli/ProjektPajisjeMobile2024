package com.example.projektpajisjemobile2024;

public class PasswordValidacion {
    private static final String PASSWORD_PATTERN =
            "^(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>]).{8,}$";

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(PASSWORD_PATTERN);
}}
