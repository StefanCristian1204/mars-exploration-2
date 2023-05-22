package com.codecool.marsexploration.data;

import java.util.List;

public class Context {
    private int stepNumber;
    private Map map;
    private Coordinate landingCoordinate;
    private long timeout;
    private Rover rover;
    private Outcome outcome;
    private String logFilePath;
    private List<Coordinate> currentNeighbours;

    public Context(int stepNumber, Map map, Coordinate landingCoordinate, long timeout, Rover rover, Outcome outcome, String logFilePath) {
        this.stepNumber = stepNumber;
        this.map = map;
        this.landingCoordinate = landingCoordinate;
        this.timeout = timeout;
        this.rover = rover;
        this.outcome = outcome;
        this.logFilePath = logFilePath;

    }

    public List<Coordinate> getCurrentNeighbours() {
        return currentNeighbours;
    }

    public void setCurrentNeighbours(List<Coordinate> currentNeighbours) {
        this.currentNeighbours = currentNeighbours;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public char[][] getMap() {
        return map.getMapInitiated();
    }

    public Map getMapUpdate(){
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Coordinate getLandingCoordinate() {
        return landingCoordinate;
    }

    public void setLandingCoordinate(Coordinate landingCoordinate) {
        this.landingCoordinate = landingCoordinate;
    }

    public long getTimeout() {
        return timeout;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    public Rover getRover() {
        return rover;
    }

    public void setRover(Rover rover) {
        this.rover = rover;
    }

    public Outcome getOutcome() {
        return outcome;
    }

    public void setOutcome(Outcome outcome) {
        this.outcome = outcome;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }
}
