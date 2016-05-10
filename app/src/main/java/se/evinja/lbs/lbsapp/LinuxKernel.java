package se.evinja.lbs.lbsapp;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Philip on 2016-05-10.
 */
public class LinuxKernel {
    public void runCommand(String command) {
        try {
            Process p = Runtime.getRuntime().exec(command);
            InputStream is = p.getInputStream();
            Scanner scanner = new Scanner(is);
            while (scanner.hasNextLine()) {
                Log.i("Linux", scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
