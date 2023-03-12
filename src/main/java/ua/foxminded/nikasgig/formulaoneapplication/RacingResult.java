package ua.foxminded.nikasgig.formulaoneapplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.time.Duration;
import java.time.LocalTime;

public class RacingResult {

    public ArrayList<Dashboard> calculate(ArrayList<Driver> drivers, ArrayList<LogInformation> startInformations,
            ArrayList<LogInformation> endInformations) {
        return endInformations.stream().map(driver -> {
            Driver driverFinder = calculateDriverFinder(drivers, driver);
            return new Dashboard(driverFinder.getName(), driverFinder.getTeam(),
                    culculateTime(findStartTime(startInformations, driver), driver));
        }).sorted().collect(Collectors.toCollection(ArrayList::new));
    }

    private Driver calculateDriverFinder(ArrayList<Driver> drivers, LogInformation driver) {
        return drivers.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode())).findFirst()
                .orElse(null);
    }

    private LogInformation findStartTime(ArrayList<LogInformation> startInformations, LogInformation driver) {
        return startInformations.stream().filter(driverFind -> driver.getCode().equals(driverFind.getCode()))
                .findFirst().orElse(null);
    }

    private String culculateTime(LogInformation startInformations, LogInformation endInformations) {
        LocalTime time1 = LocalTime.parse(endInformations.getTime());
        LocalTime time2 = LocalTime.parse(startInformations.getTime());
        Duration duration = Duration.between(time2, time1);
        return String.format("%02d:%02d:%02d.%03d", duration.toHours(), duration.toMinutes(), duration.getSeconds(),
                duration.toMillis());
    }
}
