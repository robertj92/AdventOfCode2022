package de.adventofcode.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalorieCounter {

    public Integer findHighestCaloriesOfElves(final String input, final Integer numberOfElves) {
        List<String> lines = input.lines().toList();

        final List<Integer> results = new ArrayList<>();
        Integer currentResult = 0;
        for (var line : lines) {
            if (line.isBlank()) {
                results.add(currentResult);
                currentResult = 0;
            } else {
                currentResult += Integer.parseInt(line);
            }
        }
        results.add(currentResult);

        return results.stream().sorted(Comparator.reverseOrder()).limit(numberOfElves).reduce(Integer::sum).orElse(0);
    }
}