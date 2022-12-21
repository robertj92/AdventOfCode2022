package de.adventofcode.day5;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class StackCrateOrganizer {

    public static final Integer STACK_LENGTH = 4;

    public String getOrganizedTopCrates(String input) {
        int numberOfStacks = getNumberOfStacks(input);
        List<Stack<String>> stacks = initializeStacks(numberOfStacks);

        fillStacks(input, stacks);

        moveCratesInStacks(input, stacks);

        return getTopCratesFromStacks(stacks);
    }

    private String getTopCratesFromStacks(List<Stack<String>> stacks) {
        StringBuilder result = new StringBuilder();

        for (Stack<String> stack : stacks) {
            if (!stack.empty()) {
                result.append(stack.peek());
            }
        }

        return result.toString();
    }

    private void moveCratesInStacks(String input, List<Stack<String>> stacks) {
        input.lines().filter(line -> line.startsWith("move")).forEach(line -> {
            String[] lineElements = line.split(" ");
            int numberOfCrates = Integer.parseInt(lineElements[1]);
            int fromCrate = Integer.parseInt(lineElements[3]);
            int toCrate = Integer.parseInt(lineElements[5]);

            Stack<String> cratesToMove = new Stack<>();

            while (numberOfCrates > 0) {
                String crate = stacks.get(fromCrate - 1).pop();
                cratesToMove.push(crate);
                numberOfCrates--;
            }

            while (!cratesToMove.empty()) {
                stacks.get(toCrate - 1).push(cratesToMove.pop());
            }
        });
    }

    private void fillStacks(String input, List<Stack<String>> stacks) {
        List<String> stackRows = input.lines()
                .filter(line -> line.contains("["))
                .toList();

        stackRows = new ArrayList<>(stackRows);

        Collections.reverse(stackRows);

        stackRows.forEach(stackRow -> {
            for (int rowIndex = 1; rowIndex < stacks.size() * STACK_LENGTH && rowIndex < stackRow.length(); rowIndex += STACK_LENGTH) {
                char characterAtPosition = stackRow.charAt(rowIndex);
                if (characterAtPosition != ' ') {
                    stacks.get(rowIndex / STACK_LENGTH).push(String.valueOf(characterAtPosition));
                }
            }
        });
    }

    private int getNumberOfStacks(String input) {
        String stackNumberingRow = input.lines()
                .filter(line -> !line.isBlank() && StringUtils.isNumeric(line.substring(1, 2)))
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
