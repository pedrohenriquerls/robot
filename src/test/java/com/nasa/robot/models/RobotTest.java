package com.nasa.robot.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RobotTest {
    private static Robot robot;

    @Before
    public void setUp() {
        robot = new Robot(new PlanetArea());
    }

    @Test
    public void isValidCommad(){
        assertTrue(robot.isValidCommands("RMML"));
        assertTrue(robot.isValidCommands("rmml"));
    }

    @Test
    public void isInvalidCommad(){
        assertFalse(robot.isValidCommands("wrmml"));
        assertFalse(robot.isValidCommands("WRMML"));
    }

    @Test
    public void twoMovesToSouth(){
        assertEquals(robot.getCoordinates(), "(0,0,N)");
        robot.execute("MMRMMRMM");
        assertEquals(robot.getCoordinates(), "(2,0,S)");
    }

    @Test
    public void twoMovesToWest(){
        assertEquals(robot.getCoordinates(), "(0,0,N)");
        robot.execute("MML");
        assertEquals(robot.getCoordinates(), "(0,2,W)");
    }

    @Test
    public void rotate360AndTwoMovesToWest(){
        assertEquals(robot.getCoordinates(), "(0,0,N)");
        robot.execute("RRRRRMM");
        assertEquals(robot.getCoordinates(), "(2,0,E)");
    }
}
