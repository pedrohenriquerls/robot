package com.nasa.robot.enums;

import java.util.ArrayList;
import java.util.List;

public enum Direction {
    EAST('W', -1, 0, new ArrayList<Integer>(){{ add(-90); add(270); }}),
    WEST('E', 1, 0, new ArrayList<Integer>(){{ add(90); add(-270); }}),
    NORTH('N', 0, 1, new ArrayList<Integer>(){{ add(0); add(360); }}),
    SOUTH('S', 0, -1, new ArrayList<Integer>(){{ add(180); }});

    public char name;
    public Integer moveOnX;
    public Integer moveOnY;
    public List<Integer> degrees;

    Direction(char f, List<Integer> d){
        this.name = f;
        this.degrees = d;
    }

    Direction(char f, Integer mX, Integer mY, List<Integer> d){
        this(f, d);
        this.moveOnX = mX;
        this.moveOnY = mY;
    }

    public static Direction facedTo(Integer degree){
        if(NORTH.degrees.contains(Math.abs(degree)))
            return NORTH;

        if(SOUTH.degrees.contains(Math.abs(degree)))
            return SOUTH;

        if(EAST.degrees.contains(degree))
            return EAST;
        else
            return WEST;
    }
}
