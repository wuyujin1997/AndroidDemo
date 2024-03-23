package cn.wuyujin.androiddemo;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MyListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);

        String[] data = {"傅秀英","金军","武娟","邵杰","姜桂英","贺秀英","谭芳","周平","邓洋","万磊","周霞",
                "高磊","尹娟","李桂英","丁秀英","顾涛","潘芳","文霞","郭伟","梁杰" };
        ListAdapter adapter = new ArrayAdapter<>(MyListView.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.my_list_view);
        listView.setAdapter(adapter);

    }

}