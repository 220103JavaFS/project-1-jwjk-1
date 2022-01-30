package com.revature.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

    public String encoder(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] encryptPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
        return String.format("%040x", new BigInteger(1,encryptPassword));
    }
}
