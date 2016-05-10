package se.evinja.lbs.lbsapp;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.List;

/**
 * Created by paraply on 2016-05-10.
 */
public class InstalledApps {

    public void getInstalledApps(Context context){
        PackageManager packageManager  = context.getPackageManager();
        List<ApplicationInfo> listApps =  packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo a : listApps){
            Log.i("APP", "Package: " + a.packageName + " " + a.uid);
        }
    }

}
