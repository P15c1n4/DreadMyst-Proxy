package com.dreadMyst.proxy.UTILs;

public class OutputUtils {

    public static void error(String message) {
        System.err.println("\n**************************ERROR****************************");
        System.err.println(message);
    }
    public static void error(Object objClass, String message) {
        System.err.println("\n**************************ERROR****************************");
        String output = String.format("[%s] %s",objClass.getClass().getName(),  message);
        System.err.println(output);
    }
    public static void info(String message) {
        System.out.println("\n**************************INFO****************************");
        System.out.println(message);
    }
    public static void debug(String message) {
        System.out.println("\n***********************DEBUG*******************************");
        System.out.println(message);
    }
    public static void print(String message) {
        System.out.println(message);
    }



}
