package ua.foxminded.nikasgig.formulaone.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import ua.foxminded.nikasgig.formulaone.model.DashboardLine;

public class FormatterService {

    private final int INDEX_FOR_DASHBOARD_SEPARATOR = 15;
    private final int TAB_FORMAT_ROW = 1;
    private int currentIndex = 1;

    public String format(List<DashboardLine> dashboardLines) {
        dashboardLines.forEach(
                dashboard -> dashboard.setTime(calculateTime(dashboard.getStartTime(), dashboard.getEndTime())));
        Collections.sort(dashboardLines, Comparator.comparing(DashboardLine::getTime));
        final int maxNameLength = findMaxNameLength(dashboardLines);
        final int maxTeamLength = findMaxTeamLength(dashboardLines);
        final int maxTimeLength = formatTime(dashboardLines.get(0).getTime()).length();
        List<String> result = dashboardLines.stream()
                .map(row -> formatRow(row, maxNameLength, maxTeamLength, maxTimeLength)).collect(Collectors.toList());

        result.add(INDEX_FOR_DASHBOARD_SEPARATOR, addDashboardLine(result.get(INDEX_FOR_DASHBOARD_SEPARATOR).length()));
        return String.join(System.lineSeparator(), result);
    }

    private Duration calculateTime(LocalTime startTime, LocalTime endTime) {
        return Duration.between(startTime, endTime);
    }

    private int findMaxNameLength(List<DashboardLine> dashboardLines) {
        return dashboardLines.stream().mapToInt(dashboard -> dashboard.getName().length()).max().orElse(0);
    }

    private int findMaxTeamLength(List<DashboardLine> dashboardLines) {
        return dashboardLines.stream().mapToInt(dashboard -> dashboard.getTeam().length()).max().orElse(0);
    }

    private String formatTime(Duration duration) {
        return String.format("%02d:%02d:%02d.%03d", duration.toHours(), duration.toMinutes(), duration.getSeconds(),
                duration.toMillis());
    }

    private String formatRow(DashboardLine dashboardLine, int maxNameLength, int maxTeamLength, int maxTimeLength) {
        String index;
        if (currentIndex < 10) {
            index = String.format("%d.%-" + (TAB_FORMAT_ROW + 1) + "s", currentIndex, "");
        } else {
            index = String.format("%d.%-" + TAB_FORMAT_ROW + "s", currentIndex, "");
        }
        String name = String.format("%-" + maxNameLength + "s|", dashboardLine.getName());
        String team = String.format("%-" + maxTeamLength + "s|", dashboardLine.getTeam());
        String time = String.format("%-" + maxTimeLength + "s", formatTime(dashboardLine.getTime()));
        currentIndex++;
        return String.format("%s%s%s%s", index, name, team, time);
    }

    private String addDashboardLine(int length) {
        return Stream.generate(() -> "-").limit(length).collect(Collectors.joining());
    }
}
