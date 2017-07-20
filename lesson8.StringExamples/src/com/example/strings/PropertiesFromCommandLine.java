package com.example.strings;

public class PropertiesFromCommandLine {

    public static void main(String[] args) {

        System.out.println("User: " + System.getProperty("userName"));
        System.out.println("Pass: " + System.getProperty("password"));
    }
}
