package com.racing.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import static com.racing.constant.Constant.*;
import static java.util.Arrays.asList;

public class RacingGameConsoleInput implements RacingGameInput {

    private BufferedReader br;

    public RacingGameConsoleInput(BufferedReader br) {
        this.br = br;
    }

    @Override
    public List<String> requestCarName() throws IOException {
        print(MESSAGE_REQUEST_NAME);
        String carNames = requestConsoleInput();
        return splitCarNamesWith(carNames,PARSER_CAR_NAME);
    }

    @Override
    public Integer requestNumberOfRepetitions() throws IOException {
        print(MESSAGE_REQUEST_REPETITIONS);
        String numberOfRepetitions = requestConsoleInput();
        return toInt(numberOfRepetitions);
    }

    private List<String> splitCarNamesWith(String input, String parser) {


        return asList(input.split(parser));
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    private void print(String message) {
        System.out.println(message);
    }

    private String requestConsoleInput() throws IOException {
        return br.readLine();
    }
}
