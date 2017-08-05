package com.example;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest {

    public static void main(String[] args) {

        //list directory content
        Path source = Paths.get(".");
        System.out.println("List all files:");
        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(source);
            for(Path p: ds){
                System.out.println("\t"+p.getFileName());
            }
        } catch (IOException x) {
            System.err.println(x);
        }
        // list contents using globbing
        System.out.println("List only txt files:");
        try {
            DirectoryStream<Path> ds = Files.newDirectoryStream(source,"*.txt");
            for(Path p: ds){
                System.out.println("\t"+p.getFileName());
            }
        } catch (IOException x) {
            System.err.println(x);
        }
    }

}
