package com.codecool.marsexploration.logic.database;

import com.codecool.marsexploration.data.LogHistory;

public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    public void save(String position, String outcome) {
        LogHistory logHistory = new LogHistory(position, outcome);
        historyRepository.save(logHistory);
    }

    public  void  clear(){
        historyRepository.clear();
    }


}
