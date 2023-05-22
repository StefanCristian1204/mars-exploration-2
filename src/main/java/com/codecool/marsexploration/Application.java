package com.codecool.marsexploration;

import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.SimulationInput;
import com.codecool.marsexploration.initialize.TableInitializer;
import com.codecool.marsexploration.initialize.TableStatements;
import com.codecool.marsexploration.logic.ExplorationSimulator;
import com.codecool.marsexploration.logic.database.Database;
import com.codecool.marsexploration.logic.database.HistoryRepository;
import com.codecool.marsexploration.logic.database.HistoryService;

import javax.swing.*;
import java.util.Map;

public class Application {
    public static void main(String[] args) throws Exception {

        Database database = new Database(
                "jdbc:postgresql://localhost:5432/mars_exploration",
                "postgres",
                "postgresql");

        Map<String, String> tables = Map.of(
                "logHistory", TableStatements.LOGHISTORY
        );
        TableInitializer tableInitializer = new TableInitializer(database, tables);
        tableInitializer.initialize();
        HistoryRepository historyRepository = new HistoryRepository(database);
        HistoryService historyService = new HistoryService(historyRepository);


        int timeout= Integer.parseInt(JOptionPane.showInputDialog("Enter the number of simulation steps!"));
        int landingX= Integer.parseInt(JOptionPane.showInputDialog("Enter the coordinateX for landing position"));
        int landingY= Integer.parseInt(JOptionPane.showInputDialog("Enter the coordinateY for landing position"));

            String mapPath = "src/main/resources/exploration-1.map"; // Replace with the path to your map file
            String logPath = "src/main/resources/test5.log"; // Replace with the path to your log file
            Coordinate landing = new Coordinate(landingX, landingY); // Replace with your desired landing coordinates
            SimulationInput input = new SimulationInput(mapPath, landing, timeout, logPath,historyService);
            ExplorationSimulator simulator = new ExplorationSimulator();
            simulator.simulate(input);
        }
    }

