package com.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BufferedWriterTest {

    public static void main(String[] args) {

        Path target = Paths.get("foo2.txt");
        String encoding = System.getProperty("file.encoding");
        System.out.println(encoding);
        //Charset charset = Charset.forName("US-ASCII");
        //Charset charset = Charset.forName("UTF-8");
        Charset charset = Charset.forName(encoding);

        String s = "今天公布的民調，\n面臨政治危機持續惡化的南韓總統朴槿惠\n，支持率跌至4%，\n創南韓歷任民選總統新低\n";
        try (BufferedWriter writer = Files.newBufferedWriter(target, charset)) {
            writer.write(s, 0, s.length());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }

    }
}
