package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.analyzer.Analyzer;
import com.codecool.marsexploration.logic.phase.Phase;
import com.codecool.marsexploration.logic.routine.Routine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Rover {
    private int id;
    private Coordinate position;
    private int sight;
    private Routine routine;
    private List<Phase> phases = new ArrayList<>();
    private List<Analyzer> analyzers = new ArrayList<>();
    private List<Coordinate> coordinatePathRecord = new ArrayList<>();
    private Set<Coordinate> foundStuffRecord = new HashSet<>();

    public Rover(int id, Coordinate position, int sight, Routine routine) {
        this.id = id;
        this.position = position;
        this.sight = sight;
        this.routine = routine;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public int getSight() {
        return sight;
    }

    public void setSight(int sight) {
        this.sight = sight;
    }

    public Routine getRoutine() {
        return routine;
    }

    public void setRoutine(Routine routine) {
        this.routine = routine;
    }

    public List<Coordinate> getCoordinatePathRecord() {
        return coordinatePathRecord;
    }

    public void addCoordinatePathRecord(Coordinate coordinatePathRecord) {
        this.coordinatePathRecord.add(coordinatePathRecord);
    }

    public Set<Coordinate> getFoundStuffRecord() {
        return foundStuffRecord;
    }

    public void addFoundStuffRecord(Coordinate foundStuff) {
        this.foundStuffRecord.add(foundStuff);
    }

    public List<Analyzer> getAnalyzers(){
        return analyzers;
    }

    public void addAnalyzers(Analyzer analyzer){
      this.analyzers.add(analyzer);
    }
    public List<Phase> getPhases(){
        return phases;
    }

    public void addPhase(Phase phase){
        this.phases.add(phase);
    }

    @Override
    public String toString() {
        return "Rover{" +
                "id=" + id +
                ", position=" + position +
                ", sight=" + sight +
                ", routine=" + routine +
                ", phases=" + phases +
                ", analyzers=" + analyzers +
                ", coordinatePathRecord=" + coordinatePathRecord +
                ", foundStuffRecord=" + foundStuffRecord +
                '}';
    }
}
