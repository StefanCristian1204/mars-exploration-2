package com.codecool.marsexploration.logic;

import com.codecool.marsexploration.data.*;
import com.codecool.marsexploration.logic.analyzer.LackOfResources;
import com.codecool.marsexploration.logic.analyzer.Success;
import com.codecool.marsexploration.logic.analyzer.Timeout;
import com.codecool.marsexploration.logic.phase.*;
import com.codecool.marsexploration.logic.routine.Exploring;

import javax.swing.*;

public class InitSimulation {
    public Context  init(SimulationInput input) throws Exception {
        //init map
        Map mapInitial = new Map(input.mapPath());
        mapInitial.writeMap();

        int alienX = 12;
        int alienY = 12;

        int sight= Integer.parseInt(JOptionPane.showInputDialog("Enter the rover's sight range [0-5]!"));
        JOptionPane.showMessageDialog(null,"Please Wait! Generating map... ");
        mapInitial.updateMap(new Coordinate(alienX,alienY),Symbol.ALIEN);
        mapInitial.viewMap();
        Outcome outcome = null;
        //init rover
        Coordinate landing = input.landing();
        Rover rover = new Rover(1,landing,sight,new Exploring());


        int requiredMinerals= Integer.parseInt(JOptionPane.showInputDialog("Expedition should find how many minerals? [0-8]!"));
        int requiredWater= Integer.parseInt(JOptionPane.showInputDialog("Expedition should find how many water pockets? [0-8]!"));
        JOptionPane.showMessageDialog(null,"Click to start the simulation!");
        rover.addAnalyzers(new Timeout());
        rover.addAnalyzers(new Success(requiredMinerals,requiredWater));
        rover.addAnalyzers(new LackOfResources(0.1));

        rover.addPhase(new Scan());
        rover.addPhase(new Movement());
        rover.addPhase(new Analysis());
        rover.addPhase(new Log());
        rover.addPhase(new StepIncrement());

//        rover.addAnalyzers(new LackOfResources());
        if(mapInitial.getMapInitiated()[landing.x()][landing.y()] == Symbol.MOUNTAIN.getSymbol()
                || mapInitial.getMapInitiated()[landing.x()][landing.y()] == Symbol.PIT.getSymbol()
        ){
            outcome = Outcome.NOT_COLONIZABLE_RESOURCES;
            System.out.println("Your landing position is on a MOUNTAIN/PIT ->  " +  outcome);

        }
        //init context
        return new Context(0,mapInitial,landing, input.timeout(), rover, outcome,input.logPath());
    }
}
