package com.codecool.marsexploration.data;

import com.codecool.marsexploration.logic.database.HistoryService;

public record SimulationInput(String mapPath, Coordinate landing, long timeout, String logPath, HistoryService historyService) {
}
