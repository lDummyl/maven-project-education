package taskXI;

public class UserLogs {
    long unixTime;
    String userID;
    String url;
    long qtySecondsUserSpend;

    public UserLogs() {
    }

    public UserLogs(long unixTime, String userID, String url, long qtySecondsUserSpend) {
        this.unixTime = unixTime;
        this.userID = userID;
        this.url = url;
        this.qtySecondsUserSpend = qtySecondsUserSpend;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getQtySecondsUserSpend() {
        return qtySecondsUserSpend;
    }

    public void setQtySecondsUserSpend(int qtySecondsUserSpend) {
        this.qtySecondsUserSpend = qtySecondsUserSpend;
    }

    @Override
    public String toString() {
        return "UserLogs{" +
                "unixTime=" + unixTime +
                ", userID='" + userID + '\'' +
                ", url='" + url + '\'' +
                ", qtySecondsUserSpend=" + qtySecondsUserSpend +
                '}';
    }
}

