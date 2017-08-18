package com.example.generics;

public class TestCacheObject2 {

    public static void main(String args[]) {
        CacheObject myCache = new CacheObject();

        myCache.add("Save this for me");
        //need to do a downward cast
        String message = (String) myCache.get();
        System.out.println("Message is: " + message);
        //
        myCache.add(Shirt.newShirt(1111, "Blue Shirt", "Blue", "Medium"));
        //need to do a downward cast
        Shirt shirt = (Shirt) myCache.get();
        System.out.println("Shirt Type:" + shirt);

    }

}
