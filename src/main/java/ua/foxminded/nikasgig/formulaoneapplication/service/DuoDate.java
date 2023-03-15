package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;

public class DuoDate {

    private LocalTime startTime;
    private LocalTime endTime;
    
    public DuoDate(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public LocalTime getStartTime() {
        return startTime;
    }
    public LocalTime getEndTime() {
        return endTime;
    }
}
