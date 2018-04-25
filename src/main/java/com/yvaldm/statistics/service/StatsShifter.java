package com.yvaldm.statistics.service;

public class StatsShifter extends Thread {

    private StatisticsService statisticsService;

    public StatsShifter(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public void run() {
        while (true) {
            try {
                statisticsService.shiftStats();
                statisticsService.recalculateStats();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
