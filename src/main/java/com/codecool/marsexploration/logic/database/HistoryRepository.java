package com.codecool.marsexploration.logic.database;

import com.codecool.marsexploration.data.LogHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HistoryRepository {
        private final Database database;

        public HistoryRepository(Database database) {
            this.database = database;
        }

        public void save(LogHistory identification) {
            // Write the insert statements here!
            String template = "INSERT INTO loghistory (position,outcome) VALUES (?,?)";
            try (Connection connection = database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(template)) {
                prepare(identification, statement);
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        public  void  clear(){
            String template = "TRUNCATE TABLE loghistory";
            try (Connection connection = database.getConnection();
                 PreparedStatement statement = connection.prepareStatement(template)) {
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        private void prepare(LogHistory identification, PreparedStatement statement) throws SQLException {
            statement.setString(1, identification.position());
            statement.setString(2, identification.outcome());
        }
}
