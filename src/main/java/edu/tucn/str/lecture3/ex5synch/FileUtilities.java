package edu.tucn.str.lecture3.ex5synch;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO: Write unit tests for each method
 *
 * @author Radu Miron
 * @version 1
 */
public class FileUtilities {
    public static final String FILES_DIR = "lecture5_files";
    public static final String AGGREGATOR_FILE_NAME = "aggregator-file.txt";

    private FileUtilities() {
    }

    public static List<String> readFile(File file) throws IOException {
        if (file == null) {
            return null;
        }

        return Files.lines(file.toPath())
                .filter(l -> StringUtils.isNotEmpty(l))
                .collect(Collectors.toList());
    }

    public static void writeLinesToFile(List<String> lines, File file) {
        lines.stream()
                .forEach(line -> {
                    try {
                        FileUtils.writeStringToFile(file, line + "\n", StandardCharsets.UTF_8, true);
                    } catch (IOException e) {
                        new RuntimeException(e);
                    }
                });
    }

    public static File nextFile() {
        String threadName = Thread.currentThread().getName();
        String[] threadNameComponents = threadName.split("\\-");
        boolean isOddThread = threadNameComponents[threadNameComponents.length - 1].equals("1");

        return Arrays.stream(new File(FILES_DIR).listFiles()) //read all files from given dir
                .filter(f -> !f.getName().equals(AGGREGATOR_FILE_NAME))
                .filter(f -> (isOddThread && f.getName().hashCode() % 2 == 1) // keep (filter) files with odd id names
                        || (!isOddThread && f.getName().hashCode() % 2 == 0)) // keep (filter) files with even id names
                .findFirst() // we only need one file at a time; only keep the first file
                .orElse(null); // if we don't find any file matching the filter criteria, return null
    }

    public static void deleteFile(File file) throws IOException {
        Files.delete(file.toPath());
    }

    public static File getAggregatorFile() {
        return new File(FILES_DIR, AGGREGATOR_FILE_NAME);
    }
}
