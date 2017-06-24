/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.awt.Point;

/**
 *
 * @author ryannieh
 */
public class PassByValue2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Point p1 = new Point(10,20);
        System.out.println("p1.x="+p1.x+", p1.y="+p1.y);
        Point p2 = p1;
        p2.move(100,200);
        System.out.println("p2.x="+p2.x+", p2.y="+p2.y);
        System.out.println("p1.x="+p1.x+", p1.y="+p1.y);
        // call passByValueTest
        passByValueTest(p1);
        System.out.println("after calling passByValueTest: p1.x="+p1.x+", p1.y="+p1.y);
    }
    
    public static void passByValueTest(Point a){
        a.move(1000, 2000);
        System.out.println("in passByValueTest: a.x="+a.x+", a.y="+a.y);
    }
}
