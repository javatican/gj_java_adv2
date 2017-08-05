package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ryannieh
 */
public class FileOperation {

    public static void main(String[] args) {
        
        //test if file exist 
        Path p = Paths.get("foo.txt");
        if (Files.exists(p)) {
            //test file accessabilities
            System.out.println("isReadable():" + Files.isReadable(p));
            System.out.println("isWritable():" + Files.isWritable(p));
            System.out.println("isExecutable():" + Files.isExecutable(p));
        }
        
        //a not exist file
        Path p2 = Paths.get("nonexist.txt");
        System.out.println("exists():" + Files.exists(p2));
        System.out.println("notExists():" + Files.notExists(p2));
        
        // test if is the same file
        Path p3 = Paths.get("ln_to_foo.txt");
        try {
            if(Files.isSameFile(p, p3)){
                System.out.println("p is the same as p3");
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
