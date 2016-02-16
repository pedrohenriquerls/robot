package com.nasa.robot.models;

public class PlanetArea {
    private Integer x, y;

    public PlanetArea(Integer x, Integer y){
        this.x = x;
        this.y = y;
        if(!isValid())
            throw new IllegalArgumentException("Invalid planet area.");
    }

    public Integer getY() {
        return y;
    }

    public Integer getX() {
        return x;
    }

    public PlanetArea(){
        this(5, 5);
    }

    private Boolean isValid(){
        return (x > 1 && y > 1);
    }
}
