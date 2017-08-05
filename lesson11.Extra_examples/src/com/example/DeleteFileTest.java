package com.example;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteFileTest {

    public static void main(String[] args) {

        //create a temp file to be deleted later
        Path location = Paths.get(".");
        Path file_to_delete = null;
        try {
            file_to_delete = Files.createTempFile(location, null, null);
            System.out.format("The temporary file"
                    + " has been created: %s%n", file_to_delete);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        try {
            Files.delete(file_to_delete);
            System.out.format("The file"
                    + " has been deleted: %s%n", file_to_delete);
        } catch (NoSuchFileException x) {
            System.err.format("%s: no such" + " file or directory%n", file_to_delete);
        } catch (DirectoryNotEmptyException x) {
            System.err.format("%s not empty%n", file_to_delete);
        } catch (IOException x) {
            // File permission problems are caught here.
            System.err.println(x);
        }
        //delete a nonexist file
        Path notExistFile = Paths.get("notExist.txt");
        try {
            Files.deleteIfExists(notExistFile);
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
