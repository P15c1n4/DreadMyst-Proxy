package com.dreadMyst.proxy.UTILs;

import java.nio.charset.StandardCharsets;

public class ServicesUtil {

    public static byte[] reverseByteArray(byte[] byteArray) {
        for (int i = 0; i < byteArray.length / 2; i++) {
            byte tmp = byteArray[i];
            byteArray[i] = byteArray[byteArray.length - 1 - i];
            byteArray[byteArray.length - 1 - i] = tmp;
        }
        return byteArray;
    }

    public static String byteToString(byte[] byteArray, boolean removeSpace) {
        var byteOutput = new StringBuilder();
        for (byte b : byteArray) {
            byteOutput.append(String.format("%02X ", b));
        }

        if(removeSpace) {
            return byteOutput.toString().replaceAll(" ", "");
        }
        return byteOutput.toString();
    }

    public static String byteToText(byte[] byteArray) {
        return new String(byteArray, StandardCharsets.UTF_8);
    }
}
