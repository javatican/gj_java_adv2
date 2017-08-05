package com.example;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributeTest {

    public static void main(String[] args) {
        boolean unixFS = false;
        Set<String> views
                = FileSystems.getDefault().supportedFileAttributeViews();
        for (String s : views) {
            if (s.equals("posix")) {
                unixFS = true;
            }
        }
        if (!unixFS) {
            System.out.println("This filesystem does not support Posix permissions.");
            System.exit(-1);
        }
        try {
            Path source = Paths.get("foo.txt");
            PosixFileAttributes attr = null;

            attr = Files.readAttributes(source, PosixFileAttributes.class);

            System.out.format("%s %s %s%n",
                    attr.owner().getName(),
                    attr.group().getName(),
                    PosixFilePermissions.toString(attr.permissions()));
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
