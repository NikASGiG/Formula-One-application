package ua.foxminded.nikasgig.formulaoneapplication.service;

public class Driver {

    private String code;
    private String name;
    private String team;

    public Driver(String code, String name, String team) {
        this.code = code;
        this.name = name;
        this.team = team;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    
    public String getTeam() {
        return team;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
