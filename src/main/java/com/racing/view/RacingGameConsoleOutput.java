package com.racing.view;

import com.racing.game.RacingGame;
import com.racing.model.CarInfo;
import com.racing.model.RacingCarGroups;

import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.racing.constant.Constant.*;
import static com.racing.constant.Constant.POSITION_VISUALIZATION;

public class RacingGameConsoleOutput implements RacingGameOutput {

    @Override
    public void printRacingStartMessage() {
        print(MESSAGE_EXECUTION_INIT);
    }

    @Override
    public void printRacingStatus(RacingGame racingGame) {
        getRacingCarGroups(racingGame).findNameWithPosition()
                .forEach(printCarInfo());
        print(EMPTY_LINE);
    }

    private RacingCarGroups getRacingCarGroups(RacingGame racingGame) {
        return racingGame.getRacingCarGroups();
    }

    @Override
    public void printWinner(RacingGame racingGame) {
        String winner = createWinnerNameString(getRacingCarGroups(racingGame));
        print(winner+MESSAGE_WINNER_SUFFIX);
    }

    private String createWinnerNameString(RacingCarGroups racingCarGroups) {
        return racingCarGroups.getWinner()
                .stream()
                .map(CarInfo::getName)
                .collect(Collectors.joining(WINNER_JOINING_DELIMITER));
    }

    private Consumer<CarInfo> printCarInfo() {
        return car -> print(car);
    }

    private void print(CarInfo carInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append(carName(carInfo))
                .append(namePositionSeparator)
                .append(carPosition(carInfo));
        print(sb.toString());
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String carPosition(CarInfo carInfo) {
        StringBuilder sb = new StringBuilder();
        carPositionVisualization(carInfo, sb);
        return sb.toString();
    }

    private void carPositionVisualization(CarInfo carInfo, StringBuilder sb) {
        for(int i = 0; i < carInfo.getPosition() ; i ++) {
            sb.append(POSITION_VISUALIZATION);
        }
    }

    private String carName(CarInfo carInfo) {
        return carInfo.getName();
    }
}
