package cn.wuyujin.androiddemo.recyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import cn.wuyujin.androiddemo.R;
import cn.wuyujin.androiddemo.friendlist.Friend;
import cn.wuyujin.androiddemo.friendlist.OnlineStatus;

public class MyRecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView.Adapter adapter = new RecyclerFriendAdapter(this.mockFriendList(10));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

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