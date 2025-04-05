package edu.tucn.str.lecture3.ex8waitnotif_ProducerConsunsumer;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Radu Miron
 * @version 1
 */
public class FileUtilities {
    private static final File FILE = new File("lecture3_files/file.txt");

    private FileUtilities() {
    }

    public static void writeStringToFile(String line) throws IOException {
        FileUtils.writeStringToFile(FILE, line + "\n", StandardCharsets.UTF_8, true);
    }

    public static Map<Character, Integer> processFile() throws IOException {
        Map<Character, Integer> result = new HashMap<>();
        Files.lines(FILE.toPath())
                .forEach(l -> {
                    for (Character c : l.toCharArray()) {
                        Integer i = result.get(c);

                        if (i == null) {
                            i = 0;
                        }

                        result.put(c, ++i);
                    }
                });
        return result;
    }
}
