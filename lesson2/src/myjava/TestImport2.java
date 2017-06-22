package myjava;

import java.util.Date;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ryannieh
 */
public class TestImport2 {
    public static void main(String[] args){
        Date d = new Date();
        System.out.println(d.getClass());
        java.sql.Date d2 = new java.sql.Date(2016,1,1);
        System.out.println(d2.getClass());
    }
}
