package de.adventofcode.day2;

import de.adventofcode.utils.FileUtils;

public class Day2Main {

    public static void main(String[] args) {
        RockPaperScissorScorePredictor rockPaperScissorScorePredictor = new RockPaperScissorScorePredictor();
        String input = FileUtils.readFileFromString("day2/input.txt");
        Integer score = rockPaperScissorScorePredictor.predictScore(input);

        System.out.printf("Predicted score is %s%n", score);
    }
}
