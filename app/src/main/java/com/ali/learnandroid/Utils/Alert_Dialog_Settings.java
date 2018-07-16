package com.ali.learnandroid.Utils;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.ali.learnandroid.Utils.Alert_Dialog_Settings;

import android.net.Uri;
import android.provider.Settings;

import com.ali.learnandroid.R;

public class  Alert_Dialog_Settings {

    public static void showDialog(final Context context, String Title, String Message) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setCancelable(false);
        dialog.setTitle(Title);
        dialog.setMessage(Message);
        dialog.setIcon(R.drawable.logo);
        dialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent();
                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", context.getPackageName(), null);
                intent.setData(uri);
                context.startActivity(intent);
            }
        });
        dialog.setNegativeButton("Cancel", null);
        dialog.show();
    }

}
