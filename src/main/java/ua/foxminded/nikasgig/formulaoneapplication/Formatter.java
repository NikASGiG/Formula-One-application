package ua.foxminded.nikasgig.formulaoneapplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Formatter {

    public String format(ArrayList<Dashboard> list) {
        final ArrayList<Dashboard> SOURCE = removeUnderLine(list);
        int maxNameLength = findMaxNameLength(SOURCE);
        int maxTeamLength = findMaxTeamLength(SOURCE);
        int maxTimeLength = SOURCE.get(0).getTime().length();
        return IntStream.range(0, SOURCE.size()).mapToObj(index -> {
            Dashboard dashboard = SOURCE.get(index);
            StringBuilder result = new StringBuilder();
            if (index == 15) {
                result.append(addDashboardLine(maxNameLength + maxTeamLength + maxTimeLength + 6)).append("\n");
            }
            result.append(index + 1).append(".").append(tab(Integer.toString(index + 1).length(), 3));
            result.append(dashboard.getName()).append(tab(dashboard.getName().length(), maxNameLength)).append("|");
            result.append(dashboard.getTeam()).append(tab(dashboard.getTeam().length(), maxTeamLength)).append("|");
            result.append(dashboard.getTime()).append(tab(dashboard.getTime().length(), maxTimeLength)).append("\n");
            return result.toString();
        }).collect(Collectors.joining());
    }

    private ArrayList<Dashboard> removeUnderLine(ArrayList<Dashboard> source) {
        return source.stream().peek(dashboard -> dashboard.setName(dashboard.getName().replace('_', ' ')))
                .peek(dashboard -> dashboard.setTeam(dashboard.getTeam().replace('_', ' ')))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int findMaxTeamLength(ArrayList<Dashboard> source) {
        return source.stream().mapToInt(dashboard -> dashboard.getTeam().length()).max().orElse(0);
    }

    private int findMaxNameLength(ArrayList<Dashboard> source) {
        return source.stream().mapToInt(dashboard -> dashboard.getName().length()).max().orElse(0);
    }

    public String tab(int length, int max) {
        return String.join("", Collections.nCopies(max - length, " "));
    }

    private String addDashboardLine(int length) {
        return Stream.generate(() -> "-").limit(length).collect(Collectors.joining()); // 62
    }
}
