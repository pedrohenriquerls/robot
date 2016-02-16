package com.nasa.robot.models;

public class Robot {
    private PlanetArea planetArea;
    private Position position;

    public Robot(PlanetArea planetArea){
        this.planetArea = planetArea;
        this.position = new Position();
    }

    public void execute(String commands){
        position.update(commands);
        if(!position.isValid(planetArea))
            throw new RuntimeException("Invalid position");
    }

    public Boolean isValidCommands(String commands){
        return commands.matches("(?i)^[LRM]*");
    }

    public String getCoordinates(){
        return position.toString();
    }

}
