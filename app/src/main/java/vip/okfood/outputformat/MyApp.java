package vip.okfood.outputformat;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

/**
 * function:
 *
 * <p>
 * Created by Leo on 2018/9/21.
 */
public class MyApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
