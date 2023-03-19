package ua.foxminded.nikasgig.formulaone.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogInformation {

    private static final int CODE_NAME_INDEX = 0;
    private static final int TIME_INDEX = 1;
    private static final int CODE_LENGTH = 3;
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    private String code;
    private String date;
    private LocalTime time;

    public LogInformation(String code, String date, LocalTime time) {
        this.code = code;
        this.date = date;
        this.time = time;
    }

    public static LogInformation create(String inputLine) {
        String[] tokens = inputLine.split("_");
        String code = tokens[CODE_NAME_INDEX].substring(CODE_NAME_INDEX, CODE_LENGTH);
        String date = tokens[CODE_NAME_INDEX].substring(CODE_LENGTH);
        LocalTime time = LocalTime.parse(tokens[TIME_INDEX], TIME_FORMATTER);
        return new LogInformation(code, date, time);
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
