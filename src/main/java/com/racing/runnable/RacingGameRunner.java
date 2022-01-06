package com.racing.runnable;

import com.racing.generator.NumberGenerator;
import com.racing.generator.RandomNumberGenerator;
import com.racing.model.RacingCarGroups;
import com.racing.model.MoveCondition;
import com.racing.game.MyRacingGame;
import com.racing.game.RacingGame;
import com.racing.view.RacingGameConsoleInput;
import com.racing.view.RacingGameConsoleOutput;
import com.racing.view.RacingGameInput;
import com.racing.view.RacingGameOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static com.racing.constant.Constant.*;

public class RacingGameRunner {

    public void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        RacingGameInput input = new RacingGameConsoleInput(br);
        RacingGameOutput output = new RacingGameConsoleOutput();

        // init
        RacingGame racingGame = RacingGameInitWithName(input);
        Integer numberOfRepetitions = getNumberOfRepetitions(input);

        processing(racingGame, numberOfRepetitions, output);

        processEnd(racingGame, output);
    }

    private RacingGame RacingGameInitWithName(RacingGameInput input) throws IOException {
        // MoveCondition: 자동차의 전진 조건(게임의 규칙) :  난수가 기준값보다 크면 전진
        NumberGenerator numberGenerator = createRandomNumberGenerator();
        MoveCondition moveCondition = createMoveCondition(numberGenerator);

        try {
            return createRacingGame(input, moveCondition);
        } catch (IllegalArgumentException e) {
            printError(e);
            return createRacingGame(input, moveCondition);
        }
    }

    private MoveCondition createMoveCondition(NumberGenerator numberGenerator) {
        return new MoveCondition(referenceValue, numberGenerator);
    }

    private RacingGame createRacingGame(RacingGameInput input, MoveCondition moveCondition) throws IOException {
        List<String> carName = input.requestCarName();
        RacingCarGroups racingCarGroups = RacingCarGroups.createCarGroupsWithName(carName);
        return new MyRacingGame(racingCarGroups, moveCondition);
    }

    private Integer getNumberOfRepetitions(RacingGameInput input) throws IOException {
        return input.requestNumberOfRepetitions();
    }

    private void processing(RacingGame racingGame, Integer numberOfRepetitions, RacingGameOutput output) {
        output.printRacingStartMessage();

        for(int i = 0; i < numberOfRepetitions; i ++) {
            racingGame.startRacing();
            output.printRacingStatus(racingGame);
        }
    }

    private void processEnd(RacingGame racingGame, RacingGameOutput output) {
        output.printWinner(racingGame);
    }

    private NumberGenerator createRandomNumberGenerator() {
        NumberGenerator numberGenerator = new RandomNumberGenerator.Range()
                .max(RANGE_DEFAULT_MAX)
                .min(RANGE_DEFAULT_MIN)
                .setUp();
        return numberGenerator;
    }

    private void printError(IllegalArgumentException e) {
        System.out.println(MESSAGE_ERROR_PREFIX + e.getMessage());
    }
}
