package com.example;

public interface ElectronicDevice {

    public static final String WARNING = "Do not open, shock hazard";
    //String WARNING = "Do not open, shock hazard"; //means public static final

    public void turnOn();
    // void turnOn(); //means public abstract
    // public abstract void turnOn();

    public void turnOff();
}
