package com.example.phonenumberreceiver;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

/**
 * Created by mithun on 8/29/17.
 */

public class AndroidPermission {
    public static final int PERMISSION_REQUEST_CODE = 1;

    public static boolean checkAndrequestPermission(Context context) {
        boolean currentPermissionStatus = false;
        if (!hasPermission(context)) {
            Toast.makeText(context, "Camera & Storage permissions are required for this demo", Toast.LENGTH_LONG).show();
            requestPermissions(context);
        } else {
            currentPermissionStatus = true;
        }

        return currentPermissionStatus;
    }

    public static boolean hasPermission(Context context) {
        return ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED;
    }

    private static void requestPermissions(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_PHONE_STATE}, PERMISSION_REQUEST_CODE);
        }
    }

}
