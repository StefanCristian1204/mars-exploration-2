package com.codecool.marsexploration.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Map {
    private char[][] map;
    private final String mapPath;

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String RESET = "\033[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public Map(String mapPath) {
        this.mapPath = mapPath;
    }

    public void readFile(String mapPath) throws Exception {
            Scanner sc = new Scanner(new BufferedReader(new FileReader(mapPath)));
            int rows = sc.nextLine().length();
            sc.close();
            sc = new Scanner(new BufferedReader(new FileReader(mapPath)));
            map = new char[rows][rows];
            while(sc.hasNextLine()) {
                for (int i=0; i<map.length; i++) {
                    String[] line = sc.nextLine().split(",");
                    for (String s : line) {
                        String[] c = s.split("");
                        for (int a = 0; a < c.length; a++) {
                            map[i][a] = c[a].charAt(0);
                        }
                    }
                }
            }
        }


    public void writeMap() throws Exception {
            readFile(mapPath);
    }

    public char[][] getMapInitiated(){
            return map;
    }

    public void updateMap(Coordinate coordinate,Symbol symbol){
            map[coordinate.x()][coordinate.y()] = symbol.getSymbol();
    }

    public void viewMap() {
        for(int i =0;i<map[0].length;i++){
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] == Symbol.WATER.getSymbol()){
                    System.out.print(ANSI_CYAN + map[i][j] + "  ");
                    System.out.print(RESET);
                } else if (map[i][j] == Symbol.MINERAL.getSymbol()) {
                    System.out.print(ANSI_YELLOW + map[i][j] + "  ");
                    System.out.print(RESET);
                } else if (map[i][j] == Symbol.ROAD.getSymbol()) {
                    System.out.print(ANSI_GREEN + map[i][j] + "  ");
                    System.out.print(RESET);
                } else {
                    System.out.print(map[i][j] + "  ");
                }
            }
            System.out.println(" ");
        }
    }
}
