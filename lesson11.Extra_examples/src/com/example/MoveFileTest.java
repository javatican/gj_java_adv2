package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class MoveFileTest {

    public static void main(String[] args) {

        //move a file
        Path source = Paths.get("foo_copy.txt");
        Path target = Paths.get("foo2.txt");
        try {
            Files.move(source, target);
            System.out.format("The source file %s"
                    + " has been moved to: %s%n", source, target);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        //move with replace_exist
        Path source2 = Paths.get("foo2.txt");
        Path target2 = Paths.get("foo.txt");
        try {
            Files.move(source2, target2, REPLACE_EXISTING);
            System.out.format("The source file %s"
                    + " has been moved to: %s%n", source2, target2);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
