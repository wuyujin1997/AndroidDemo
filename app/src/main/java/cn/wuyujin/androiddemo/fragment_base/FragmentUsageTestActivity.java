package cn.wuyujin.androiddemo.fragment_base;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import cn.wuyujin.androiddemo.R;

public class FragmentUsageTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_usage_test);

        Button replaceFragmentBtn = (Button) findViewById(R.id.btn_at_left_fragment);
        replaceFragmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new AnotherRightFragment());
            }
        });

        replaceFragment(new RightFragment());

    }
    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_layout, fragment);

        // 模拟返回栈
        // 效果：按手机导航的返回按钮之后，不会一次性直接推出。而是一个一个【回到上一个Fragment】，最后才退出。
        transaction.addToBackStack(null);

        transaction.commit();
    }

}