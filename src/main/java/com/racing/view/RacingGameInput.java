package com.racing.view;

import java.io.IOException;
import java.util.List;

public interface RacingGameInput {

    List<String> requestCarName() throws IOException;

    Integer requestNumberOfRepetitions() throws IOException;

}
