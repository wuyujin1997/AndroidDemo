package cn.wuyujin.androiddemo.fragment_base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * <pre><code>
 * Activity 的生命周期方法
 *   onCreate
 *   onStart
 *   onResume
 *   onPause
 *   onStop
 *   onDestroy
 *
 * Fragment 独有的生命周期方法(在包含了上述 Activity 也有的生命周期方法之外)
 *   onAttach
 *   onCreateView
 *   onActivityCreated
 *   onDestroyView
 *   onDetach
 *
 * Fragment 生命周期方法 总结
 *   onAttach
 *   onCreate
 *   onCreateView
 *   onActivityCreated
 *   onStart
 *   onResume
 *   onPause
 *   onStop
 *   onDestroyView
 *   onDestroy
 *   onDetach
 *
 *   运行结果：
 * 2024-03-24 20:40:26.903 FragmentUsageTestActivi  W  Fragment的生命周期：=====》切换Fragment
 * 2024-03-24 20:40:26.916 RightFragment            D  Fragment的生命周期: RightFragment onAttach:
 * 2024-03-24 20:40:26.916 RightFragment            D  Fragment的生命周期: RightFragment onCreate:
 * 2024-03-24 20:40:26.917 RightFragment            D  Fragment的生命周期: RightFragment onActivityCreated:
 * 2024-03-24 20:40:26.919 RightFragment            D  Fragment的生命周期: RightFragment onStart:
 * 2024-03-24 20:40:26.921 RightFragment            D  Fragment的生命周期: RightFragment onResume:
 * 2024-03-24 20:40:38.070 FragmentUsageTestActivi  W  Fragment的生命周期：=====》切换Fragment
 * 2024-03-24 20:40:38.081 RightFragment            D  Fragment的生命周期: RightFragment onPause:
 * 2024-03-24 20:40:38.081 RightFragment            D  Fragment的生命周期: RightFragment onStop:
 * 2024-03-24 20:40:38.082 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onAttach:
 * 2024-03-24 20:40:38.082 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onCreate:
 * 2024-03-24 20:40:38.087 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onActivityCreated:
 * 2024-03-24 20:40:38.088 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onStart:
 * 2024-03-24 20:40:38.090 RightFragment            D  Fragment的生命周期: RightFragment onDestroyView:
 * 2024-03-24 20:40:38.091 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onResume:
 * 2024-03-24 20:40:42.935 FragmentUsageTestActivi  W  Fragment的生命周期：=====》点击了【返回】按钮 (onBackPressed)
 * 2024-03-24 20:40:42.936 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onPause:
 * 2024-03-24 20:40:42.937 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onStop:
 * 2024-03-24 20:40:42.939 RightFragment            D  Fragment的生命周期: RightFragment onActivityCreated:
 * 2024-03-24 20:40:42.939 RightFragment            D  Fragment的生命周期: RightFragment onStart:
 * 2024-03-24 20:40:42.940 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onDestroyView:
 * 2024-03-24 20:40:42.940 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onDestroy:
 * 2024-03-24 20:40:42.940 AnotherRightFragment     D  Fragment的生命周期: AnotherRightFragment onDetach:
 * 2024-03-24 20:40:42.940 RightFragment            D  Fragment的生命周期: RightFragment onResume:
 * 2024-03-24 20:40:44.765 FragmentUsageTestActivi  W  Fragment的生命周期：=====》点击了【返回】按钮 (onBackPressed)
 * 2024-03-24 20:40:44.766 RightFragment            D  Fragment的生命周期: RightFragment onPause:
 * 2024-03-24 20:40:44.767 RightFragment            D  Fragment的生命周期: RightFragment onStop:
 * 2024-03-24 20:40:44.768 RightFragment            D  Fragment的生命周期: RightFragment onDestroyView:
 * 2024-03-24 20:40:44.769 RightFragment            D  Fragment的生命周期: RightFragment onDestroy:
 * 2024-03-24 20:40:44.769 RightFragment            D  Fragment的生命周期: RightFragment onDetach:
 * 2024-03-24 20:40:48.307 FragmentUsageTestActivi  W  Fragment的生命周期：=====》点击了【返回】按钮 (onBackPressed)
 * </code></pre>
 */
public class BaseFragmentForLifecycleLog extends Fragment {
    private String TAG;
    public BaseFragmentForLifecycleLog() {
        TAG = this.getClass().getSimpleName();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onCreateView: ");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "Fragment的生命周期: " + TAG + " onDetach: ");
    }

}
