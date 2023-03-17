package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogsParser {

    public List<LogInformation> parser(List<String> source) {
        return source.stream()
                .map(LogInformation::create)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
