package com.racing.view;

import com.racing.game.RacingGame;

public interface RacingGameOutput {

    void printRacingStartMessage();

    void printRacingStatus(RacingGame racingGame);

    void printWinner(RacingGame racingGame);

}
