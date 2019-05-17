package model;

public class Test {
    private String message;
    private String to;
    private String from;
    private String timeToLifeSec;

    public Test(String message, String to, String from, String timeToLifeSec) {
        this.message = message;
        this.to = to;
        this.from = from;
        this.timeToLifeSec = timeToLifeSec;
    }

    public String getTo() {
        return to;
    }
}
