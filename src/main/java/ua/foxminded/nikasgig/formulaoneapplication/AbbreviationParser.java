package ua.foxminded.nikasgig.formulaoneapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class AbbreviationParser {

    public ArrayList<Driver> parser(String source) {
        return Arrays.stream(source.split("\n"))
                .map(line -> line.split("_"))
                .map(parts -> new Driver(parts[0], parts[1].replace(" ", "_"), parts[2].replace(" ", "_")))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
