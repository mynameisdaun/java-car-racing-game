package com.racing.constant;

public class Constant {

    /* MESSAGE CONSTANT */
    public static final String MESSAGE_REQUEST_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String MESSAGE_REQUEST_REPETITIONS = "시도할 회수는 몇회인가요?";
    public static final String MESSAGE_EXECUTION_INIT = "실행 결과";
    public static final String MESSAGE_WINNER_SUFFIX = "가 최종 우승했습니다.";
    public static final String MESSAGE_ERROR_CAR_NAME_BLANK = "자동차 이름은 필수값 입니다.";
    public static final String MESSAGE_ERROR_CAR_NAME_OUT_OF_LIMIT = "자동차 이름은 5글자를 넘길 수 없습니다.";
    public static final String MESSAGE_ERROR_GENERATOR_MAX_BLANK = "최대값은 필수 값 입니다.";
    public static final String MESSAGE_ERROR_GENERATOR_MIN_BLANK = "최소값은 필수 값 입니다.";
    public static final String MESSAGE_ERROR_GENERATOR_MIN_AT_LEAST_ZERO = "최소값은 0 이상이어야 합니다.";
    public static final String MESSAGE_ERROR_PREFIX =  "[ERROR] -- ";

    /* PARAMETER CONSTANT */
    public static final String namePositionSeparator = " : ";
    public static final String EMPTY_LINE = "";
    public static final String WINNER_JOINING_DELIMITER = ", ";
    public static final String PARSER_CAR_NAME = ",";
    public static final String POSITION_VISUALIZATION = "-";
    public static final int referenceValue = 4;
    public static final int RANGE_DEFAULT_MAX = 9;
    public static final int RANGE_DEFAULT_MIN = 0;
    public static final int NAME_MAX_LENGTH = 5;
    public static final int CAR_DEFAULT_POSITION = 0;

}
