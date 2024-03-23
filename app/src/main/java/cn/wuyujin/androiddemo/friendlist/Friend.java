package cn.wuyujin.androiddemo.friendlist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Friend {
    private Integer avatarId;
    private String nickname;
    private OnlineStatus onlineStatus;
}
