package se.evinja.lbs.lbsapp;

import android.content.SharedPreferences;

        import android.content.Context;
        import android.content.SharedPreferences;
        import android.provider.Settings;

        import java.util.UUID;

/**
 * Created by mike on 2016-05-07.
 */
public class UniqueID {
    private SharedPreferences sharedPreferences;
    private final String USER_INFORMATION = "USER_INFORMATION",USER_ID = "USER_ID";

    public String getID(Context context){
        sharedPreferences = context.getSharedPreferences(USER_INFORMATION , Context.MODE_PRIVATE);
        String uid = sharedPreferences.getString(USER_ID, "");

        if (uid.isEmpty()){ // We have not yet saved an ID
            // Try to get from device
            uid = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
            if (uid.isEmpty() || uid.equals("0")){ // If the device failed to retrive unique ID. Generate a random one.
                uid = UUID.randomUUID().toString();
            }
            // Save ID to preferences. It will remain as long as this applications data remains.
            // Can remain even if user changes device and restores app-data from backup
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(USER_ID, uid);

        }
        return uid;
    }
}
