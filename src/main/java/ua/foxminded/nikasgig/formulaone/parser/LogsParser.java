package ua.foxminded.nikasgig.formulaone.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import ua.foxminded.nikasgig.formulaone.model.LogInformation;

public class LogsParser {

    public List<LogInformation> parser(List<String> source) {
        return source.stream().map(LogInformation::create).collect(Collectors.toCollection(ArrayList::new));
    }
}
