package com.sentinel.domain.directions;

public enum DirectionState {
    IDLE(0),
    FORWARD(1),
    BACKWARD(-1);

    private final int value;
    DirectionState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
