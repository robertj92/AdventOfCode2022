package de.adventofcode.day2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RockPaperScissorScorePredictorTest {

    @Test
    public void testRockPaperWin() {
        final var input = "A Y";
        assertEquals(8, new RockPaperScissorScorePredictor().predictScore(input));
    }

    @Test
    public void testPaperRockLoss() {
        final var input = "B X";
        assertEquals(1, new RockPaperScissorScorePredictor().predictScore(input));
    }
}