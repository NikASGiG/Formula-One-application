package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.Duration;
import java.time.LocalTime;

public class DashboardLine implements Comparable<DashboardLine>{

    private String name;
    private String team;
    private LocalTime startTime;
    private LocalTime endTime;
    private Duration time;

    public DashboardLine(Driver driver, LocalTime startTime, LocalTime endTime) {
        this.name = driver.getName();
        this.team = driver.getTeam();
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Duration getTime() {
        return time;
    }

    public void setTime(Duration time) {
        this.time = time;
    }

    @Override
    public int compareTo(DashboardLine other) {
        return this.getTime().compareTo(other.getTime());
    }
}
