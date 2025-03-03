package com.sentinel.domain;

import com.sentinel.domain.directions.DirectionAxe;
import com.sentinel.domain.directions.DirectionState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DeviceTest {

    @Test
    void initDeviceTest() {
        final Device device = new Device();

        Assertions.assertEquals(DirectionState.IDLE, device.getPosition(DirectionAxe.X));
        Assertions.assertEquals(DirectionState.IDLE, device.getPosition(DirectionAxe.Y));
        Assertions.assertEquals(DirectionState.IDLE, device.getPosition(DirectionAxe.Z));

        Assertions.assertEquals(DirectionState.IDLE, device.getRotation(DirectionAxe.X));
        Assertions.assertEquals(DirectionState.IDLE, device.getRotation(DirectionAxe.Y));
        Assertions.assertEquals(DirectionState.IDLE, device.getRotation(DirectionAxe.Z));
    }

    @Test
    void changePositionTest() {
        final Device device = new Device();

        device.changePosition(DirectionAxe.X, DirectionState.FORWARD);
        device.changePosition(DirectionAxe.Y, DirectionState.BACKWARD);
        device.changePosition(DirectionAxe.Z, DirectionState.IDLE);

        Assertions.assertEquals(DirectionState.FORWARD, device.getPosition(DirectionAxe.X));
        Assertions.assertEquals(DirectionState.BACKWARD, device.getPosition(DirectionAxe.Y));
        Assertions.assertEquals(DirectionState.IDLE, device.getPosition(DirectionAxe.Z));
    }

    @Test
    void changeRotationTest() {
        final Device device = new Device();

        device.changeRotation(DirectionAxe.X, DirectionState.FORWARD);
        device.changeRotation(DirectionAxe.Y, DirectionState.BACKWARD);
        device.changeRotation(DirectionAxe.Z, DirectionState.IDLE);

        Assertions.assertEquals(DirectionState.FORWARD, device.getRotation(DirectionAxe.X));
        Assertions.assertEquals(DirectionState.BACKWARD, device.getRotation(DirectionAxe.Y));
        Assertions.assertEquals(DirectionState.IDLE, device.getRotation(DirectionAxe.Z));
    }

    @Test
    void blockDirectionTest() {
        final Device device = new Device();

        device.changePosition(DirectionAxe.X, DirectionState.BACKWARD);

        device.setBlockedPositionState(DirectionAxe.X, true);
        device.changePosition(DirectionAxe.X, DirectionState.FORWARD);
        device.changePosition(DirectionAxe.Y, DirectionState.FORWARD);
        device.changePosition(DirectionAxe.Z, DirectionState.BACKWARD);

        Assertions.assertEquals(DirectionState.IDLE, device.getPosition(DirectionAxe.X));
        Assertions.assertEquals(DirectionState.FORWARD, device.getPosition(DirectionAxe.Y));
        Assertions.assertEquals(DirectionState.BACKWARD, device.getPosition(DirectionAxe.Z));
    }

}
