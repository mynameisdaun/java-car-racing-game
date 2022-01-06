package com.racing.generator;

import java.util.Random;

import static com.racing.constant.Constant.*;

public class RandomNumberGenerator implements NumberGenerator{

    private final int max;
    private final int min;

    @Override
    public int generate() {
        Random random = new Random();
        return random.nextInt(max+1) + min;
    }

    private RandomNumberGenerator(Range range) {
        this.max = range.max;
        this.min = range.min;
    }

    public static class Range {
        private Integer max;
        private Integer min;

        public Range() {}

        public Range max (int max) {
            this.max = max;
            return this;
        }

        public Range min (int min) {
            this.min = min;
            return this;
        }

        public RandomNumberGenerator setUp() {
            validate();
            return new RandomNumberGenerator(this);
        }

        private void validate() {
            if(this.max == null) {
                throw new IllegalArgumentException(MESSAGE_ERROR_GENERATOR_MAX_BLANK);
            }
            if(this.min == null) {
                throw new IllegalArgumentException(MESSAGE_ERROR_GENERATOR_MIN_BLANK);
            }
            if(this.min < 0) {
                throw new IllegalArgumentException(MESSAGE_ERROR_GENERATOR_MIN_AT_LEAST_ZERO);
            }
        }
    }
}
