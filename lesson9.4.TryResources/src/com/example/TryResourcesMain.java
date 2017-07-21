package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class TryResourcesMain {

    public static void main(String[] args) {
        System.out.println("About to open a file");
        try (InputStream in
                = new FileInputStream("missingfile.txt")) {
            System.out.println("File open");
            int data = in.read();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
