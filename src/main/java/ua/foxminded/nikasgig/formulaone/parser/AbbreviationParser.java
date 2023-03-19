package ua.foxminded.nikasgig.formulaone.parser;

import java.util.List;
import java.util.stream.Collectors;
import ua.foxminded.nikasgig.formulaone.model.Driver;

public class AbbreviationParser {

    private final int CODE_POSITION = 0;
    private final int NAME_POSITION = 1;
    private final int TEAM_POSITION = 2;

    public List<Driver> parser(List<String> lines) {
        return lines.stream().map(this::parseDriver).collect(Collectors.toList());
    }

    private Driver parseDriver(String line) {
        String[] parts = line.split("_");
        return new Driver(parts[CODE_POSITION], parts[NAME_POSITION], parts[TEAM_POSITION]);
    }
}
