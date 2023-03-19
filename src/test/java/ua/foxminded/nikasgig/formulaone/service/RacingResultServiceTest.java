package ua.foxminded.nikasgig.formulaone.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ua.foxminded.nikasgig.formulaone.model.DashboardLine;
import ua.foxminded.nikasgig.formulaone.model.Driver;
import ua.foxminded.nikasgig.formulaone.model.LogInformation;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

class RacingResultServiceTest {

    @Test
    void calculate_whenGivenListDriversListStartLogsListEndInformations_ReturnSuccessListDashboardLine() {
        Driver driver1 = new Driver("DRR", "Daniel Ricciardo", "Renault");
        Driver driver2 = new Driver("LSW", "Lance Stroll", "Racing Point");
        Driver driver3 = new Driver("CSC", "Carlos Sainz", "McLaren");
        List<Driver> drivers = Arrays.asList(driver1, driver2, driver3);
        List<LogInformation> startLogs = Arrays.asList(
                new LogInformation("DRR", "2019-05-24", LocalTime.parse("12:14:12.054")),
                new LogInformation("LSW", "2019-05-24", LocalTime.parse("12:14:12.054")),
                new LogInformation("CSC", "2019-05-24", LocalTime.parse("12:14:12.054")));
        List<LogInformation> endLogs = Arrays.asList(
                new LogInformation("DRR", "2019-05-24", LocalTime.parse("12:15:24.067")),
                new LogInformation("LSW", "2019-05-24", LocalTime.parse("12:16:11.648")),
                new LogInformation("CSC", "2019-05-24", LocalTime.parse("12:17:06.598")));
        List<DashboardLine> expected = Arrays.asList(
                new DashboardLine(driver1, LocalTime.parse("12:14:12.054"), LocalTime.parse("12:15:24.067")),
                new DashboardLine(driver2, LocalTime.parse("12:14:12.054"), LocalTime.parse("12:16:11.648")),
                new DashboardLine(driver3, LocalTime.parse("12:14:12.054"), LocalTime.parse("12:17:06.598")));
        
        RacingResultService racingResultService = new RacingResultService();
        List<DashboardLine> actual = racingResultService.calculate(drivers, startLogs, endLogs);
        assertEquals(expected, actual);
    }

}
