# SurfaceView生命周期验证

这个例子主要验证了SurfaceView的生命周期 
根据日志可以看到，一旦我们的activity执行了onPause，surfaceView就会被销毁
而一旦activity回到前台，执行了onResume(也就是可见了),就会重新创建surfaceView
```logcatfilter
// 程序启动
E/MainActivity: onStart: 
E/MainActivity: onResume: 
E/MainActivity: surfaceCreated: surfaceView 被创建了
E/MainActivity: surfaceChanged: surfaceView被改变了

// 按了home键
E/MainActivity: onPause: 
E/MainActivity: surfaceDestroyed: surfaceView被销毁了
E/MainActivity: onStop: 

// 重新回到前台
E/MainActivity: onStart: 
E/MainActivity: onResume: 
E/MainActivity: surfaceCreated: surfaceView 被创建了
E/MainActivity: surfaceChanged: surfaceView被改变了
```