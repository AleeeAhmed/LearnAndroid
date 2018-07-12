package com.ali.learnandroid.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

import com.ali.learnandroid.R;

import pl.droidsonroids.gif.GifImageView;

public abstract class ZoomGIF {

    public static void show(Activity activity, int drawableGIF) {
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(activity);
        View mView = activity.getLayoutInflater().inflate(R.layout.gif_zoom_dialog, null);
        GifImageView gif = mView.findViewById(R.id.gifView);
        gif.setImageResource(drawableGIF);
        mBuilder.setView(mView);
        mBuilder.setPositiveButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }
}
