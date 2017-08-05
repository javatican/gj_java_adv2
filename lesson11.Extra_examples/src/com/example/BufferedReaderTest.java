package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedReaderTest {

    public static void main(String[] args) {

        Path source = Paths.get("foo.txt");
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        //Charset charset = Charset.forName("US-ASCII");
        //Charset charset = Charset.forName("UTF-8");
        Charset charset = Charset.forName(encoding);
        try (BufferedReader reader = Files.newBufferedReader(source, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}
