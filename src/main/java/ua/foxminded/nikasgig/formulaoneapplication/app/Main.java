package ua.foxminded.nikasgig.formulaoneapplication.app;

import java.io.IOException;
import java.util.List;
import ua.foxminded.nikasgig.formulaoneapplication.service.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Formula One Application!");
        FileReader fileReader = new FileReader();
        AbbreviationParser abbreviationParser = new AbbreviationParser();
        LogsParser logsParser = new LogsParser();
        Formatter formatter = new Formatter();
        RacingResultService racingResult = new RacingResultService();
        List<Driver> drivers = abbreviationParser.parser(fileReader.read("abbreviations.txt"));
        List<LogInformation> startInformations = logsParser.parser(fileReader.read("start.log"));
        List<LogInformation> endInformations = logsParser.parser(fileReader.read("end.log"));
        System.out.println(formatter.format(racingResult.calculate(drivers, startInformations, endInformations)));
    }
}
