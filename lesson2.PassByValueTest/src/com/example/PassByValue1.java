/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author ryannieh
 */
public class PassByValue1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x=3;
        int y=x;
        y++;
        System.out.println("y="+y);
        System.out.println("x="+x);
        // call passByValueTest
        passByValueTest(x);
        System.out.println("after calling passByValueTest: x="+x);
    }
    
    public static void passByValueTest(int a){
        a++; 
        System.out.println("in passByValueTest: a="+a);
    }
}
