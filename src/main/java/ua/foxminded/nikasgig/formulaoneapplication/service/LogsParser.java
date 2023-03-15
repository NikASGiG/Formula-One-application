package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogsParser {

    private final int CODE_LENGTH = 3;
    
    public ArrayList<LogInformation> parser(List<String> source) {
        return source.stream().map(line -> {
            String[] parts = line.split("_");
            String code = parts[0].substring(0, CODE_LENGTH);
            String date = parts[0].substring(CODE_LENGTH);
            LocalTime time = LocalTime.parse(parts[1].replace(" ", "_"));
            return new LogInformation(code, date, time);
        }).collect(Collectors.toCollection(ArrayList::new));
    }
}
