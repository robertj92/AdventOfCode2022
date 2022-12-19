package de.adventofcode.day3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RucksackItemSorterTest {

    private final RucksackItemSorter rucksackItemSorter = new RucksackItemSorter();

    @Test
    public void testSortRucksackItems() {
        var input = "ab";
        Integer priorities = rucksackItemSorter.prioritizeMisplacedItems(input);
        assertEquals(0, priorities);

        input = "abac";
        priorities = rucksackItemSorter.prioritizeMisplacedItems(input);
        assertEquals(1, priorities);
    }

    @Test
    public void testSortRucksackItemsWithMultipleRucksacks() {
        var input = """
                ab
                abac
                """;

        var priorities = rucksackItemSorter.prioritizeMisplacedItems(input);
        assertEquals(1, priorities);
    }

    @Test
    public void testSortRucksackItemsWithMultipleRucksacksTestInput() {
        var input = """
                vJrwpWtwJgWrhcsFMMfFFhFp
                jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
                PmmdzqPrVvPwwTWBwg
                wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
                ttgJtRGJQctTZtZT
                CrZsJsPPZsGzwwsLwLmpwMDw
                """;

        var priorities = rucksackItemSorter.prioritizeMisplacedItems(input);
        assertEquals(157, priorities);
    }
}