package de.adventofcode.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorScorePredictorTest {

    private final RockPaperScissorScorePredictor rockPaperScissorScorePredictor = new RockPaperScissorScorePredictor();

    @Test
    public void testRockPaperWin() {
        final var input = "A Y";
        assertEquals(4, rockPaperScissorScorePredictor.predictScore(input));
    }

    @Test
    public void testPaperRockLoss() {
        final var input = "B X";
        assertEquals(1, rockPaperScissorScorePredictor.predictScore(input));
    }

    @Test
    public void testMultipleLines() {
        final var input = """
                A Y
                B X
                C Z
                """;

        assertEquals(12, rockPaperScissorScorePredictor.predictScore(input));
    }
}