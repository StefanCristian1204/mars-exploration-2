package com.codecool.marsexploration.initialize;

public interface TableStatements {
    String LOGHISTORY = "CREATE TABLE IF NOT EXISTS logHistory (" +
            "id SERIAL PRIMARY KEY," +
            "position VARCHAR(50) NOT NULL," +
            "outcome VARCHAR(100) NOT NULL" +
            ");";
}
