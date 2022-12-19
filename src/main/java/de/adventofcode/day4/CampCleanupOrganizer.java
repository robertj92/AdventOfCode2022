package de.adventofcode.day4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CampCleanupOrganizer {

    public Integer countAssignmentsThatContainOtherAssignment(final String input, final boolean partially) {
        return Math.toIntExact(input.lines().map(input1 -> isOneAssignmentContainedInOtherAssignment(input1, partially)).filter(isContained -> isContained).count());
    }

    private boolean isOneAssignmentContainedInOtherAssignment(String input, final boolean partially) {
        String[] pair = input.split(",");

        List<Integer> pairOneSections = extractSectionsFromAssignment(pair[0]);
        List<Integer> pairTwoSections = extractSectionsFromAssignment(pair[1]);

        boolean assignmentContainsOtherAssignment = false;

        if (partially) {
            for (Integer section : pairOneSections) {
                if (pairTwoSections.contains(section)) {
                    assignmentContainsOtherAssignment = true;
                    break;
                }
            }
        } else {
            if (new HashSet<>(pairOneSections).containsAll(pairTwoSections) || new HashSet<>(pairTwoSections).containsAll(pairOneSections)) {
                assignmentContainsOtherAssignment = true;
            }
        }

        return assignmentContainsOtherAssignment;
    }

    private List<Integer> extractSectionsFromAssignment(String assignment) {
        String[] firstPairAssignments = assignment.split("-");
        int firstPairFrom = Integer.parseInt(firstPairAssignments[0]);
        int firstPairTo = Integer.parseInt(firstPairAssignments[1]);

        List<Integer> firstPairSections = new ArrayList<>();

        for (int i = firstPairFrom; i <= firstPairTo; i++) {
            firstPairSections.add(i);
        }

        return firstPairSections;
    }
}
