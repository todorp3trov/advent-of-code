package com.academyofcode;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.academyofcode.utils.FileUtils.getFileFromResource;

public class SonarSweep {

    public static void main(String[] args) throws IOException, URISyntaxException {
        File file = getFileFromResource("sonar-sweep-input");
        String[] input = Files.asCharSource(file, Charsets.UTF_8).read()
                .split("\r\n");

        List<Integer> data = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        System.out.println("Generic increasing depth measurements: " + getMeasurements(data));
        System.out.println("************************");
        System.out.println("Sliding window increasing depth measurements: " + getMeasurementsInSlidingWindow(data));
    }

    public static int getMeasurements(List<Integer> data) {
        int count = 0;
        int previousMeasurement = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            int currentMeasurement = data.get(i);
            if (currentMeasurement > previousMeasurement) count++;
            previousMeasurement = currentMeasurement;
        }

        return count;
    }

    public static int getMeasurementsInSlidingWindow(List<Integer> data) {
        int count = 0;
        int previousMeasurement = data.get(0) + data.get(1) + data.get(2);
        for (int i = 1; i < data.size() - 2; i++) {
            int currentMeasurement = data.get(i) + data.get(i + 1) + data.get(i + 2);
            if (currentMeasurement > previousMeasurement) count++;
            previousMeasurement = currentMeasurement;
        }

        return count;
    }
}
