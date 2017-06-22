package myjava;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryannieh
 */
public class TestImport3 {
    public static void main(String[] args){
        java.util.Date d = new java.util.Date();
        System.out.println(d.getClass());
        java.sql.Date d2 = new java.sql.Date(2016,1,1);
        System.out.println(d2.getClass());
    }
}
