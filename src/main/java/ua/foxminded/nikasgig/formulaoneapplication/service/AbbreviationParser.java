package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.util.List;
import java.util.stream.Collectors;

public class AbbreviationParser {

    private final int CODE_POSITION = 0;
    private final int NAME_POSITION = 1;
    private final int TEAM_POSITION = 2;

    public List<Driver> parser(List<String> lines) {
        return lines.stream().map(this::parseDriver).collect(Collectors.toList());
    }

    private Driver parseDriver(String line) {
        String[] parts = line.split("_");
        String code = parts[CODE_POSITION];
        String name = parts[NAME_POSITION];
        String team = parts[TEAM_POSITION];
        return new Driver(code, name, team);
    }
}
