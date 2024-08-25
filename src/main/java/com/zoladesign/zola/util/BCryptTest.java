package com.zoladesign.zola.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptTest {

    public static void main(String[] args) {
        String password = "1234"; // Mot de passe en clair
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt()); // Hashage du mot de passe
        System.out.println("Hashed password: " + hashed);

        // Vérification du mot de passe
        if (BCrypt.checkpw(password, hashed)) {
            System.out.println("Password matches!");
        } else {
            System.out.println("Password does not match.");
        }
    }
}
