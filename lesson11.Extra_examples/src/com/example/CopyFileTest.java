package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyFileTest {

    public static void main(String[] args) {

        //copy a file
        Path source = Paths.get("foo.txt");
        Path target = Paths.get("foo_copy.txt");
        try {
            Files.copy(source, target);
            System.out.format("The source file %s"
                    + " has been copied to: %s%n", source, target);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        //copy again throws exception
        try {
            Files.copy(source, target);
            System.out.format("The source file %s"
                    + " has been copied to: %s%n", source, target);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        //copy again using REPLACE_EXISTING
        try {
            Files.copy(source, target, REPLACE_EXISTING);
            System.out.format("The source file %s"
                    + " has been copied to: %s%n", source, target);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
