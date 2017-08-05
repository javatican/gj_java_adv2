package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ryannieh
 */
public class SymLinksTest {

    public static void main(String[] args) {
        
        //create a sym link
        Path newLink = Paths.get("ln_to_foo.txt");
        Path target = Paths.get("foo.txt");
        try {
            Files.createSymbolicLink(newLink, target);
        } catch (IOException x) {
            System.err.println(x);
        } catch (UnsupportedOperationException x) {
            // Some file systems do not support symbolic links.
            System.err.println(x);
        }
        
        //test if it is a sym link 
        if (Files.isSymbolicLink(newLink)) {
            System.out.println("newLink is a sym link!");
        }

        //read sym link target
        try {
            System.out.format("Target of link"
                    + " '%s' is '%s'%n", newLink,
                    Files.readSymbolicLink(newLink));
        } catch (IOException x) {
            System.err.println(x);
        }

    }

}
