package cn.hugeterry.coordinatortablayout.utils;

import android.content.Context;

/**
 * @author hugeterry(http://hugeterry.cn)
 */

public class SystemView {
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
