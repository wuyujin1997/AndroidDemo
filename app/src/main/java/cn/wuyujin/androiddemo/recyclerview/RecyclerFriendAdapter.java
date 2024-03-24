package cn.wuyujin.androiddemo.recyclerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import cn.wuyujin.androiddemo.R;
import cn.wuyujin.androiddemo.friendlist.Friend;

public class RecyclerFriendAdapter extends RecyclerView.Adapter<RecyclerFriendAdapter.ViewHolder> {
    private static final String TAG = "RecyclerFriendAdapter";

    private List<Friend> dataList;
    public RecyclerFriendAdapter(List<Friend> list) {
        this.dataList = list;
    }

    // list_item 行第一次出现在屏幕才会调用 onCreateViewHolder
    // list_item 行每一次出现在屏幕都会调用 onBindViewHolder
    // so 每一行 list_item 都有自己的一个 ViewHolder 实例。
    @NonNull
    @Override
    public RecyclerFriendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.activity_my_recycler_view, parent, false);
        // 这里一定是 list_item/行/列表的子项目 的layout。
        View view = inflater.inflate(R.layout.activity_my_recycler_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        // 注册 listener for click （为最外层layout 和内部的子组件绑定listener）
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend clickFriend = dataList.get(holder.getAdapterPosition());
                Toast.makeText(v.getContext(), "item 被点击 " + clickFriend.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.friendAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend clickFriend = dataList.get(holder.getAdapterPosition());
                Toast.makeText(v.getContext(), "头像： " + clickFriend.getAvatarId(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.friendNickname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend clickFriend = dataList.get(holder.getAdapterPosition());
                Toast.makeText(v.getContext(), "nickName： " + clickFriend.getNickname(), Toast.LENGTH_SHORT).show();
            }
        });
        holder.friendOnlineStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Friend clickFriend = dataList.get(holder.getAdapterPosition());
                Toast.makeText(v.getContext(), "在线状态： " + clickFriend.getOnlineStatus(), Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    // 第 position 个位置的对象-->行view的转换/绑定
    @Override
    public void onBindViewHolder(@NonNull RecyclerFriendAdapter.ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + holder);
        Friend friend = dataList.get(position);
        holder.friendAvatar.setImageResource(friend.getAvatarId());
        holder.friendNickname.setText(friend.getNickname());
        holder.friendOnlineStatus.setText(friend.getOnlineStatus().value());
    }

    @Override
    public int getItemCount() {
        int itemCount = dataList.size();
//        Log.d(TAG, "getItemCount: " + itemCount);
        return itemCount;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View lineItemView;
        ImageView friendAvatar;
        TextView friendNickname;
        TextView friendOnlineStatus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            lineItemView = itemView;
            friendAvatar = (ImageView) itemView.findViewById(R.id.rv_friend_avatar);
            friendNickname = (TextView) itemView.findViewById(R.id.rv_friend_nickname);
            friendOnlineStatus = (TextView) itemView.findViewById(R.id.rv_online_status);
        }
    }

}
