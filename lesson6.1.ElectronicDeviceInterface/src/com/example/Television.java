package com.example;

public class Television implements ElectronicDevice {

    @Override
    public void turnOn() {
        changeChannel(1);
        initializeScreen();
    }

    @Override
    public void turnOff() {
    }

    public void changeChannel(int channel) {
    }

    private void initializeScreen() {
    }

}
