package de.adventofcode.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RucksackItemSorterPartTwoTest {

    @Test
    public void testRucksackItemSorterPartTwo() {
        var input = """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
                """;

        Integer sumOfPriorities = new RucksackItemSorterPartTwo().prioritizeMisplacedItems(input);
        assertEquals(70, sumOfPriorities);
    }

}