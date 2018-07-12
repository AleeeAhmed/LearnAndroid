package com.ali.learnandroid.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import com.ali.learnandroid.R;

public class ExitDialog {

    public static void show(final Activity context) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setCancelable(false);
        dialog.setTitle("Closing App");
        dialog.setMessage("Do you want to close Learn Android?");
        dialog.setIcon(R.drawable.logo);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.finishAffinity();
            }
        });
        dialog.setNegativeButton("No", null);
        dialog.show();

    }

}
