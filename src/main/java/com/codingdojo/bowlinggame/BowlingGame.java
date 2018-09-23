package com.codingdojo.bowlinggame;

class BowlingGame {

    private static final int FIRST_ROLL = 0;
    private static final int SECOND_ROLL = 1;
    private static final int TOTAL_SCORE_PER_FRAME = 10;
    private static final int THREE_ROLLS = 3;
    private static final int TWO_ROLLS = 2;
    private static final int INCREMENT_BY_TWO = 2;
    private static final int INCREMENT_BY_ONE = 1;
    private int roll = 0;
    private int[] rolls = new int[21];

    void roll(int... rolls) {
        for (int pinsDown : rolls) {
            roll(pinsDown);
        }
    }

    private void roll(int pinsDown) {
        rolls[roll++] = pinsDown;
    }

    int score() {
        int score = 0;
        return calculateTotalScore(score);
    }

    private int calculateTotalScore(int score) {
        int cursor = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isStrike(cursor)) {
                score = calculateScore(cursor, score, THREE_ROLLS);
                cursor = cursorOnNextFrame(cursor, INCREMENT_BY_ONE);
            }else if(isSpare(cursor)) {
                score = calculateScore(cursor, score, THREE_ROLLS);
                cursor = cursorOnNextFrame(cursor, INCREMENT_BY_TWO);
            }else{
                score = calculateScore(cursor, score, TWO_ROLLS);
                cursor = cursorOnNextFrame(cursor, INCREMENT_BY_TWO);
            }
        }
        return score;
    }

    private int calculateScore(int cursor, int score, int maxRolls) {
        for(int index = 0; index < maxRolls; index++){
            score += scorePerRoll(cursor, index);
        }
        return score;
    }

    private int cursorOnNextFrame(int cursor, int toIncrement) {
        cursor += toIncrement;
        return cursor;
    }

    private boolean isSpare(int cursor) {
        return totalScorePerFrame(cursor) == TOTAL_SCORE_PER_FRAME;
    }

    private boolean isStrike(int cursor) {
        return scorePerRoll(cursor, FIRST_ROLL) == TOTAL_SCORE_PER_FRAME;
    }

    private int totalScorePerFrame(int cursor) {
        return scorePerRoll(cursor, FIRST_ROLL) + scorePerRoll(cursor, SECOND_ROLL);
    }

    private int scorePerRoll(int cursor, int rollIndex) {
        return rolls[cursor + rollIndex];
    }
}
