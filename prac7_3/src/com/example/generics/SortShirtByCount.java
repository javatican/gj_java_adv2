package com.example.generics;

import java.util.Comparator;

public class SortShirtByCount implements Comparator<Shirt> {

    @Override
    public int compare(Shirt s1, Shirt s2) {
        //Long c1 = s1.getCount();
        //Long c2 = s2.getCount();

        //return c1.compareTo(c2);
        if(s1.getCount()>s2.getCount()){
            return 1;
        } else if (s1.getCount()==s2.getCount()){
            return 0;
        } else{
            return -1;
        }
    }
}
