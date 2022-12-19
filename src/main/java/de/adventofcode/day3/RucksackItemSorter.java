package de.adventofcode.day3;

import java.util.HashSet;
import java.util.Set;

public class RucksackItemSorter {

    public Integer prioritizeMisplacedItems(String input) {
        return input.lines().map(this::calculateMisplacedItemsPrioritiesInRucksack).reduce(Integer::sum).orElse(0);
    }

    private Integer calculateMisplacedItemsPrioritiesInRucksack(final String rucksack) {
        String firstCompartment = rucksack.substring(0, rucksack.length() / 2);
        String secondCompartment = rucksack.substring(rucksack.length()/2);

        final Set<Character> misplacedItems = new HashSet<>();

        for (char itemInFirstCompartment : firstCompartment.toCharArray()) {
            for (char itemInSecondCompartment : secondCompartment.toCharArray()) {
                if (itemInFirstCompartment == itemInSecondCompartment) {
                    misplacedItems.add(itemInFirstCompartment);
                }
            }
        }

        return misplacedItems.stream().map(this::mapItemToPriority).reduce(Integer::sum).orElse(0);
    }

    private Integer mapItemToPriority(final char item) {
        if (item >= 'a' && item <= 'z') {
            return item - 96;
        } else if (item >= 'A' && item <= 'Z') {
            return item - 38;
        } else {
            return 0;
        }
    }
}
