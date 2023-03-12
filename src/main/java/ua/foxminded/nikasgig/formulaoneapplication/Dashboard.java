package ua.foxminded.nikasgig.formulaoneapplication;

public class Dashboard implements Comparable<Dashboard>{

    private String name;
    private String team;
    private String time;
    
    public Dashboard(String name, String team, String time) {
        this.name = name;
        this.team = team;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getTime() {
        return time;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int compareTo(Dashboard other) {
        return this.getTime().compareTo(other.getTime());
    }
}
