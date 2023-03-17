package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Formatter {

    private final int INDEX_FOR_DASHBOARD_SEPARATOR = 15;
    private final int TAB_FORMATROW = 3;
    private int currentIndex = 1;

    public String format(List<Dashboard> list) {
        list.forEach(dashboard -> dashboard.setTime(calculateTime(dashboard.getStartTime(), dashboard.getEndTime())));
        List<Dashboard> listWithSortedData = sort(list);
        final int MAXNAMELENGTH = findMaxNameLength(listWithSortedData);
        final int MAXTEAMLENGTH = findMaxTeamLength(listWithSortedData);
        final int MAXTIMELENGTH = formatTime(listWithSortedData.get(0).getTime()).length();
        List<String> result = listWithSortedData.stream()
                .map(row -> formatRow(row, MAXNAMELENGTH, MAXTEAMLENGTH, MAXTIMELENGTH)).collect(Collectors.toList());

        result.add(INDEX_FOR_DASHBOARD_SEPARATOR, addDashboardLine(result.get(INDEX_FOR_DASHBOARD_SEPARATOR).length()));
        return String.join("\n", result);
    }

    private Duration calculateTime(LocalTime startTime, LocalTime endTime) {
        return Duration.between(startTime, endTime);
    }

    private List<Dashboard> sort(List<Dashboard> list) {
        Collections.sort(list, Comparator.comparing(Dashboard::getTime));
        return list;
    }

    private int findMaxNameLength(List<Dashboard> source) {
        return source.stream().mapToInt(dashboard -> dashboard.getName().length()).max().orElse(0);
    }

    private int findMaxTeamLength(List<Dashboard> source) {
        return source.stream().mapToInt(dashboard -> dashboard.getTeam().length()).max().orElse(0);
    }

    private String formatTime(Duration duration) {
        return String.format("%02d:%02d:%02d.%03d", duration.toHours(), duration.toMinutes(), duration.getSeconds(),
                duration.toMillis());
    }

    private String formatRow(Dashboard source, int MAXNAMELENGTH, int MAXTEAMLENGTH, int MAXTIMELENGTH) {
        StringBuilder result = new StringBuilder();
        result.append(currentIndex).append(".").append(
                tab(Integer.toString(currentIndex).length(), TAB_FORMATROW));
        result.append(source.getName()).append(tab(source.getName().length(), MAXNAMELENGTH)).append("|");
        result.append(source.getTeam()).append(tab(source.getTeam().length(), MAXTEAMLENGTH)).append("|");
        result.append(formatTime(source.getTime())).append(tab(formatTime(source.getTime()).length(), MAXTIMELENGTH));
        currentIndex++;
        return result.toString();
    }

    public String tab(int length, int max) {
        return String.join("", Collections.nCopies(max - length, " "));
    }

    private String addDashboardLine(int length) {
        return Stream.generate(() -> "-").limit(length).collect(Collectors.joining());
    }
}
