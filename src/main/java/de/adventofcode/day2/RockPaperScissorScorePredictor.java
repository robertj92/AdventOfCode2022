package de.adventofcode.day2;

public class RockPaperScissorScorePredictor {

    private static final Integer WIN_SCORE = 6;
    private static final Integer LOSS_SCORE = 0;
    private static final Integer DRAW_SCORE = 3;

    private static final String OPPONENT_ROCK = "A";
    private static final String OPPONENT_PAPER = "B";
    private static final String OPPONENT_SCISSOR = "C";

    private static final String PLAYER_LOSS = "X";
    private static final String PLAYER_DRAW = "Y";
    private static final String PLAYER_WIN = "Z";

    private static final Integer ROCK_POINTS = 1;
    private static final Integer PAPER_POINTS = 2;
    private static final Integer SCISSOR_POINTS = 3;

    public Integer predictScore(final String input) {
        return input.lines().map(this::processLine).reduce(Integer::sum).orElse(0);
    }

    private Integer processLine(final String line) {
        final String[] hands = line.split(" ");
        final String opponentHand = hands[0];
        final String playerHand = hands[1];

        return calculateRoundScore(opponentHand, playerHand);
    }

    private Integer calculateRoundScore(final String opponentHand, final String playerWishedResult) {
        int score = 0;

        switch (opponentHand) {
            case OPPONENT_ROCK -> {
                switch (playerWishedResult) {
                    case PLAYER_WIN -> score = PAPER_POINTS + WIN_SCORE;
                    case PLAYER_DRAW -> score = ROCK_POINTS + DRAW_SCORE;
                    case PLAYER_LOSS -> score = SCISSOR_POINTS + LOSS_SCORE;
                }
            }
            case OPPONENT_PAPER -> score = switch (playerWishedResult) {
                case PLAYER_WIN -> SCISSOR_POINTS + WIN_SCORE;
                case PLAYER_DRAW -> PAPER_POINTS + DRAW_SCORE;
                case PLAYER_LOSS -> ROCK_POINTS + LOSS_SCORE;
                default -> score;
            };
            case OPPONENT_SCISSOR -> score = switch (playerWishedResult) {
                case PLAYER_WIN -> ROCK_POINTS + WIN_SCORE;
                case PLAYER_DRAW -> SCISSOR_POINTS + DRAW_SCORE;
                case PLAYER_LOSS -> PAPER_POINTS + LOSS_SCORE;
                default -> score;
            };
        }

        return score;
    }
}
