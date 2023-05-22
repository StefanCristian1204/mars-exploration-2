package com.codecool.marsexploration.logic.phase;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.Coordinate;
import com.codecool.marsexploration.data.Rover;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Log implements Phase{
    @Override
    public void perform(Context context) {
        String logEntry = formatLogEntry(context);
      //  System.out.println("Log entry: " + logEntry);

        Path logFilePath = Paths.get(context.getLogFilePath());
        try {
            if (!Files.exists(logFilePath)) {
                Files.createFile(logFilePath);
            }
            try (BufferedWriter writer = Files.newBufferedWriter(logFilePath, StandardOpenOption.APPEND)) {
                writer.write(logEntry);
                writer.newLine();
                writer.flush();
            }
            if(context.getStepNumber() == 0){
                clear(context.getLogFilePath());
            }
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }

    private String formatLogEntry(Context context) {
        int step = context.getStepNumber();

        Rover rover = context.getRover();
        String roverId = "rover-" + rover.getId();
        Coordinate position = rover.getPosition();
        String event;

        if (context.getOutcome() == null) {
            event = String.format("STEP %d; EVENT position; UNIT %s; POSITION [%d,%d]", step, roverId, position.x(), position.y());
            System.out.println(event);
        } else {
            event = String.format("STEP %d; EVENT outcome; OUTCOME %s", step - 1 , context.getOutcome().name());
            System.out.println(event);
        }
        return event;
    }

    public void clear(String logPath){
        Path path = Path.of(logPath);
        try{
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
