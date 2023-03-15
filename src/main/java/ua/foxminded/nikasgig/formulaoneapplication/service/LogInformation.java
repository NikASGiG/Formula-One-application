package ua.foxminded.nikasgig.formulaoneapplication.service;

import java.time.LocalTime;

public class LogInformation {

    private String code;
    private String date;
    private LocalTime time;

    public LogInformation(String code, String date, LocalTime time) {
        this.code = code;
        this.date = date;
        this.time = time;
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
