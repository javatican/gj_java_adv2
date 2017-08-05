package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 
public class CreateTempFileTest {

    public static void main(String[] args) {

        //create a temp file
        Path location = Paths.get(".");
        try {
            System.out.format("The temporary file"
                    + " has been created: %s%n", Files.createTempFile(location, null, null));

            System.out.format("The temporary file"
                    + " has been created: %s%n", Files.createTempFile(location, null, ".myapp"));

            System.out.format("The temporary file"
                    + " has been created: %s%n", Files.createTempFile(location, "myprefix", ".myapp"));
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
