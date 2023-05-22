package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Outcome;

import java.util.List;

public class Alien implements Routine{
    @Override
    public void move(Context context) {
        List<Coordinate> returnList = context.getRover().getCoordinatePathRecord();
        int roverId = context.getRover().getId();
        int step = 0;
        if(context.getOutcome() == Outcome.FRIENDLY_ALIENS){
            System.out.println("< FRIENDLY ALIENS > --- communication with alien in progress... ");
        }
        for(int i=returnList.size()-3; i>=0;i--){
             if (context.getOutcome() == Outcome.NOT_COLONIZABLE_ALIENS){
            System.out.printf("< DANGEROUS ALIENS > RETURNING STEP %d; EVENT RETURNING; UNIT ROVER-%s; POSITION [%d,%d]%n", step++, roverId, returnList.get(i).x(), returnList.get(i).y());
            }
        }
    }
}
