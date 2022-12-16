package de.adventofcode.day1;

import de.adventofcode.utils.FileUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalorieCounterTest {

    final CalorieCounter calorieCounter = new CalorieCounter();

    @Test
    public void testFindHighestWithOnePersonCalories() {
        assertEquals(1000, calorieCounter.findHighestCaloriesOfElves("1000", 1));
        assertEquals(2000, calorieCounter.findHighestCaloriesOfElves("2000", 1));
    }

    @Test
    public void testFindHighestWithTwoLinesCalories() {
        var input = """
                1000
                2000""";

        assertEquals(3000, calorieCounter.findHighestCaloriesOfElves(input, 1));
    }

    @Test
    public void testFindHighestWithTwoPersonsCalories() {
        var input = """
                1000
                
                2000""";

        assertEquals(2000, calorieCounter.findHighestCaloriesOfElves(input, 1));

        input = """
                2000
                
                1000""";

        assertEquals(2000, calorieCounter.findHighestCaloriesOfElves(input, 1));
    }

    @Test
    public void testTestFile() {
        var input = FileUtils.readFileFromString("day1/test_input.txt");

        assertEquals(24000, calorieCounter.findHighestCaloriesOfElves(input, 1));
    }

    @Test
    public void testWithThreeElves() {
        var input = FileUtils.readFileFromString("day1/test_input.txt");

        assertEquals(45000, calorieCounter.findHighestCaloriesOfElves(input, 3));
    }
}