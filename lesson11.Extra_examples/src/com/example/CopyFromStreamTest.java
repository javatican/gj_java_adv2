package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyFromStreamTest {

    public static void main(String[] args) {

        //copy a file
        Path target = Paths.get("oracle.html");
        URI u = URI.create("http://www.oracle.com/index.html");
        try(InputStream is = u.toURL().openStream()){
            Files.copy(is, target, REPLACE_EXISTING);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        
    }

}
