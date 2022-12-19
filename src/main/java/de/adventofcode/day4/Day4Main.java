package de.adventofcode.day4;

import de.adventofcode.utils.FileUtils;

public class Day4Main {

    public static void main(String[] args) {
        CampCleanupOrganizer campCleanupOrganizer = new CampCleanupOrganizer();
        String input = FileUtils.readFileFromString("day4/input.txt");
        Integer overlappingPairs = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, false);
        System.out.printf("Number of fully overlapping pairs is %s%n", overlappingPairs);

        Integer partiallyOverlappingPairs = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, true);
        System.out.printf("Number of partially overlapping pairs is %s%n", partiallyOverlappingPairs);
    }
}
