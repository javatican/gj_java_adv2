package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeStock {

    public static void main(String[] args) {
        // Determine if we have file name for the Portfolio
        if (args.length < 1) {
            System.out.println("Specify the name of a file name for the stock");
            System.exit(-1);
        }
        //Create a stock portfolio
        Stock s1 = new Stock("ORCL", 100, 32.50, 31.50); 
        
        System.out.println ("Before serializaton:\n" + s1 + "\n");

        // Write out the Portfolio
        try (FileOutputStream fos = new FileOutputStream(args[0]);
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(s1);
            System.out.println ("Successfully wrote stock as an object");
        } catch (IOException i) {
            System.out.println("Exception writing out stock: " + i);
        }
        
        // Read the Portfolio back in
        try (FileInputStream fis = new FileInputStream(args[0]);
                ObjectInputStream in = new ObjectInputStream(fis)) {
            Stock newS = (Stock)in.readObject();
            System.out.println ("Success: read stock back in:\n" + newS);
        } catch (ClassNotFoundException | IOException i) {
            System.out.println("Exception reading in stock: " + i);
        }
    }
}
