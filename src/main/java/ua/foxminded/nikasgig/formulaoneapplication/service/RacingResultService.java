package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacingResultService {

    public List<DashboardLine> calculate(List<Driver> drivers, List<LogInformation> startInformations,
            List<LogInformation> endInformations) {
        Map<String, LocalTime> startTimes = startInformations.stream()
                .collect(Collectors.toMap(LogInformation::getCode, LogInformation::getTime));
        return endInformations.stream().map(endInfo -> {
            Driver driver = findDriver(drivers, endInfo);
            LocalTime startTime = startTimes.get(endInfo.getCode());
            return new DashboardLine(driver, startTime, endInfo.getTime());
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    private Driver findDriver(List<Driver> drivers, LogInformation driver) {
        return drivers.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode())).findFirst()
                .orElse(null);
    }
}
