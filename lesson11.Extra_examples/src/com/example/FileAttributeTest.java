package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.util.Date;

public class FileAttributeTest {

    public static void main(String[] args) {
        try {
            Path source = Paths.get("foo.txt");
            BasicFileAttributes attr = null;

            attr = Files.readAttributes(source, BasicFileAttributes.class);

            System.out.println("creationTime: " + toDate(attr.creationTime()));
            System.out.println("lastAccessTime: " + toDate(attr.lastAccessTime()));
            System.out.println("lastModifiedTime: " + toDate(attr.lastModifiedTime()));

            System.out.println("isDirectory: " + attr.isDirectory());
            System.out.println("isOther: " + attr.isOther());
            System.out.println("isRegularFile: " + attr.isRegularFile());
            System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
            System.out.println("size: " + attr.size());
            //update lastModifiedTime
            long currentTime = System.currentTimeMillis();
            FileTime ft = FileTime.fromMillis(currentTime);
            Files.setLastModifiedTime(source, ft);
            System.out.println("updated lastModifiedTime: " + toDate(Files.getLastModifiedTime(source)));
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static String toDate(FileTime ft) {
        return DateFormat.getInstance().format(new Date(ft.toMillis()));
    }
}
