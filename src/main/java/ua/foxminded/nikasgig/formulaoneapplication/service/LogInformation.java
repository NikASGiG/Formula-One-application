package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;

public class LogInformation {

    private static final int CODE_AND_NAME_POSITION = 0;
    private static final int TIME_POSITION = 1;
    private static final int CODE_LENGTH = 3;
    
    private String code;
    private String date;
    private LocalTime time;

    public LogInformation(String code, String date, LocalTime time) {
        this.code = code;
        this.date = date;
        this.time = time;
    }
    
    public static LogInformation create(String inputLine) {
        String[] parts = inputLine.split("_");
        String code = parts[CODE_AND_NAME_POSITION].substring(CODE_AND_NAME_POSITION, CODE_LENGTH);
        String date = parts[CODE_AND_NAME_POSITION].substring(CODE_LENGTH);
        LocalTime time = LocalTime.parse(parts[TIME_POSITION].replace(" ", "_"));
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
