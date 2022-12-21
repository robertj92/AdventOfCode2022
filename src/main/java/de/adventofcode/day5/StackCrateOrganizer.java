package de.adventofcode.day5;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StackCrateOrganizer {

    public static final Integer STACK_LENGTH = 4;

    /*
    [A] [B]
    1   2

    move 1 from 1 to 2
     */

    public String getOrganizedTopCrates(String input) {
        String crates = "A";

        int numberOfStacks = getNumberOfStacks(input);
        List<Stack<String>> stacks = initializeStacks(numberOfStacks);

        fillStacks(input, stacks);

        return crates;
    }

    private void fillStacks(String input, List<Stack<String>> stacks) {
        List<String> stackRows = input.lines()
                .filter(line -> line.contains("["))
                .toList();

        stackRows.forEach(stackRow -> {
            for (int rowIndex = 1; rowIndex < stacks.size() * STACK_LENGTH; rowIndex += STACK_LENGTH) {

            }
        });
    }

    private int getNumberOfStacks(String input) {
        String stackNumberingRow = input.lines()
                .filter(line -> !line.isBlank() && StringUtils.isNumeric(line.substring(0, 1)))
                .findFirst()
                .orElseThrow();

        return stackNumberingRow.split("   ").length;
    }

    private List<Stack<String>> initializeStacks(int numberOfStacks) {
        List<Stack<String>> stacks = new ArrayList<>();

        for (int i = 0; i < numberOfStacks; i++) {
            stacks.add(new Stack<>());
        }

        return stacks;
    }
}
