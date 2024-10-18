package com.project.urlShortner.Service;

import java.nio.charset.StandardCharsets;
import java.util.zip.CRC32;

public class Base62 {
    private static final String BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(String input) {
        // convert input string into hash
        long hashValue = getNumericHash(input);
        //return karega encoded string
        return encodeBase62(hashValue);
    }

    private static long getNumericHash(String input) {
        // crc32 hash Function
        CRC32 crc = new CRC32();
        //conversion into the hash
        crc.update(input.getBytes(StandardCharsets.UTF_8));
        //returns the long value
        return crc.getValue();
    }


    private static String encodeBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(BASE62.charAt((int)(num % 62)));
            num /= 62;
        }
        return sb.reverse().toString();
    }


    public static int decode(String shortCode) {
        int num = 0;
        for (int i = 0; i < shortCode.length(); i++) {
            num = num * 62 + BASE62.indexOf(shortCode.charAt(i));
        }
        return num;
    }
}
