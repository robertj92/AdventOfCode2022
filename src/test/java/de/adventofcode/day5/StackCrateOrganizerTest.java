package de.adventofcode.day5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackCrateOrganizerTest {

    @Test
    public void testStackCrateOrganizer() {
        var input = """
                    [D]
                [N] [C]
                [Z] [M] [P]
                 1   2   3
                                
                move 1 from 2 to 1
                move 3 from 1 to 3
                move 2 from 2 to 1
                move 1 from 1 to 2
                """;

        String organizedTopCrates = new StackCrateOrganizer().getOrganizedTopCrates(input);

        assertEquals("MCD", organizedTopCrates);
    }
}