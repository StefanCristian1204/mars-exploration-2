package com.codecool.marsexploration.logic.analyzer;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.routine.Alien;
import com.codecool.marsexploration.logic.routine.Exploring;
import com.codecool.marsexploration.logic.routine.Returning;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Success implements Analyzer{

    private final int requiredMinerals;
    private final int requiredWater;

    public Success(int requiredMinerals, int requiredWater) {
        this.requiredMinerals = requiredMinerals;
        this.requiredWater = requiredWater;
    }

    @Override
    public Optional<Outcome> analyze(Context context) {
        Rover rover = context.getRover();
        char[][] map = context.getMap();
        int foundMinerals = 0;
        int foundWater = 0;
        boolean isAlien = false;
        List<Outcome> alienRandom = List.of(Outcome.FRIENDLY_ALIENS,Outcome.NOT_COLONIZABLE_ALIENS);
        Random random = new Random();
        Set<Coordinate> allResources = context.getRover().getFoundStuffRecord();
        for (Coordinate c : allResources) {
            if (map[c.x()][c.y()] == Symbol.MINERAL.getSymbol()) {
                foundMinerals++;

            } else if (map[c.x()][c.y()] == Symbol.WATER.getSymbol()) {
                foundWater++;

            } else if (map[c.x()][c.y()] == Symbol.ALIEN.getSymbol()) {
                isAlien = true;
                break;
            }
        }

        if (rover.getRoutine() instanceof Exploring) {
            if(isAlien){
                rover.setRoutine(new Alien());
                return Optional.of(alienRandom.get(random.nextInt(alienRandom.size())));
            }
            if (foundMinerals >= requiredMinerals && foundWater >= requiredWater) {
                rover.setRoutine(new Returning());
                rover.getRoutine().move(context);
                return Optional.of(Outcome.COLONIZABLE);
            }
        }
        return Optional.empty();
    }
}
