package com.bappi.supershopmanagementsystemspringboot.utils;

public class Constants {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static class ErrorMessage{
        public static final String DUPLICATE_USERNAME = "Username is already in use";
        public static final String DUPLICATE_EMAIL = "Email is already in use";
        public static final String PASSWORD_NOT_MATCH = "Password and ConfirmPassword must be same";
        public static final String PASSWORD_EMPTY = "Password cannot be empty";
        public static final String ConfirmPassword_EMPTY = "Confirm Password cannot be empty";
        public static final String NAME_EMPTY = "Name cannot be empty";
        public static final String USERNAME_EMPTY = "Username cannot be empty";
        public static final String EMAIL_EMPTY = "Email cannot be empty";
        public static final String INVALID_EMAIL = "The email address is invalid";
        public static final String LOGIN = "Username or Password is invalid";
    }
}
