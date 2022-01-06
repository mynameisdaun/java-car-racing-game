package com.racing.model;

import com.racing.generator.NumberGenerator;

public class MoveCondition {

    private final int referenceValue;
    private final NumberGenerator numberGenerator;

    public MoveCondition(int referenceValue, NumberGenerator numberGenerator) {
        this.referenceValue = referenceValue;
        this.numberGenerator = numberGenerator;
    }

    public boolean isTrue(){
        return numberGenerator.generate() > referenceValue;
    }

}
