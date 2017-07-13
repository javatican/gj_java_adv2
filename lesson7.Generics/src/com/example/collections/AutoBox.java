package com.example.collections;

public class AutoBox {
    public static void main(String[] args){
        Integer intObject = new Integer(1);
        int intPrimitive = 2;
        
        Integer tempInteger;
        int tempPrimitive;
        
        tempInteger = new Integer(intPrimitive); //old syntax
        tempPrimitive = (int) intObject.intValue(); //old syntax
        
        tempInteger = intPrimitive; // Auto unbox and box
        tempPrimitive = intObject;  // Auto unbox and box
        
        System.out.println("Integer: " + tempInteger + " int: " + tempPrimitive);
    }
}
