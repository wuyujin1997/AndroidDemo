package cn.wuyujin.androiddemo.friendlist;

public class Friend {
    private Integer avatarId;
    private String nickname;
    private OnlineStatus onlineStatus;

    public Friend(Integer avatarId, String nickname, OnlineStatus onlineStatus) {
        this.avatarId = avatarId;
        this.nickname = nickname;
        this.onlineStatus = onlineStatus;
    }

    public String getNickname() {
        return nickname;
    }

    public Integer getAvatarId() {
        return avatarId;
    }

    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "avatarId=" + avatarId +
                ", nickname='" + nickname + '\'' +
                ", onlineStatus=" + onlineStatus +
                '}';
    }
}
