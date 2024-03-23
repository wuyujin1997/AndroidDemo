package cn.wuyujin.androiddemo.friendlist;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.wuyujin.androiddemo.R;

public class FriendListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 有 <ListView> 子组件存在的那个 layout
        setContentView(R.layout.activity_friend_list_view);

        List<Friend> friendList = this.mockFriendList(10);
        // 表示每一行 list_item 的 layout
        FriendAdapter adapter = new FriendAdapter(FriendListActivity.this, R.layout.activity_friend_list_item, friendList);

        // <ListView> 的id值( setContentView 处设置的 layout 中的 list_view.id)。
        ListView listView = (ListView) findViewById(R.id.friend_list_view);
        listView.setAdapter(adapter);

    }

    /**
     * 获取一些测试数据
     * @param loopTimes 循环次数
     * @return
     */
    private List<Friend> mockFriendList(int loopTimes) {
        List<Friend> list = new ArrayList<>();
        for (int i = 0; i < loopTimes; i++) {
            list.add(new Friend(R.drawable.img_0307, "name_307", OnlineStatus.WIFI_ONLINE));
            list.add(new Friend(R.drawable.img_0308, "name_308", OnlineStatus.DATA_ONLINE));
            list.add(new Friend(R.drawable.img_0309, "name_309", OnlineStatus.OFFLINE));
            list.add(new Friend(R.drawable.img_0310, "name_310", OnlineStatus.DATA_ONLINE));
            list.add(new Friend(R.drawable.img_0311, "name_311", OnlineStatus.OFFLINE));
            list.add(Friend.builder().avatarId(R.drawable.img_0312).nickname("name_312").onlineStatus(OnlineStatus.WIFI_ONLINE).build());
        }
        return list;
    }

}