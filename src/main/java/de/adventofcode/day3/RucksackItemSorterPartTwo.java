package de.adventofcode.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RucksackItemSorterPartTwo {

    public Integer prioritizeMisplacedItems(String input) {
        List<String> rucksacks = input.lines().toList();

        List<Integer> results = new ArrayList<>();
        for (int rucksackCounter = 0; rucksackCounter < rucksacks.size(); rucksackCounter++) {
            if (rucksackCounter != 0 && rucksackCounter % 3 == 0) {
                Integer result = calculateMisplacedItemsPrioritiesInRucksack(rucksacks.get(rucksackCounter-2), rucksacks.get(rucksackCounter-1), rucksacks.get(rucksackCounter));
                results.add(result);
            }
        }

        return results.stream().reduce(Integer::sum).orElse(0);
    }

    private Integer calculateMisplacedItemsPrioritiesInRucksack(final String... rucksacks) {

        final Set<Character> badgeItems = new HashSet<>();

        String rucksackOne = rucksacks[0];
        for (char character : rucksackOne.toCharArray()) {
            for (char character2 : rucksacks[1].toCharArray()) {
                for (char character3 : rucksacks[2].toCharArray()) {
                    if (character == character2 && character2 == character3) {
                        badgeItems.add(character);
                    }
                }
            }
        }

        return badgeItems.stream().map(this::mapItemToPriority).reduce(Integer::sum).orElse(0);
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
