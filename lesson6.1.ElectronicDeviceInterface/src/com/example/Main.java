package com.example;

public class Main {

    public static void main(String[] args) {
        ElectronicDevice ed = new Television();
        ed.turnOn();
        ed.turnOff();
        //ed.changeChannel(2); // fails
        String s = ed.toString(); //can invoke Object methods

        Television t = new Television();
        if (t instanceof ElectronicDevice) {
            //true
        }

        Object o = new Television();
        turnObjectOn(o);
    }

    public static void turnObjectOn(Object o) {
        if (o instanceof ElectronicDevice) {
            ElectronicDevice e = (ElectronicDevice) o;
            e.turnOn();
        }
    }
    /*
    public static void turnObjectOn(ElectronicDevice e) {
        e.turnOn();
    }*/
}
