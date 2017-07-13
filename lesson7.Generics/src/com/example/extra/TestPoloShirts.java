package com.example.extra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestPoloShirts {
    public static void main(String[] args){
        Set<PoloShirt> shirtList = new TreeSet<>();
        //Set<PoloShirt> shirtList = new HashSet<>();
        shirtList.addAll(Arrays.asList(PoloShirt.Black, PoloShirt.Blue, PoloShirt.Maroon));
        
        for(PoloShirt p:shirtList){
            System.out.println(p.toString() + " Polo --" + " PartNo: " 
                    + p.getPartNumber() + " Desc: " + p.getDescription());
        }
    }
}
