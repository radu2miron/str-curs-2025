package edu.tucn.str.lecture2.ex5fileParsing;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author Radu Miron
 * @version 1
 */
public class FileUtils {
    private FileUtils() {
    }

    public static void generateFile(String fileName) throws IOException {
        long t1 = System.currentTimeMillis();
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (int i = 0; i < 10000000; i++) {
                fileWriter.write("" + new Random().nextInt(Integer.MAX_VALUE) + "\n");
            }
        }
        System.out.println((System.currentTimeMillis() - t1) / 1000);
    }

    public static Map<String, Integer> parseFile(String fileName) throws IOException {
        long t1 = System.currentTimeMillis();
        Map<String, Integer> results = new HashMap<>();

        Files.lines(Path.of(fileName))
                .forEach(line -> {
                    for (int i = 0; i < line.length(); i++) {
                        String key = line.charAt(i) + "";
                        Integer val = results.get(key);

                        if (val == null) {
                            val = 1;
                        } else {
                            val++;
                        }

                        results.put(key, val);
                    }
                });

        System.out.println((System.currentTimeMillis() - t1) / 1000);
        return results;
    }

    public static void main(String[] args) throws IOException {
//        generateFile("numbers.txt");
        parseFile("numbers.txt").entrySet().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
