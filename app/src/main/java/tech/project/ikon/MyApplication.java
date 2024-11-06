package tech.project.ikon;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application {
    private SharedPreferences sharedPreferences;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();

        mContext = getApplicationContext();
        sharedPreferences = getDefaultSharedPreferences(getApplicationContext());
    }

    public static Context getContext() {
        return mContext;
    }
}
