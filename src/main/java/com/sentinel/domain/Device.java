package com.sentinel.domain;

import com.sentinel.domain.directions.Direction;
import com.sentinel.domain.directions.DirectionAxe;
import com.sentinel.domain.directions.DirectionState;

import java.util.EnumMap;
import java.util.Map;

public class Device {
    private final Direction position;
    private final Direction rotation;
    private final Map<DirectionAxe, Boolean> blockedPositions;

    public Device () {
        position = Direction.idleAll();
        rotation = Direction.idleAll();
        blockedPositions = new EnumMap<>(DirectionAxe.class);
    }

    public void changePosition(DirectionAxe directionAxe, DirectionState state) {
        if (blockedPositions.containsKey(directionAxe) && Boolean.TRUE.equals(blockedPositions.get(directionAxe))) {
            return;
        }
        position.set(directionAxe, state);
    }

    public void changeRotation(DirectionAxe directionAxe, DirectionState state) {
        rotation.set(directionAxe, state);
    }

    public void setBlockedPositionState(DirectionAxe directionAxe, boolean blocked) {
        blockedPositions.put(directionAxe, blocked);
        position.set(directionAxe, DirectionState.IDLE);
    }

    public DirectionState getPosition(DirectionAxe directionAxes) {
        return position.get(directionAxes);
    }

    public DirectionState getRotation(DirectionAxe directionAxes) {
        return rotation.get(directionAxes);
    }

}
