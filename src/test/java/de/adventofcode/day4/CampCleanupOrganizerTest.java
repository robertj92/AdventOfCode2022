package de.adventofcode.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampCleanupOrganizerTest {

    private final CampCleanupOrganizer campCleanupOrganizer = new CampCleanupOrganizer();

    @Test
    public void testAssignmentContainsOtherAssignment() {
        String input = "2-4,6-8";
        Integer count = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, false);
        assertEquals(0, count);

        input = "6-6,4-6";
        count = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, false);
        assertEquals(1, count);

        input = "6-6,4-6\n2-4,6-8";
        count = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, false);
        assertEquals(1, count);
    }

    @Test
    public void testInput() {
        var input = """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8
                """;

        Integer count = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, false);
        assertEquals(2, count);
    }

    @Test
    public void testInputPartially() {
        var input = """
                2-4,6-8
                2-3,4-5
                5-7,7-9
                2-8,3-7
                6-6,4-6
                2-6,4-8
                """;

        Integer count = campCleanupOrganizer.countAssignmentsThatContainOtherAssignment(input, true);
        assertEquals(4, count);
    }
}