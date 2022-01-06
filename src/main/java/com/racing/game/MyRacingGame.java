package com.racing.game;

import com.racing.model.CarInfo;
import com.racing.model.MoveCondition;
import com.racing.model.RacingCarGroups;

import java.util.List;

public class MyRacingGame implements RacingGame {

    private RacingCarGroups racingCarGroups;
    private MoveCondition moveCondition;

    public MyRacingGame(RacingCarGroups racingCarGroups, MoveCondition moveCondition) {
        setUp(racingCarGroups, moveCondition);
    }

    @Override
    public void setUp(RacingCarGroups racingCarGroups, MoveCondition moveCondition) {
        this.racingCarGroups = racingCarGroups;
        this.moveCondition = moveCondition;
    }

    @Override
    public void startRacing() {
        this.racingCarGroups.race((car) -> moveCondition.isTrue());
    }

    @Override
    public List<CarInfo> getWinner() {
        return this.racingCarGroups.getWinner();
    }

    @Override
    public RacingCarGroups getRacingCarGroups() {
        return this.racingCarGroups;
    }
}
