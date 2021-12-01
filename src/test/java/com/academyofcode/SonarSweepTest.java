package com.academyofcode;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.academyofcode.utils.FileUtils.getFileFromResource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SonarSweepTest {

    private static List<Integer> data;

    @BeforeAll
    public static void setUp() throws URISyntaxException, IOException {
        File file = getFileFromResource("sonar-sweep-input");
        String[] input = Files.asCharSource(file, Charsets.UTF_8).read()
                .split("\r\n");
        data = Arrays.stream(input)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    @Test
    public void shouldGetIncreasingDepthMeasurements() {
        int increasingDepthMeasurementsCount = SonarSweep.getMeasurements(data);
        assertEquals(increasingDepthMeasurementsCount, 1400);
    }

    @Test
    public void shouldGetIncreasingDepthMeasurementsInSlidingWindow() {
        int increasingDepthMeasurementsCount = SonarSweep.getMeasurementsInSlidingWindow(data);
        assertEquals(increasingDepthMeasurementsCount, 1429);
    }
}
