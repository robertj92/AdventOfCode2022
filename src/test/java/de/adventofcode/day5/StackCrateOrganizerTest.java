package de.adventofcode.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackCrateOrganizerTest {

    @Test
    public void testStackCrateOrganizer() {
        var input = """
                [A] [B]
                1   2
                
                move 1 from 1 to 2
                """;

        String organizedTopCrates = new StackCrateOrganizer().getOrganizedTopCrates(input);

        assertEquals("A", organizedTopCrates);
    }
}