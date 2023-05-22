package com.codecool.marsexploration.logic.helpers;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateNeighbours {

    char[][] copyMap;

    public  List<Coordinate> getAllNeighbours(int sight, Coordinate coordinate){
        Random random = new Random();
        List<Coordinate> neighboursAll = new ArrayList<>();
        int[][] directionsAll = {{-sight, 0}, {sight, 0}, {0, -sight}, {0, sight}, {-sight, -sight}, {-sight, sight}, {sight, -sight}, {sight, sight}};

        for (int[] direction : directionsAll) {
            int x = coordinate.x() + direction[0];
            int y = coordinate.y() + direction[1];
            neighboursAll.add(new Coordinate(x, y));
        }
        return neighboursAll;
    }

    public List<Coordinate> getValidNeighbours(char[][] map,List<Coordinate> neighboursAll){
        return neighboursAll.stream()
                .filter(el->el.x() >= 0 && el.y() >= 0 && el.x()<map.length && el.y()< map.length)
                .filter(x->map[x.x()][x.y()] != Symbol.MOUNTAIN.getSymbol())
                .filter(x->map[x.x()][x.y()] != Symbol.PIT.getSymbol())
                .toList();
    }

    public List<Coordinate> getNeighbours(int sight, Coordinate coordinate,char[][] map){
        return getValidNeighbours(map,getAllNeighbours(sight,coordinate));
    }
}
