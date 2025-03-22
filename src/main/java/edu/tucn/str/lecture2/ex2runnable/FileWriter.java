package edu.tucn.str.lecture2.ex2runnable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */

public class FileWriter {
    public void writeToFile(File file, String content, boolean append) {
        try {
            FileUtils.writeStringToFile(file, content, append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
