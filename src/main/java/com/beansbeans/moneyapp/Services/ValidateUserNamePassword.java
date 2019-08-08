package com.beansbeans.moneyapp.Services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
import com.beansbeans.moneyapp.Model.User;
import com.beansbeans.moneyapp.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

    public class ValidateUserNamePassword {
        @Autowired
        private UserRepository userRepository;

        public ValidateUserNamePassword() {
        }

        public static Boolean isUserNameValid(String inputName) {
            return ((between8And20Characters(inputName)) &&
//                    (containsUpperCaseAndLowerCase(inputName)) &&
//                    (containsNumeric(inputName)) &&
//                    (containsNonAlphaNumeric(inputName)) &&
//                    (doesNotContainSpecialCharacters(inputName)) &&
//                    (doesNotContainTriple(inputName)) &&
                    (doesNotContainSpace(inputName)));
        }

        public static Boolean isPasswordValid(String inputName) {
            return ((between8And20Characters(inputName)) &&
                    (containsUpperCaseAndLowerCase(inputName)) &&
                    (containsNumeric(inputName)) &&
                    (containsNonAlphaNumeric(inputName)) &&
                    (doesNotContainSpecialCharacters(inputName)) &&
                    (doesNotContainTriple(inputName)) &&
                    (doesNotContainNotAndAnd(inputName)) &&
                    (doesNotContainSpace(inputName)));
        }

        public static String makeHash(String inputPassword) {
//            DO NOT CHANGE "salt" !!!
            String salt = BCrypt.gensalt(10);
            String hash = BCrypt.hashpw(inputPassword, salt);
            return hash;
        }

        public static Boolean confirmPasswordHash(String passWord, String hash) {
            return (BCrypt.checkpw(passWord, hash));
        }

        public static Boolean between8And20Characters(String inputName) {
            if ((inputName.length() > 7) && (inputName.length() < 21)) {
                return true;
            }
            return false;
        }

        public static Boolean containsUpperCaseAndLowerCase(String inputName) {
            if ((inputName.equals(inputName.toLowerCase())) || (inputName.equals(inputName.toUpperCase()))) {
                return false;
            }
            return true;
        }

        public static Boolean doesNotContainSpecialCharacters(String inputName) {

            //Checks at least one char is not alpha numeric
            if (inputName.matches("[!=;:*/\\+()^\\[\\]{}|,]*")) {
                return false;
            }
            return true;
        }

        public static Boolean doesNotContainTriple(String inputName) {
            final String ps2 = ".*(?:([a-z0-9])\\1{2,}).*";
            final Pattern p2 = Pattern.compile(ps2);
            final Matcher m2 = p2.matcher(inputName);
            if (m2.matches()) {
                return false;
            }
            return true;
        }

        public static Boolean containsNumeric(String inputName) {
            if (!inputName.matches(".*[0-9].*")) {
                return false;
            }
            return true;
        }

        public static Boolean containsNonAlphaNumeric(String inputName) {
            if (inputName.matches("[A-Za-z0-9 ]*")) {
                return false;
            }
            return true;
        }

        public static Boolean doesNotContainNotAndAnd(String inputName) {
            inputName.toUpperCase();
            if ((inputName.contains("AND")) || (inputName.contains("NOT"))) {
                return false;
            }
            return true;
        }

        public static Boolean doesNotContainSpace(String inputName) {
            if (inputName.contains(" ")) {
                return false;
            }
            return true;
        }

        public static Boolean isEmailValid(String emailAddress) {
            String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(emailAddress);
            return matcher.matches();
    }

    }

