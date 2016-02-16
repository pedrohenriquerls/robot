package com.nasa.robot.models;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    private PlanetArea planetArea;
    private Position position;

    @Before
    public void setUp() {
        planetArea = new PlanetArea();
        position = new Position();
    }

    @Test
    public void twoMovesToSouth(){
        assertEquals(position.toString(), "(0,0,N)");
        position.update("MMRMMRMM");
        assertEquals(position.toString(), "(2,0,S)");
        assertTrue(position.isValid(planetArea));
    }

    @Test
    public void twoMovesToWest(){
        assertEquals(position.toString(), "(0,0,N)");
        position.update("MML");
        assertEquals(position.toString(), "(0,2,W)");
        assertTrue(position.isValid(planetArea));
    }

    @Test
    public void invalidMovement(){
        assertEquals(position.toString(), "(0,0,N)");
        position.update("MMMMM");
        assertEquals(position.toString(), "(0,5,N)");
        assertFalse(position.isValid(planetArea));
    }

    @Test
    public void rotate360AndTwoMovesToWest(){
        assertEquals(position.toString(), "(0,0,N)");
        position.update("RRRRRMM");
        assertEquals(position.toString(), "(2,0,E)");
        assertTrue(position.isValid(planetArea));
    }

    @Test
    public void invalidMovementToEast(){
        assertEquals(position.toString(), "(0,0,N)");
        position.update("LMMMM");
        assertEquals(position.toString(), "(-4,0,W)");
        assertFalse(position.isValid(planetArea));
    }
}
