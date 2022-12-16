package de.adventofcode.day1;

import de.adventofcode.utils.FileUtils;

public class Day1Main {
    public static void main(String[] args) {
        final var input = FileUtils.readFileFromString("day1/input.txt");
        Integer highestCalories = new CalorieCounter().findHighestCaloriesOfElves(input, 3);
        System.out.println("Highest calories are %s".formatted(highestCalories));
    }
}
