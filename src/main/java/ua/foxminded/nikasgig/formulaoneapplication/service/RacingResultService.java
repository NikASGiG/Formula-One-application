package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingResultService {

    public ArrayList<Dashboard> calculate(ArrayList<Driver> drivers, ArrayList<LogInformation> startInformations,
            ArrayList<LogInformation> endInformations) {
        return IntStream.range(0, endInformations.size()).mapToObj(index -> {
            Driver driverFinder = sortDriverFinder(drivers, endInformations.get(index));
            return new Dashboard(driverFinder.getName(), driverFinder.getTeam(),
                    findStartTime(startInformations, endInformations.get(index)).getTime(),
                    endInformations.get(index).getTime());
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    private Driver sortDriverFinder(ArrayList<Driver> drivers, LogInformation driver) {
        return drivers.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode())).findFirst()
                .orElse(null);
    }

    private LogInformation findStartTime(ArrayList<LogInformation> startInformations, LogInformation driver) {
        return startInformations.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode()))
                .findFirst().orElse(null);
    }
}
