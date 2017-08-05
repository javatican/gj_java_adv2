/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author ryannieh
 */
public class PathComponents {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // None of these methods requires that the file corresponding
        // to the Path exists.
        // Microsoft Windows syntax
        //Path path = Paths.get("C:\\home\\joe\\foo");

        // Solaris syntax
        Path path = Paths.get("/home/joe/foo");
        // test relative paths
        //Path path = Paths.get("sally/bar");
        //Path path = Paths.get("sally\\bar");

        System.out.format("toString: %s%n", path.toString());
        System.out.format("getFileName: %s%n", path.getFileName());
        System.out.format("getName(0): %s%n", path.getName(0));
        System.out.format("getNameCount: %d%n", path.getNameCount());
        System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
        System.out.format("getParent: %s%n", path.getParent());
        System.out.format("getRoot: %s%n", path.getRoot());

    }

}
