package ua.foxminded.nikasgig.formulaone.app;

import java.io.IOException;
import java.util.List;
import ua.foxminded.nikasgig.formulaone.model.DashboardLine;
import ua.foxminded.nikasgig.formulaone.model.Driver;
import ua.foxminded.nikasgig.formulaone.model.LogInformation;
import ua.foxminded.nikasgig.formulaone.parser.AbbreviationParser;
import ua.foxminded.nikasgig.formulaone.parser.LogsParser;
import ua.foxminded.nikasgig.formulaone.service.*;

public class Application {

    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Formula One Application!");
        FileReaderService fileReader = new FileReaderService();
        LogsParser logsParser = new LogsParser();

        List<Driver> drivers = new AbbreviationParser().parser(fileReader.read("abbreviations.txt"));
        List<LogInformation> startLogs = logsParser.parser(fileReader.read("start.log"));
        List<LogInformation> endLogs = logsParser.parser(fileReader.read("end.log"));

        List<DashboardLine> report = new RacingResultService().calculate(drivers, startLogs, endLogs);
        System.out.println(new FormatterService().format(report));
    }
}
