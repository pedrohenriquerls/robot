package com.nasa.robot.enums;

public enum Guidelines {
    LEFT('L', -90), RIGHT('R', 90), MOVE('M');

    public char command;
    public Integer degrees;

    Guidelines(char c, Integer d){
        this.command = c;
        this.degrees = d;
    }

    Guidelines(char c){
        this.command = c;
        this.degrees = null;
    }

    public static Guidelines getByCommand(char c){
        if('L' == c)
            return LEFT;
        else if('R' == c)
            return RIGHT;
        return MOVE;
    }
}
