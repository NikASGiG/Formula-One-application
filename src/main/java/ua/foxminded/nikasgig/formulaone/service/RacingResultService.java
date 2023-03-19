package ua.foxminded.nikasgig.formulaone.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import ua.foxminded.nikasgig.formulaone.model.DashboardLine;
import ua.foxminded.nikasgig.formulaone.model.Driver;
import ua.foxminded.nikasgig.formulaone.model.LogInformation;

public class RacingResultService {

    public List<DashboardLine> calculate(List<Driver> drivers, List<LogInformation> startLogs,
            List<LogInformation> endInformations) {
        Map<String, Driver> driverMap = drivers.stream()
                .collect(Collectors.toMap(Driver::getCode, Function.identity()));
        Map<String, LocalTime> startTimes = startLogs.stream()
                .collect(Collectors.toMap(LogInformation::getCode, LogInformation::getTime));
        return endInformations.stream().map(endInfo -> {
            return new DashboardLine(driverMap.get(endInfo.getCode()), startTimes.get(endInfo.getCode()),
                    endInfo.getTime());
        }).collect(Collectors.toList());
    }
}
