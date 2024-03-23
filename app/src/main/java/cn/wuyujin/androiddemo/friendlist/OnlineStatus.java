package cn.wuyujin.androiddemo.friendlist;

public enum OnlineStatus {

    WIFI_ONLINE("WiFi在线"),
    DATA_ONLINE("5G在线"),
    OFFLINE("离线");

    private String status;
    private OnlineStatus(String status) {
        this.status = status;
    }
    public String value() {
        return this.status;
    }

}
