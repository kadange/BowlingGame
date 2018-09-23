package com.codingdojo.bowlinggame;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BowlingMainTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void should_return_total_score_0_when_game_is_gutter_game() {
        bowlingGame.setScorePerGame(0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingGame.getTotalScore(), is(0));
    }

    @Test
    public void should_return_total_score_20_when_game_is_1_pin_per_roll() {
        bowlingGame.setScorePerGame(1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1, 1,1);
        assertThat(bowlingGame.getTotalScore(), is(20));
    }

    @Test
    public void should_return_total_score_16_when_game_is_spare_and_3_and_0_on_next_frame() {
        bowlingGame.setScorePerGame(5,5, 3,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingGame.getTotalScore(), is(16));
    }

    @Test
    public void should_return_total_score_22_when_game_is_strike_and_3_and_3_on_next_frame() {
        bowlingGame.setScorePerGame(10, 3,3, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0, 0,0);
        assertThat(bowlingGame.getTotalScore(), is(22));
    }

    @Test
    public void should_return_total_score_300_when_game_is_strike_game() {
        bowlingGame.setScorePerGame(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        assertThat(bowlingGame.getTotalScore(), is(300));
    }
}
