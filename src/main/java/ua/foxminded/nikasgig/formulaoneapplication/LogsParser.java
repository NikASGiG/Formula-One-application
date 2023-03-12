package ua.foxminded.nikasgig.formulaoneapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LogsParser {

    public ArrayList<LogInformation> parser(String source) {
        return Arrays.stream(source.split("\n")).map(line -> {
            String[] parts = line.split("_");
            String code = parts[0].substring(0, 3);
            String date = parts[0].substring(3);
            String time = parts[1].replace(" ", "_");
            return new LogInformation(code, date, time);
        }).collect(Collectors.toCollection(ArrayList::new));
    }
}
