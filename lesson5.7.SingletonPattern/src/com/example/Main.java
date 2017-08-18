package com.example;

public class Main {

    public static void main(String[] args) {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        System.out.println("s1==s2 : " + (s1 == s2));
    }

}
