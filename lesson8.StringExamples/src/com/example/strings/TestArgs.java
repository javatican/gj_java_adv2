package com.example.strings;

public class TestArgs {

    public static void main(String[] args) {
        int[] x = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] is '"
                    + args[i] + "'");
            x[i]=Integer.parseInt(args[i]);
            System.out.println("x["+i+"]="+x[i]);
        } 
    }

}
