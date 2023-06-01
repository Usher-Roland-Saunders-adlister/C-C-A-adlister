package com.codeup.adlister.util;

import org.mindrot.jbcrypt.BCrypt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Password {
    private static final int ROUNDS = 12;

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(ROUNDS));
    }

    public static boolean check(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }


    // Function to validate the password.
//    public static boolean
//    isValidPassword(String password)
//    {
//
//        // Regex to check valid password.
//        String regex = "^(?=.*[0-9])"
//                + "(?=.*[a-z])(?=.*[A-Z])"
//                + "(?=.*[@#$%^&+=])"
//                + "(?=\\S+$).{8,20}$";
//
//        // Compile the ReGex
//        Pattern p = Pattern.compile(regex);
//
//        // If the password is empty
//        // return false
//        if (password == null) {
//            return false;
//        }
//
//        // Pattern class contains matcher() method
//        // to find matching between given password
//        // and regular expression.
//        Matcher m = p.matcher(password);
//
//        // Return if the password
//        // matched the ReGex
//        return m.matches();
//    }

}
