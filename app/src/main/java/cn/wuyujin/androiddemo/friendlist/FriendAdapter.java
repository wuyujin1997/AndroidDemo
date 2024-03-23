package cn.wuyujin.androiddemo.friendlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.zip.Inflater;

import cn.wuyujin.androiddemo.R;

public class FriendAdapter extends ArrayAdapter<Friend> {
    private static final String TAG = "FriendAdapter";

    private int resourceId;

    public FriendAdapter(@NonNull Context context, int resource, @NonNull List<Friend> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    // 获取当前行的 Friend ，每一行被滚动到屏幕内时会被调用。
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);

        // xml view 相关id获取
//        LayoutInflater inflater = LayoutInflater.from(getContext());
//        View view = inflater.inflate(resourceId, parent, false);

        View view = null;
        FriendItemViewHolder viewHolder = null;
        if (null != convertView) {
            Log.d(TAG, "getView: 复用");
            view = convertView;
            viewHolder = (FriendItemViewHolder) view.getTag();
        } else {
            Log.d(TAG, "getView: 创建新的");
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
//            ImageView avatar = (ImageView) view.findViewById(R.id.friend_avatar);
//            TextView nickname = (TextView) view.findViewById(R.id.friend_nickname);
//            TextView onlineStatus = (TextView) view.findViewById(R.id.online_status);

            viewHolder = new FriendItemViewHolder();
            viewHolder.avatar = (ImageView) view.findViewById(R.id.friend_avatar);
            viewHolder.nickname = (TextView) view.findViewById(R.id.friend_nickname);
            viewHolder.onlineStatus = (TextView) view.findViewById(R.id.online_status);
            view.setTag(viewHolder);
        }


        // 从当前的 object --> view 的当前行
        Friend friend = this.getItem(position);
        // 下拉到底部，上拉到顶部，重复几回。发现同一行对象，会重复创建(view.hashcode 不同)。很浪费资源。
//        2024-03-23 21:47:56.354 FriendAdapter            D  getView: position=10 viewHashCode:51725478  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
//        2024-03-23 21:48:03.055 FriendAdapter            D  getView: position=10 viewHashCode:138316971  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
//        2024-03-23 21:49:03.804 FriendAdapter            D  getView: position=10 viewHashCode:89406511  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
//        2024-03-23 21:49:06.369 FriendAdapter            D  getView: position=10 viewHashCode:235760809  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
//        2024-03-23 21:49:09.370 FriendAdapter            D  getView: position=10 viewHashCode:181596162  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
//        2024-03-23 21:49:12.038 FriendAdapter            D  getView: position=10 viewHashCode:191115799  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
//        2024-03-23 21:49:14.721 FriendAdapter            D  getView: position=10 viewHashCode:18459512  object=Friend{avatarId=2131165412, nickname='name_311', onlineStatus=OFFLINE}
        Log.d(TAG, String.format("getView: position=%s viewHashCode:%s  object=%s", position, view.hashCode(), friend));
        viewHolder.avatar.setImageResource(friend.getAvatarId());
        viewHolder.nickname.setText(friend.getNickname());
        viewHolder.onlineStatus.setText(friend.getOnlineStatus().value());

        return view;
    }
}
