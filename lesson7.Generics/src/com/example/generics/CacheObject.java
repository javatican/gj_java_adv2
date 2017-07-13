package com.example.generics;

public class CacheObject {
    private Object obj;
  
    public void add(Object obj){
        this.obj = obj;
    }
  
    public Object get(){
        return this.obj;
    }  
}
