package com.ali.learnandroid.Utils;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import com.ali.learnandroid.R;

public class  Alert_Dialog {

    public void showDialog(final Context context, String Title, String Message) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setCancelable(false);
        dialog.setTitle(Title);
        dialog.setMessage(Message);
        dialog.setIcon(R.drawable.logo);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

}
