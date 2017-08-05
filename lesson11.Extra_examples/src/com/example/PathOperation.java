package com.example;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ryannieh
 */
public class PathOperation {

    public static void main(String[] args) {
        // 1. normalize()
        //Path p = Paths.get("/home/peter/../clarence/foo");
        Path p = Paths.get("/home/./clarence/foo");
        Path normalizedPath = p.normalize();
        System.out.format("normalized(): %s%n", normalizedPath);

        //2. toUri()
        Path p1 = Paths.get("/home/logfile");
        System.out.format("toUri(): %s%n", p1.toUri());

        //3. toAbsolutePath() 
        Path p2 = Paths.get("test.txt");
        Path fullPath = p2.toAbsolutePath();
        System.out.format("toAbsolutePath(): %s%n", fullPath);

        //4. toRealPath()
        try {
            Path fp = p2.toRealPath();
        } catch (NoSuchFileException x) {
            System.out.format("%s: no such" + " file or directory%n", p2);
            // Logic for case when file doesn't exist.
        } catch (IOException x) {
            System.out.format("%s%n", x);
            // Logic for other sort of file error.
        }

        //5. resolve()
        Path p3 = Paths.get("/home/joe/foo");
        //Path p3 = Paths.get("C:\\home\\joe\\foo"); 
        System.out.format("resolve(): %s%n", p3.resolve("bar"));

        // pass-in path is an absolute path
        Path p4 = Paths.get("foo").resolve("/home/joe");
        System.out.format("resolve(): %s%n", p4);

        //6. relativize()
        Path p5 = Paths.get("/home/joe");
        Path p6 = Paths.get("/home/ppp/sally");
        Path p5_to_p6 = p5.relativize(p6);
        Path p6_to_p5 = p6.relativize(p5);
        System.out.format("relativize(): %s%n", p5_to_p6);
        System.out.format("relativize(): %s%n", p6_to_p5);
    }

}
