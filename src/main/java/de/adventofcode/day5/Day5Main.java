package de.adventofcode.day5;

import de.adventofcode.utils.FileUtils;

public class Day5Main {

    public static void main(String[] args) {
        StackCrateOrganizer stackCrateOrganizer = new StackCrateOrganizer();
        String input = FileUtils.readFileFromString("day5/input.txt");
        String organizedTopCrates = stackCrateOrganizer.getOrganizedTopCrates(input);
        System.out.println("The organized top crates are " + organizedTopCrates);
    }
}
