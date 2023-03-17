package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AbbreviationParser {

    private final int CODE_POSITION = 0;
    private final int NAME_POSITION = 1;
    private final int TEAM_POSITION = 2;

    public List<Driver> parser(List<String> source) {
        return removeUnderLine(source
                .stream().map(line -> line.split("_")).map(parts -> new Driver(parts[CODE_POSITION],
                        parts[NAME_POSITION].replace(" ", "_"), parts[TEAM_POSITION].replace(" ", "_")))
                .collect(Collectors.toCollection(ArrayList::new)));

    }

    private List<Driver> removeUnderLine(List<Driver> source) {
        return source.stream().peek(dashboard -> dashboard.setName(dashboard.getName().replace('_', ' ')))
                .peek(dashboard -> dashboard.setTeam(dashboard.getTeam().replace('_', ' ')))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
