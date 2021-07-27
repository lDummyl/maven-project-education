package taskXI;

public class OutgoingFile {
    String userID;
    String url;
    long average;

    public OutgoingFile(String userID, String url, long average) {
        this.userID = userID;
        this.url = url;
        this.average = average;
    }

    @Override
    public String toString() {
        return "OutgoingFile{" +
                "userID='" + userID + '\'' +
                ", url='" + url + '\'' +
                ", average=" + average +
                '}';
    }
}
