package ua.foxminded.nikasgig.formulaoneapplication;

public class LogInformation {

    private String code;
    private String date;
    private String time;

    public LogInformation(String code, String date, String time) {
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

    public String getTime() {
        return time;
    }
}
