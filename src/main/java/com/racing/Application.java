package com.racing;

import com.racing.runnable.RacingGameRunner;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        RacingGameRunner runner = new RacingGameRunner();
        runner.run();
    }
}
