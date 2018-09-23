package com.codingdojo.bowlinggame;

class BowlingGame {

    public static final int FIRST_ROLL = 0;
    public static final int SECOND_ROLL = 1;
    public static final int TOTAL_SCORE_PER_FRAME = 10;
    private int roll = 0;
    private int[] rolls = new int[21];
    private int cursor;

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
        cursor = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isStrike()) {
                score = calculateScore(score, 3);
                cursorOnNextFrame(1);
            }else if(isSpare()) {
                score = calculateScore(score, 3);
                cursorOnNextFrame(2);
            }else{
                score = calculateScore(score, 2);
                cursorOnNextFrame(2);
            }
        }
        return score;
    }

    private int calculateScore(int score, int loop) {
        for(int index = 0; index < loop; index++){
            score += scorePerRoll(index);
        }
        return score;
    }

    private void cursorOnNextFrame(int toIncrement) {
        cursor += toIncrement;
    }

    private boolean isSpare() {
        return totalFrameScore() == TOTAL_SCORE_PER_FRAME;
    }

    private boolean isStrike() {
        return scorePerRoll(FIRST_ROLL) == TOTAL_SCORE_PER_FRAME;
    }

    private int totalFrameScore() {
        return scorePerRoll(FIRST_ROLL) + scorePerRoll(SECOND_ROLL);
    }

    private int scorePerRoll(int rollIndex) {
        return rolls[cursor + rollIndex];
    }
}
