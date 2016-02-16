package com.nasa.robot.models;

import com.nasa.robot.enums.Direction;
import com.nasa.robot.enums.Guidelines;

public class Position {
    private Direction faceTo;
    private Integer x, y;

    Position(){
        x = 0;
        y = 0;
        faceTo = Direction.NORTH;
    }

    public void update(String c){
        char[] commands = c.toUpperCase().toCharArray();
        Integer degrees = 0;
        for(char command: commands) {
            Guidelines guide = Guidelines.getByCommand(command);
            if(guide.degrees != null){
                degrees += guide.degrees;
                setFaceTo(degrees);
            }else
                setCoordinate();

            if(Math.abs(degrees) == 360)
                degrees = 0;
        }
    }

    private void setFaceTo(Integer degrees){
        faceTo = Direction.facedTo(degrees);
    }

    private void setCoordinate(){
        x += faceTo.moveOnX;
        y += faceTo.moveOnY;
    }

    public Boolean isValid(PlanetArea planetArea){
        return (planetArea.getX() > this.x && planetArea.getY() > this.y
                && this.x >= 0 && this.y >= 0);
    }

    @Override
    public String toString(){
        return "("+x+","+y+","+faceTo.name+")";
    }
}
