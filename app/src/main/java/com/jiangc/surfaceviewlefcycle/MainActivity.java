package com.jiangc.surfaceviewlefcycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * 这个例子主要验证了SurfaceView的生命周期
 *  根据日志可以看到，一旦我们的activity执行了onPause，surfaceView就会被销毁
 *  而一旦activity回到前台，执行了onResume(也就是可见了),就会重新创建surfaceView
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    // surfaceview
    private SurfaceView mSurfaceView;
    // surfaceHolder 用来操作surfaceView
    private SurfaceHolder mSurfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSurfaceView = findViewById(R.id.surfaceview);
        mSurfaceHolder = mSurfaceView.getHolder();
        // 设置surfaceView的callback，用来监听SurfaceView的状态
        mSurfaceHolder.addCallback(callback);
    }

    SurfaceHolder.Callback callback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) {
            Log.e(TAG, "surfaceCreated: surfaceView 被创建了");
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
            Log.e(TAG, "surfaceChanged: surfaceView被改变了");
        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
            Log.e(TAG, "surfaceDestroyed: surfaceView被销毁了");
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
        if (null != callback) {
            mSurfaceHolder.removeCallback(callback);
        }
    }
}