package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.logic.phase.Phase;

import java.util.List;

public class ExplorationSimulator {

    InitSimulation initSimulation = new InitSimulation();

    public void simulate(SimulationInput input) throws Exception {
        input.historyService().clear();
        Context context =  initSimulation.init(input);
        while (context.getOutcome() == null) {
            for (Phase phase : context.getRover().getPhases()) {
                phase.perform(context);
            }
        }
        if(context.getRover().getRoutine().getClass().getSimpleName().equals("Alien")){
           context.getRover().getRoutine().move(context);
        }
        List<Coordinate> posDatabase = context.getRover().getCoordinatePathRecord();

        for(Coordinate c : posDatabase){
            String res = "Pos X: " + c.x() + " Pos Y: " + c.y();
            String outcome = context.getOutcome().toString();
            input.historyService().save(res,outcome);
        }
        System.out.println("Simulation completed. Check the log file for details.");
        context.getMapUpdate().viewMap();
    }
}






