package com.sentinel.domain.directions;

public class Direction {
    private DirectionState x;
    private DirectionState y;
    private DirectionState z;

    public static Direction idleAll() {
        return new Direction(DirectionState.IDLE, DirectionState.IDLE, DirectionState.IDLE);
    }

    public static Direction forwardAll() {
        return new Direction(DirectionState.FORWARD, DirectionState.FORWARD, DirectionState.FORWARD);
    }

    public Direction(DirectionState x, DirectionState y, DirectionState z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public DirectionState get(DirectionAxe directionAxe) {
        return switch (directionAxe) {
            case X -> x;
            case Y -> y;
            case Z -> z;
        };
    }

    public void set(DirectionAxe directionAxe, DirectionState directionState) {
        switch (directionAxe) {
            case X -> x = directionState;
            case Y -> y = directionState;
            case Z -> z = directionState;
        }
    }
}