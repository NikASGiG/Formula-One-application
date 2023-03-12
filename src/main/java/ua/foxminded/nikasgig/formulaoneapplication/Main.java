package ua.foxminded.nikasgig.formulaoneapplication;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Formula One Application!");
        String abbreviationsPath = "abbreviations.txt";
        String endPath = "end.log";
        String startPath = "start.log";
        FileReader fileReader = new FileReader();
        AbbreviationParser abbreviationParser = new AbbreviationParser();
        ArrayList<Driver> drivers = abbreviationParser.parser(fileReader.read(abbreviationsPath));
        LogsParser logsParser = new LogsParser();
        ArrayList<LogInformation> startInformations = logsParser.parser(fileReader.read(startPath));
        ArrayList<LogInformation> endInformations = logsParser.parser(fileReader.read(endPath));
        Formatter formatter = new Formatter();
        RacingResult racingResult = new RacingResult();
        System.out.println(formatter.format(racingResult.calculate(drivers, startInformations, endInformations)));
    }
}
