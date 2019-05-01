package zc.neu.com.securitystorage.Util;

import android.widget.Toast;
import zc.neu.com.securitystorage.MyApplication;

/**
 * Toast工具类
 * @author renhui
 */
public class ToastUtils {

    public static void show(final String message) {
        Toast.makeText(MyApplication.getInstance(), message, Toast.LENGTH_SHORT).show();
    }

    public static void show(final int resId) {
         show(MyApplication.getInstance().getString(resId));
    }
}
