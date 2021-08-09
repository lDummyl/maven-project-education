package taskXI;

import java.time.LocalDate;

public class OutgoingFile {
    String userID;
    String url;
    long average;
    LocalDate date;

    public OutgoingFile(String userID, String url, long average) {
        this.userID = userID;
        this.url = url;
        this.average = average;
    }

    public OutgoingFile(String userID, String url, long average, LocalDate date) {
        this.userID = userID;
        this.url = url;
        this.average = average;
        this.date = date;
    }

    public void setAverage(long average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "OutgoingFile{" +
                "userID='" + userID + '\'' +
                ", url='" + url + '\'' +
                ", average=" + average +
                ", date=" + date +
                '}';
    }
}
