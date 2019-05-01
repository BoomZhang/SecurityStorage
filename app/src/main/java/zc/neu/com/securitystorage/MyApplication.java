package zc.neu.com.securitystorage;

import android.app.Application;
import android.os.Handler;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import zc.neu.com.securitystorage.Util.DebugTraceTool;

public class MyApplication extends Application {

    private static MyApplication mInstance;
    private Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mHandler = new Handler();
        DebugTraceTool.debugTraceE(this, "application onCreate");

        // 初始化图片加载控件
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(config);
    }

    public static MyApplication getInstance() {
        return mInstance;
    }

    public static Handler getHandler() {
        return getInstance().mHandler;
    }

}
