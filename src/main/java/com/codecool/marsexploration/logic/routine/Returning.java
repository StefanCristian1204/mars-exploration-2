package com.codecool.marsexploration.logic.routine;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;

import java.util.List;

public class Returning implements Routine{


    @Override
    public void move(Context context) {
        List<Coordinate> returnList = context.getRover().getCoordinatePathRecord();
        int roverId = context.getRover().getId();
        int step = 0;
        for(int i=returnList.size()-3; i>=0;i--){
        System.out.printf("RETURNING STEP %d; EVENT RETURNING; UNIT ROVER-%s; POSITION [%d,%d]%n", step++, roverId, returnList.get(i).x(), returnList.get(i).y());
        }
    }
}
