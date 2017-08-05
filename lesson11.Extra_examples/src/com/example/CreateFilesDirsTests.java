package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ryannieh
 */
public class CreateFilesDirsTests {

    public static void main(String[] args) {

        //create a new file
        Path newfile = Paths.get("newfile.txt");
        try {
            Files.createFile(newfile);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        //create a new directory
        Path newDir = Paths.get("newDir");
        try {
            Files.createDirectory(newDir);
        } catch (IOException ex) {
            System.err.println(ex);
        }

        //create new directories path
        Path newDir2 = Paths.get("sub/sub2/newDir2");
        try {
            Files.createDirectories(newDir2);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

}
