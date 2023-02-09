package com.kameleoon.userpost.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.MessageDigest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashGenerator {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(5);
    @SneakyThrows
    public static String generateBySHA(String password) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md5 = null;
        md5 = MessageDigest.getInstance("SHA-256");
        byte[] bytes = md5.digest(password.getBytes());
        for (byte i: bytes) {
            sb.append(String.format("%02X",i));
        }
        return sb.toString();
    }

    public static String generateHash(String password) {
        return encoder.encode(generateBySHA(password));
    }

    public static BCryptPasswordEncoder getEncoder() {
        return encoder;
    }
}
