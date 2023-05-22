package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

import java.util.List;
import java.util.Random;

public class Exploring implements Routine{
    @Override
    public void move(Context context) {
        int count = 0;
       List<Coordinate> neighbours = context.getCurrentNeighbours();
        Random random = new Random();
        Coordinate newRoverPos = neighbours.get(random.nextInt(neighbours.size()));
            if (context.getStepNumber() == 0) {
                context.getRover().addCoordinatePathRecord(context.getLandingCoordinate());
                context.getMapUpdate().updateMap(context.getLandingCoordinate(), Symbol.START);
            } else {
                while (context.getRover().getCoordinatePathRecord().contains(newRoverPos)){
                    count++;
                    newRoverPos = neighbours.get(random.nextInt(neighbours.size()));
                    if(count == 10){
                        break;
                    }
                }
                context.getRover().setPosition(newRoverPos);
                context.getRover().addCoordinatePathRecord(newRoverPos);
                if(context.getMap()[newRoverPos.x()][newRoverPos.y()] == Symbol.EMPTY.getSymbol()){
                context.getMapUpdate().updateMap(newRoverPos, Symbol.ROAD);
                }
                }
            }
        }

