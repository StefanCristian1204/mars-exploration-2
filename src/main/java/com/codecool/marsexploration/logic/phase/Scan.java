package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;
import com.codecool.marsexploration.logic.helpers.GenerateNeighbours;

import java.util.ArrayList;
import java.util.List;

public class Scan implements Phase{


    @Override
    public void perform(Context context) {
        GenerateNeighbours generateNeighbours = new GenerateNeighbours();
        Coordinate currentPosition = context.getRover().getPosition();
        char[][] map = context.getMap();
        int sight = context.getRover().getSight();
        List<Coordinate> foundStuffRecord = new ArrayList<>();
        List<Coordinate> neighbours;
        if(sight==1){
        neighbours =  generateNeighbours.getNeighbours(sight, currentPosition, context.getMap());
        context.setCurrentNeighbours(neighbours);
        addToFoundStuff(neighbours,map,context);
        }else {
            neighbours =  generateNeighbours.getNeighbours(1, currentPosition, context.getMap());
            context.setCurrentNeighbours(neighbours);
            for (int i = sight;i>= 1;i--){
                List<Coordinate> aux =  generateNeighbours.getNeighbours(i, currentPosition, context.getMap());
                foundStuffRecord.addAll(aux);
            }
            addToFoundStuff(foundStuffRecord,map,context);
        }
    }


    public void addToFoundStuff(List<Coordinate> list,char[][] map,Context context){
        for (Coordinate c : list){
            if(map[c.x()][c.y()] == Symbol.MINERAL.getSymbol()
                    || map[c.x()][c.y()] == Symbol.WATER.getSymbol()
                        || map[c.x()][c.y()] == Symbol.ALIEN.getSymbol()
            ){
                context.getRover().addFoundStuffRecord(c);
            }
        }
    }
}
