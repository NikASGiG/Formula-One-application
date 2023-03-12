package ua.foxminded.nikasgig.formulaoneapplication;

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
}
