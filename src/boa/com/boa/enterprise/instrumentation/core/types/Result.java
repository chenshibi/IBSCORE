package com.boa.enterprise.instrumentation.core.types;

public enum Result {

    SUCCEEDED(1), FAILED(0);
    private int value;

    private Result(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
