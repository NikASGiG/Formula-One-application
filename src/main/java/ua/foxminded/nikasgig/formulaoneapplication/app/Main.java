package ua.foxminded.nikasgig.formulaoneapplication.app;

import java.io.IOException;
import ua.foxminded.nikasgig.formulaoneapplication.service.*;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Formula One Application!");
        FileReader fileReader = new FileReader();
        AbbreviationParser abbreviationParser = new AbbreviationParser();
        LogsParser logsParser = new LogsParser();
        Formatter formatter = new Formatter();
        RacingResultService racingResult = new RacingResultService();
        System.out.println(formatter.format(racingResult.calculate(
                abbreviationParser.parser(fileReader.read("abbreviations.txt")),
                logsParser.parser(fileReader.read("start.log")), logsParser.parser(fileReader.read("end.log")))));
    }
}
