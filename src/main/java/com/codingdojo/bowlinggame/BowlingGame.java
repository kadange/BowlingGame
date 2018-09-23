package com.codingdojo.bowlinggame;

class BowlingGame {

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
        cursor = 0;
        for(int frame = 0; frame < 10; frame++){
            if(isStrike()) {
                score += 10 + rolls[cursor+1] + rolls[cursor+2];
                cursorOnNextFrame(1);
            }else if(isSpare()) {
                score += 10 + rolls[cursor+2];
                cursorOnNextFrame(2);
            }else{
                score += rolls[cursor] + rolls[cursor+1];
                cursorOnNextFrame(2);
            }
        }
        return score;
    }

    private void cursorOnNextFrame(int toIncrement) {
        cursor += toIncrement;
    }

    private boolean isSpare() {
        return rolls[cursor] + rolls[cursor+1] == 10;
    }

    private boolean isStrike() {
        return rolls[cursor] == 10;
    }
}
