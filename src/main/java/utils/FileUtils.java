package utils;

import com.academyofcode.solutions.DayOne.SonarSweep;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUtils {

    public FileUtils() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = SonarSweep.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            // failed if files have whitespaces or special characters
            //return new File(resource.getFile());
            return new File(resource.toURI());
        }

    }
}
