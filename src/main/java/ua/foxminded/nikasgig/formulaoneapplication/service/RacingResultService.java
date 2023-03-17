package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResultService {

    public List<Dashboard> calculate(List<Driver> drivers, List<LogInformation> startInformations,
            List<LogInformation> endInformations) {
        return endInformations.stream().map(endInfo -> {
            Driver driver = findDriver(drivers, endInfo);
            LocalTime startTime = findStartTime(startInformations, endInfo);
            return new Dashboard(driver.getName(), driver.getTeam(), startTime, endInfo.getTime());
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    private Driver findDriver(List<Driver> drivers, LogInformation driver) {
        return drivers.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode())).findFirst()
                .orElse(null);
    }

    private LocalTime findStartTime(List<LogInformation> startInformations, LogInformation driver) {
        return startInformations.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode()))
                .findFirst().orElse(null).getTime();
    }
}
