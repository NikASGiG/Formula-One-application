package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AbbreviationParser {

    public ArrayList<Driver> parser(List<String> source) {
        return source.stream()
                .map(line -> line.split("_"))
                .map(parts -> new Driver(parts[0], parts[1].replace(" ", "_"), parts[2].replace(" ", "_")))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
