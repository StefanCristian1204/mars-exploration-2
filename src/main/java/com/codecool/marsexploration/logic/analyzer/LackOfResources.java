package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;
import com.codecool.marsexploration.data.Rover;
import com.codecool.marsexploration.logic.routine.Returning;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class LackOfResources implements Analyzer {

    private final double resourceThreshold;

    public LackOfResources(double resourceThreshold) {
        this.resourceThreshold = resourceThreshold;
    }

    @Override
    public Optional<Outcome> analyze(Context context) {
        Rover rover = context.getRover();
        char[][] map = context.getMap();
        List<Coordinate> explored = context.getRover().getCoordinatePathRecord();
        Set<Coordinate> allResources = context.getRover().getFoundStuffRecord();

        // Calculate the fraction of explored cells that contain resources
        double resourceFraction = (double) allResources.size() / explored.size();

        if (explored.size() >= 100 && resourceFraction < resourceThreshold) {
            rover.setRoutine(new Returning());
            rover.getRoutine().move(context);
            return Optional.of(Outcome.NOT_COLONIZABLE_RESOURCES);
        }
        return Optional.empty();
    }
}
