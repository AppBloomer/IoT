package com.example.walinnsinnovation.iot.Singleton;

import java.security.MessageDigest;

import static io.xlink.wifi.sdk.e.a.j;

/**
 * Created by walinnsinnovation on 13/07/17.
 */

public class HttpAgent {
    private static HttpAgent instance;
    public static HttpAgent getInstance() {
        if (instance == null) {
            instance = new HttpAgent();
        }
        return instance;
    }
    public static final String MD5(String s) {
        char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            char[] str = new char[(j * 2)];
            int k = 0;
            for (byte byte0 : mdInst.digest()) {
                int i = k;
                str[k] = hexDigits[(byte0 >>> 4) & 15];
                k = i + 1;
                str[i] = hexDigits[byte0 & 15];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
