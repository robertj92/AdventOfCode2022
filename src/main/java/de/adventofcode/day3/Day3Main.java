package de.adventofcode.day3;

import de.adventofcode.utils.FileUtils;

public class Day3Main {

    public static void main(String[] args) {
        RucksackItemSorter rucksackItemSorter = new RucksackItemSorter();
        String input = FileUtils.readFileFromString("day3/input.txt");
        System.out.printf("Priorities are %s%n", rucksackItemSorter.prioritizeMisplacedItems(input));

        RucksackItemSorterPartTwo rucksackItemSorterPartTwo = new RucksackItemSorterPartTwo();
        System.out.printf("Priorities in Part Two are %s%n", rucksackItemSorterPartTwo.prioritizeMisplacedItems(input));
    }
}
