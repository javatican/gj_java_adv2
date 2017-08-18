
package com.example.extra;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestLocation {
    public static void main(String[] args){
        Set<Location> locationList = new TreeSet<>();
        //Set<Location> locationList = new HashSet<>();
        locationList.addAll(Arrays.asList(Location.Taiwan, Location.Madagascar, Location.Russia, Location.CzechRepublic));
        
        for(Location l:locationList){
            System.out.println(l.toString() + "--> Code = " + l.getCountry() + " Language = " + l.getLanguage());
        }
    }
}
