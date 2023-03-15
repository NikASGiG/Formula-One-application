package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;

public class Dashboard implements Comparable<Dashboard>{

    private String name;
    private String team;
    private DuoDate duoTime;
    private String time;
    
    public Dashboard(String name, String team, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.team = team;
        this.duoTime = new DuoDate(startTime, endTime);
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public DuoDate getDuoTime() {
        return duoTime;
    }

    public void setDuoTime(DuoDate duoTime) {
        this.duoTime = duoTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Dashboard other) {
        return this.getTime().compareTo(other.getTime());
    }
}
