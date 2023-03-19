package ua.foxminded.nikasgig.formulaone.model;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(endTime, name, startTime, team, time);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DashboardLine other = (DashboardLine) obj;
        return Objects.equals(endTime, other.endTime) && Objects.equals(name, other.name)
                && Objects.equals(startTime, other.startTime) && Objects.equals(team, other.team)
                && Objects.equals(time, other.time);
    }
}
