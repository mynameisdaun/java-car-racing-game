package com.racing.game;

import com.racing.generator.NumberGenerator;
import com.racing.model.CarInfo;
import com.racing.model.MoveCondition;
import com.racing.model.RacingCarGroups;

import java.util.List;

public interface RacingGame {

    void setUp(RacingCarGroups racingCarGroups, MoveCondition moveCondition);

    void startRacing();

    List<CarInfo> getWinner();

    RacingCarGroups getRacingCarGroups();

}
